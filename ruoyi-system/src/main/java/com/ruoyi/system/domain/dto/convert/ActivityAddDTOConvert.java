package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.activity.ActivityAddBo;
import com.ruoyi.system.domain.dto.active.ActivityAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

/**
 * DTO -> BO
 */
public class ActivityAddDTOConvert implements ClassConvertTool<ActivityAddDto, ActivityAddBo> {
    @Override
    public ActivityAddBo convert(ActivityAddDto activityAddDto) {
        ActivityAddBo activityAddBo = new ActivityAddBo();
        BeanUtils.copyProperties(activityAddDto, activityAddBo);

        // 增加值
        activityAddBo.setCreateTime(DateUtils.getTime());
        activityAddBo.setCreateBy("admin");
        activityAddBo.setDelFlag('0');
        activityAddBo.setUpdateTime(DateUtils.getTime());
        activityAddBo.setUpdateBy("admin");

        return activityAddBo;
    }
}
