package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.domain.bo.activity.ActivitySearchBo;

import java.util.List;

public interface IActivityMapper {
    // 查询 activity 数量
    Long countActivity();

    // 检查 banner 是否发布
    Long checkRelease(Long activityId);

    List<BActivityPo> selectActivity();

    List<BActivityPo> queryByCondition(ActivitySearchBo activitySearchBo);

    void insertActivityByCondition(BActivityPo activityPo);

    void updateActivityByCondition(BActivityPo activityPo);

    void patchActivityByCondition(Long activityId);

    void unReleaseActivity(Long activityId);

    void releaseBanner(Long activityId);
}
