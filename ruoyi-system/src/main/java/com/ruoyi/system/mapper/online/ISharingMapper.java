package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.po.BSharingPo;
import com.ruoyi.system.domain.bo.sharing.SharingSearchBo;

import java.util.List;

public interface ISharingMapper {
    // 查询 sharing 数量
    Long countSharing();

    // 检查 sharing 是否发布
    Long checkRelease(Long sharingId);

    List<BSharingPo> selectSharing();

    Long countUseSharing(SharingSearchBo sharingSearchBo);

    List<BSharingPo> querySharingByCondition(SharingSearchBo sharingSearchBo);

    void insertSharingByCondition(BSharingPo sharingPo);

    void updateSharingByCondition(BSharingPo sharingPo);

    void patchSharingByCondition(Long sharingId);

    void unReleaseSharing(Long sharingId);

    void releaseSharing(Long sharingId);
}
