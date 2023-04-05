package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.banner.BannerAddBo;
import com.ruoyi.system.domain.po.BBannerPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class BannerAddBOConvert implements ClassConvertTool<BannerAddBo, BBannerPo> {
    @Override
    public BBannerPo convert(BannerAddBo bannerAddBo) {
        BBannerPo bannerPo = new BBannerPo();
        BeanUtils.copyProperties(bannerAddBo, bannerPo);

        return bannerPo;
    }
}
