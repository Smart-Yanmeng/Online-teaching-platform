package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.banner.BannerAddBo;
import com.ruoyi.system.domain.dto.banner.BannerAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class BannerAddDTOConvert implements ClassConvertTool<BannerAddDto, BannerAddBo> {
    @Override
    public BannerAddBo convert(BannerAddDto bannerAddDto) {
        BannerAddBo bannerAddBo = new BannerAddBo();
        BeanUtils.copyProperties(bannerAddDto, bannerAddBo);

        // 增加值
        bannerAddBo.setCreateTime(DateUtils.getTime());
        bannerAddBo.setCreateBy("admin");
        bannerAddBo.setDelFlag('0');
        bannerAddBo.setUpdateTime(DateUtils.getTime());
        bannerAddBo.setUpdateBy("admin");

        return bannerAddBo;
    }
}
