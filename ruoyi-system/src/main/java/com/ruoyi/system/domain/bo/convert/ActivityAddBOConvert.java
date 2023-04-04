package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.activity.ActivityAddBo;
import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

/**
 * BO -> PO
 */
public class ActivityAddBOConvert implements ClassConvertTool<ActivityAddBo, BActivityPo> {
    @Override
    public BActivityPo convert(ActivityAddBo activityAddBo) {
        BActivityPo activityPo = new BActivityPo();
        BeanUtils.copyProperties(activityAddBo, activityPo);

        return activityPo;
    }
}
