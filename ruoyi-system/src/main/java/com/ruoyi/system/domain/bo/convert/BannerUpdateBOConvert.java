package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.banner.BannerUpdateBo;
import com.ruoyi.system.domain.po.BBannerPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class BannerUpdateBOConvert implements ClassConvertTool<BannerUpdateBo, BBannerPo> {
    @Override
    public BBannerPo convert(BannerUpdateBo bannerUpdateBo) {
        BBannerPo bannerPo = new BBannerPo();
        BeanUtils.copyProperties(bannerUpdateBo, bannerPo);

        return bannerPo;
    }
}
