package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BBannerPo;
import com.ruoyi.system.domain.vo.online.BannerInfoVo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class BannerPOConvert implements ClassConvertTool<BBannerPo, BannerInfoVo> {
    @Override
    public BannerInfoVo convert(BBannerPo bBannerPo) {
        BannerInfoVo bannerInfoVo = new BannerInfoVo();
        BeanUtils.copyProperties(bBannerPo, bannerInfoVo);

        return bannerInfoVo;
    }
}
