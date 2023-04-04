package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.domain.vo.online.ActivityInfoVo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

/**
 * PO -> VO
 */
public class ActivityPOConvert implements ClassConvertTool<BActivityPo, ActivityInfoVo> {
    @Override
    public ActivityInfoVo convert(BActivityPo activityPo) {
        ActivityInfoVo activityInfoVo = new ActivityInfoVo();
        BeanUtils.copyProperties(activityPo, activityInfoVo);

        return activityInfoVo;
    }
}
