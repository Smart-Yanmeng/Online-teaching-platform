package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.activity.ActivityUpdateBo;
import com.ruoyi.system.domain.dto.active.ActivityUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

/**
 * DTO -> BO
 */
public class ActivityUpdateDTOConvert implements ClassConvertTool<ActivityUpdateDto, ActivityUpdateBo> {
    @Override
    public ActivityUpdateBo convert(ActivityUpdateDto activityUpdateDto) {
        ActivityUpdateBo activityUpdateBo = new ActivityUpdateBo();
        BeanUtils.copyProperties(activityUpdateDto, activityUpdateBo);

        // 增加值
        activityUpdateBo.setUpdateTime(DateUtils.getTime());
        activityUpdateBo.setUpdateBy("admin");

        return activityUpdateBo;
    }
}
