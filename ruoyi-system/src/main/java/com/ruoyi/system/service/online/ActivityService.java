package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.bo.activity.ActivityAddBo;
import com.ruoyi.system.domain.bo.activity.ActivityUpdateBo;
import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.domain.po.convert.ActivityAddBOConvert;
import com.ruoyi.system.domain.po.convert.ActivityUpdateBOConvert;
import com.ruoyi.system.domain.vo.online.ActivityInfoVo;
import com.ruoyi.system.domain.bo.activity.ActivitySearchBo;
import com.ruoyi.system.domain.dto.active.ActivityUpdateDto;
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
     * @return
     */
    public List<ActivityInfoVo> selectActivityList() {
        List<BActivityPo> activityPos = activityMapper.selectActivity();

        return activityPos.stream().map(item -> new ActivityInfoVo().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 查询活动
     *
     * @param activitySearchBo
     * @return
     */
    public List<ActivityInfoVo> queryActivityList(ActivitySearchBo activitySearchBo) {
        List<BActivityPo> activityEntities = activityMapper.queryByCondition(activitySearchBo);

        return activityEntities.stream().map(item -> new ActivityInfoVo().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 新增活动
     *
     * @param activityAddBo
     */
    public void insertActivity(ActivityAddBo activityAddBo) {
        BActivityPo activityPo = new ActivityAddBOConvert().convert(activityAddBo);
        activityPo.setActivityId(activityMapper.countActivity() + 1);

        activityMapper.insertActivityByCondition(activityPo);
    }

    /**
     * 修改活动
     *
     * @param activityUpdateBo
     */
    public void updateActivity(ActivityUpdateBo activityUpdateBo) {
        BActivityPo activityPo = new ActivityUpdateBOConvert().convert(activityUpdateBo);

        activityMapper.updateActivityByCondition(activityPo);
    }

    /**
     * 删除活动
     *
     * @param activityId
     */
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
