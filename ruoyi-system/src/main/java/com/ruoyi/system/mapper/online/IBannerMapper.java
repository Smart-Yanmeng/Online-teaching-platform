package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BBannerEntity;
import com.ruoyi.system.domain.vo.banner.BannerSearchVo;
import com.ruoyi.system.domain.vo.banner.BannerUpdateVo;

import java.util.List;

public interface IBannerMapper {
    // 查询 banner 数量
    Long countBanner();

    // 检查 banner 是否发布
    Long checkRelease(Long bannerId);

    List<BBannerEntity> selectBanner();

    List<BBannerEntity> queryBannerByCondition(BannerSearchVo bannerSearchVo);

    void insertBannerByCondition(BBannerEntity bannerEntity);

    void updateBannerByCondition(BannerUpdateVo bannerUpdateVo);

    void deleteBannerByCondition(Long bannerId);

    void unReleaseBanner(Long bannerId);

    void releaseBanner(Long bannerId);
}