package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.po.BSharingEntity;
import com.ruoyi.system.domain.vo.online.SharingInfoView;
import com.ruoyi.system.domain.bo.sharing.SharingAddVo;
import com.ruoyi.system.domain.bo.sharing.SharingSearchVo;
import com.ruoyi.system.domain.bo.sharing.SharingUpdateVo;
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
     * @return
     */
    public List<SharingInfoView> selectSharingList() {
        List<BSharingEntity> sharingEntities = sharingMapper.selectSharing();

        return sharingEntities.stream().map(item -> new SharingInfoView().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 查询分享
     *
     * @param sharingSearchVo
     * @return
     */
    public List<SharingInfoView> querySharingList(SharingSearchVo sharingSearchVo) {
        List<BSharingEntity> sharingEntities = sharingMapper.querySharingByCondition(sharingSearchVo);

        return sharingEntities.stream().map(item -> new SharingInfoView().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 新增分享
     *
     * @param sharingAddVo
     */
    public void insertSharing(SharingAddVo sharingAddVo) {
        BSharingEntity sharingEntity = new BSharingEntity();
        sharingEntity = sharingAddVo.transfer(sharingEntity);
        sharingEntity.setSharingId(sharingMapper.countSharing() + 1);

        sharingMapper.insertSharingByCondition(sharingEntity);
    }

    /**
     * 批量删除分享
     *
     * @param sharingIdArr
     */
    public void patchSharingAll(Long[] sharingIdArr) {
        for (Long item : sharingIdArr) {
            sharingMapper.patchSharingByCondition(item);
        }
    }

    /**
     * 修改分享
     *
     * @param sharingUpdateVo
     */
    public void updateSharing(SharingUpdateVo sharingUpdateVo) {
//        sharingUpdateVo.setUpdateBy(SecurityUtils.getUsername());
        sharingUpdateVo.setUpdateBy("admin");
        sharingUpdateVo.setUpdateTime(DateUtils.getTime());

        sharingMapper.updateSharingByCondition(sharingUpdateVo);
    }

    /**
     * 删除分享
     *
     * @param sharingId
     */
    public void patchSharing(Long sharingId) {
        sharingMapper.patchSharingByCondition(sharingId);
    }

    /**
     * 发布分享
     *
     * @param sharingId
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
