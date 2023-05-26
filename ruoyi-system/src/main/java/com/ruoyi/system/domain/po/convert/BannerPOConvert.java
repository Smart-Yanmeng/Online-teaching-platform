package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BBannerPo;
import com.ruoyi.system.domain.vo.online.BannerInfo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class BannerPOConvert implements ClassConvertTool<BBannerPo, BannerInfo> {
    @Override
    public BannerInfo convert(BBannerPo bBannerPo) {
        BannerInfo bannerInfo = new BannerInfo();
        BeanUtils.copyProperties(bBannerPo, bannerInfo);

        return bannerInfo;
    }
}
