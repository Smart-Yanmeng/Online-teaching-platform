package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.activity.ActivityUpdateBo;
import com.ruoyi.system.domain.po.BActivityPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

/**
 * BO -> PO
 */
public class ActivityUpdateBOConvert implements ClassConvertTool<ActivityUpdateBo, BActivityPo> {
    @Override
    public BActivityPo convert(ActivityUpdateBo activityUpdateBo) {
        BActivityPo activityPo = new BActivityPo();
        BeanUtils.copyProperties(activityUpdateBo, activityPo);

        return activityPo;
    }
}
