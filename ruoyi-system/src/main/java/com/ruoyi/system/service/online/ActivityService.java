package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.bo.activity.ActivityAddBo;
import com.ruoyi.system.domain.bo.activity.ActivityUpdateBo;
import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.domain.bo.convert.ActivityAddBOConvert;
import com.ruoyi.system.domain.bo.convert.ActivityUpdateBOConvert;
import com.ruoyi.system.domain.po.convert.ActivityPOConvert;
import com.ruoyi.system.domain.vo.online.ActivityInfo;
import com.ruoyi.system.domain.bo.activity.ActivitySearchBo;
import com.ruoyi.system.mapper.online.IActivityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Resource
    IActivityMapper activityMapper;

    /**
     * 刷新 - 重置活动列表
     *
     * @return List<ActivityInfoVo>
     */
    public List<ActivityInfo> selectActivityList() {
        List<BActivityPo> activityPos = activityMapper.selectActivity();

        return activityPos.stream().map(item -> new ActivityPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 可用活动数量
     *
     * @param activitySearchBo 查询条件
     * @return Long
     */
    public Long activitySum(ActivitySearchBo activitySearchBo) {
        return activityMapper.countUseActivity(activitySearchBo);
    }

    /**
     * 查询活动
     *
     * @param activitySearchBo 查询活动条件
     * @return List<ActivityInfoVo>
     */
    public List<ActivityInfo> queryActivityList(ActivitySearchBo activitySearchBo) {
        List<BActivityPo> activityEntities = activityMapper.queryByCondition(activitySearchBo);

        return activityEntities.stream().map(item -> new ActivityPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 新增活动
     *
     * @param activityAddBo 增加活动参数
     */
    public void insertActivity(ActivityAddBo activityAddBo) {
        BActivityPo activityPo = new ActivityAddBOConvert().convert(activityAddBo);
        activityPo.setActivityId(activityMapper.countActivity() + 1);

        activityMapper.insertActivityByCondition(activityPo);
    }

    /**
     * 批量删除活动
     *
     * @param activityArr 活动 ID 数组
     */
    public void patchActivityAll(Long[] activityArr) {
        for (Long item : activityArr) {
            activityMapper.patchActivityByCondition(item);
        }
    }

    /**
     * 修改活动
     *
     * @param activityUpdateBo 修改活动参数
     */
    public void updateActivity(ActivityUpdateBo activityUpdateBo) {
        BActivityPo activityPo = new ActivityUpdateBOConvert().convert(activityUpdateBo);

        activityMapper.updateActivityByCondition(activityPo);
    }

    /**
     * 删除活动
     *
     * @param activityId 活动 ID
     */
    public void patchActivity(Long activityId) {
        activityMapper.patchActivityByCondition(activityId);
    }

    /**
     * 发布 / 取消发布活动
     *
     * @param activityId 活动 ID
     */
    public boolean releaseActivity(Long activityId) {
        if (activityMapper.checkRelease(activityId) == 1) {
            activityMapper.unReleaseActivity(activityId);
            return false;
        } else {
            activityMapper.releaseBanner(activityId);
            return true;
        }
    }
}
