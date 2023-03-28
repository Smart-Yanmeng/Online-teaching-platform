package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.entity.BActivityEntity;
import com.ruoyi.system.domain.view.ActivityInfoView;
import com.ruoyi.system.domain.vo.activity.ActivityAddVo;
import com.ruoyi.system.domain.vo.activity.ActivitySearchVo;
import com.ruoyi.system.domain.vo.activity.ActivityUpdateVo;
import com.ruoyi.system.mapper.online.IActivityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Resource
    IActivityMapper activityMapper;

    // 刷新 - 重置活动信息
    public List<ActivityInfoView> selectActivityList() {
        List<BActivityEntity> activityEntities = activityMapper.selectActivity();

        return activityEntities.stream().map(item -> new ActivityInfoView().transfer(item)).collect(Collectors.toList());
    }

    // 查询活动
    public List<ActivityInfoView> queryActivityList(ActivitySearchVo activitySearchVo) {
        List<BActivityEntity> activityEntities = activityMapper.queryByCondition(activitySearchVo);

        return activityEntities.stream().map(item -> new ActivityInfoView().transfer(item)).collect(Collectors.toList());
    }

    // 插入活动
    public void insertActivity(ActivityAddVo activityAddVo) {
        BActivityEntity activityEntity = new BActivityEntity();
        activityEntity = activityAddVo.transfer(activityEntity);
        activityEntity.setActivityId(activityMapper.countActivity() + 1);

        activityMapper.insertActivityByCondition(activityEntity);
    }

    // 修改数据
    public void updateActivity(ActivityUpdateVo activityUpdateVo) {
//        activityUpdateVo.setUpdateBy(SecurityUtils.getUsername());
        activityUpdateVo.setUpdateBy("admin");
        activityUpdateVo.setUpdateTime(DateUtils.getTime());

        activityMapper.updateActivityByCondition(activityUpdateVo);
    }

    // 删除数据
    public void patchActivity(Long activityId) {
        activityMapper.patchActivityByCondition(activityId);
    }

    /**
     * 发布 / 取消发布活动
     *
     * @param activityId
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
