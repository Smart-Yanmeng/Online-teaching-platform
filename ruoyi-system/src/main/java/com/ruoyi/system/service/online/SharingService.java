package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.entity.BSharingEntity;
import com.ruoyi.system.domain.view.SharingInfoView;
import com.ruoyi.system.domain.vo.sharing.SharingAddVo;
import com.ruoyi.system.domain.vo.sharing.SharingSearchVo;
import com.ruoyi.system.domain.vo.sharing.SharingUpdateVo;
import com.ruoyi.system.mapper.online.ISharingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SharingService {
    @Autowired
    ISharingMapper sharingMapper;

    // 刷新 - 重置分享信息
    public List<SharingInfoView> selectSharingList() {
        List<BSharingEntity> sharingEntities = sharingMapper.selectSharing();

        return sharingEntities.stream().map(item -> new SharingInfoView().transfer(item)).collect(Collectors.toList());
    }

    // 查询分享
    public List<SharingInfoView> querySharingList(SharingSearchVo sharingSearchVo) {
        List<BSharingEntity> sharingEntities = sharingMapper.querySharingByCondition(sharingSearchVo);

        return sharingEntities.stream().map(item -> new SharingInfoView().transfer(item)).collect(Collectors.toList());
    }

    // 插入数据
    public void insertSharing(SharingAddVo sharingAddVo) {
        BSharingEntity sharingEntity = new BSharingEntity();
        sharingEntity = sharingAddVo.transfer(sharingEntity);
        sharingEntity.setSharingId(sharingMapper.countSharing() + 1);

        sharingMapper.insertSharingByCondition(sharingEntity);
    }

    // 修改数据
    public void updateSharing(SharingUpdateVo sharingUpdateVo) {
//        sharingUpdateVo.setUpdateBy(SecurityUtils.getUsername());
        sharingUpdateVo.setUpdateBy("admin");
        sharingUpdateVo.setUpdateTime(DateUtils.getTime());

        sharingMapper.updateSharingByCondition(sharingUpdateVo);
    }

    // 删除数据
    public void deleteSharing(Long sharingId) {
        sharingMapper.deleteSharingByCondition(sharingId);
    }

    // 发布数据
    public void releaseSharing(Long sharingId) {
        if (sharingMapper.checkRelease(sharingId) == 1) sharingMapper.unReleaseSharing(sharingId);
        else sharingMapper.releaseSharing(sharingId);
    }
}
