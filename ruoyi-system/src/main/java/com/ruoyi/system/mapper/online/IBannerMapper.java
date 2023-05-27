package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.po.BBannerPo;
import com.ruoyi.system.domain.bo.banner.BannerSearchBo;

import java.util.List;

public interface IBannerMapper {
    // 查询 banner 总共数量
    Long countBanner();

    // 查询 banner 可用数量
    Long countUseBanner(BannerSearchBo bannerSearchBo);

    // 检查 banner 是否发布
    Long checkRelease(Long bannerId);

    List<BBannerPo> selectBanner();

    List<BBannerPo> queryBannerByCondition(BannerSearchBo bannerSearchBo);

    void insertBannerByCondition(BBannerPo bannerPo);

    void updateBannerByCondition(BBannerPo bannerPo);

    void patchBannerByCondition(Long bannerId);

    void unReleaseBanner(Long bannerId);

    void releaseBanner(Long bannerId);
}
