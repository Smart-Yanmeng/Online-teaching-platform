package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.bo.convert.SharingAddBOConvert;
import com.ruoyi.system.domain.bo.convert.SharingBOConvert;
import com.ruoyi.system.domain.bo.sharing.SharingAddBo;
import com.ruoyi.system.domain.bo.sharing.SharingUpdateBo;
import com.ruoyi.system.domain.po.BSharingPo;
import com.ruoyi.system.domain.po.convert.SharingPOConvert;
import com.ruoyi.system.domain.vo.online.sharing.SharingInfo;
import com.ruoyi.system.domain.bo.sharing.SharingSearchBo;
import com.ruoyi.system.mapper.online.ISharingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SharingService {
    @Resource
    ISharingMapper sharingMapper;

    /**
     * 刷新 - 重置分享
     *
     * @return List<SharingInfoVo>
     */
    public List<SharingInfo> selectSharingList() {
        List<BSharingPo> bSharingPos = sharingMapper.selectSharing();

        return bSharingPos.stream().map(item -> new SharingPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 查询分享
     *
     * @param sharingSearchBo 查询分享条件
     * @return List<SharingInfoVo>
     */
    public List<SharingInfo> querySharingList(SharingSearchBo sharingSearchBo) {
        List<BSharingPo> sharingPos = sharingMapper.querySharingByCondition(sharingSearchBo);

        return sharingPos.stream().map(item -> new SharingPOConvert().convert(item)).collect(Collectors.toList());
    }

    public Long countUseSharing(SharingSearchBo sharingSearchBo) {
        return sharingMapper.countUseSharing(sharingSearchBo);
    }

    /**
     * 新增分享
     *
     * @param sharingAddBo 新增分享信息
     */
    public void insertSharing(SharingAddBo sharingAddBo) {
        BSharingPo sharingPo = new SharingAddBOConvert().convert(sharingAddBo);
        sharingPo.setSharingId(sharingMapper.countSharing() + 1);

        sharingMapper.insertSharingByCondition(sharingPo);
    }

    /**
     * 批量删除分享
     *
     * @param sharingIdArr 分享 ID 集合
     */
    public void patchSharingAll(Long[] sharingIdArr) {
        for (Long item : sharingIdArr) {
            sharingMapper.patchSharingByCondition(item);
        }
    }

    /**
     * 修改分享
     *
     * @param sharingUpdateBo 修改分享信息
     */
    public void updateSharing(SharingUpdateBo sharingUpdateBo) {
        BSharingPo sharingPo = new SharingBOConvert().convert(sharingUpdateBo);
        sharingMapper.updateSharingByCondition(sharingPo);
    }

    /**
     * 删除分享
     *
     * @param sharingId 分享 ID
     */
    public void patchSharing(Long sharingId) {
        sharingMapper.patchSharingByCondition(sharingId);
    }

    /**
     * 发布分享
     *
     * @param sharingId 分享 ID
     */
    public Boolean releaseSharing(Long sharingId) {
        if (sharingMapper.checkRelease(sharingId) == 1) {
            sharingMapper.unReleaseSharing(sharingId);
            return false;
        } else {
            sharingMapper.releaseSharing(sharingId);
            return true;
        }
    }
}
