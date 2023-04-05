package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.banner.BannerUpdateBo;
import com.ruoyi.system.domain.dto.banner.BannerUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class BannerUpdateDTOConvert implements ClassConvertTool<BannerUpdateDto, BannerUpdateBo> {
    @Override
    public BannerUpdateBo convert(BannerUpdateDto bannerUpdateDto) {
        BannerUpdateBo bannerUpdateBo = new BannerUpdateBo();
        BeanUtils.copyProperties(bannerUpdateDto, bannerUpdateBo);

        return bannerUpdateBo;
    }
}
