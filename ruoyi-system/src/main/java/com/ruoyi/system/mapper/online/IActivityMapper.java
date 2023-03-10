package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BActivityEntity;
import com.ruoyi.system.domain.vo.activity.ActivitySearchVo;
import com.ruoyi.system.domain.vo.activity.ActivityUpdateVo;

import java.util.List;

public interface IActivityMapper {
    // 查询 activity 数量
    Long countActivity();

    // 检查 banner 是否发布
    Long checkRelease(Long activityId);

    List<BActivityEntity> selectActivity();

    List<BActivityEntity> queryByCondition(ActivitySearchVo activitySearchVo);

    void insertActivityByCondition(BActivityEntity activityEntity);

    void updateActivityByCondition(ActivityUpdateVo activityUpdateVo);

    void deleteActivityByCondition(Long activityId);

    void unReleaseActivity(Long activityId);

    void releaseBanner(Long activityId);
}
