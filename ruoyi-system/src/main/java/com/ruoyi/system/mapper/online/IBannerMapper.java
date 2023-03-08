package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BBannerEntity;
import com.ruoyi.system.domain.vo.banner.BannerAddVo;

import java.util.List;

public interface IBannerMapper {
    List<BBannerEntity> selectBanner();

    List<BBannerEntity> queryBannerBuCondition(BannerAddVo bannerAddVo);
}