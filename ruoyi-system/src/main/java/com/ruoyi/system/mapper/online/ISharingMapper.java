package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BSharingEntity;
import com.ruoyi.system.domain.vo.sharing.SharingAddVo;
import com.ruoyi.system.domain.vo.sharing.SharingSearchVo;
import com.ruoyi.system.domain.vo.sharing.SharingUpdateVo;

import java.util.List;

public interface ISharingMapper {
    // 查询 sharing 数量
    Long countSharing();

    // 检查 sharing 是否发布
    Long checkRelease(Long sharingId);

    List<BSharingEntity> selectSharing();

    List<BSharingEntity> querySharingByCondition(SharingSearchVo sharingSearchVo);

    List<SharingAddVo> insertSharingByCondition(BSharingEntity sharingEntity);

    void updateSharingByCondition(SharingUpdateVo sharingUpdateVo);

    void deleteSharingByCondition(Long sharingId);

    void unReleaseSharing(Long sharingId);

    void releaseSharing(Long sharingId);
}
