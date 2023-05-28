package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.domain.vo.online.activity.ActivityInfo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

/**
 * PO -> VO
 */
public class ActivityPOConvert implements ClassConvertTool<BActivityPo, ActivityInfo> {
    @Override
    public ActivityInfo convert(BActivityPo activityPo) {
        ActivityInfo activityInfo = new ActivityInfo();
        BeanUtils.copyProperties(activityPo, activityInfo);

        return activityInfo;
    }
}
