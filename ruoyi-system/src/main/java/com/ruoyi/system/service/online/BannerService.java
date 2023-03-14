package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.vo.banner.BannerAddVo;
import com.ruoyi.system.domain.vo.banner.BannerSearchVo;
import com.ruoyi.system.domain.vo.banner.BannerUpdateVo;
import com.ruoyi.system.mapper.online.IBannerMapper;
import com.ruoyi.system.domain.entity.BBannerEntity;
import com.ruoyi.system.domain.view.BannerInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerService {
    @Autowired
    private IBannerMapper bannerMapper;

    /**
     * 刷新 - 重置轮播图信息
     *
     * @return
     */
    public List<BannerInfoView> selectBannerList() {
        List<BBannerEntity> bannerEntities = bannerMapper.selectBanner();

        return bannerEntities.stream().map(item -> new BannerInfoView().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 查询轮播图
     *
     * @param bannerSearchVo
     * @return
     */
    public List<BannerInfoView> queryBannerList(BannerSearchVo bannerSearchVo) {
        List<BBannerEntity> bannerEntities = bannerMapper.queryBannerByCondition(bannerSearchVo);

        return bannerEntities.stream().map(item -> new BannerInfoView().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 插入轮播图
     *
     * @param bannerAddVo
     */
    public void insertBanner(BannerAddVo bannerAddVo) {
        BBannerEntity bannerEntity = new BBannerEntity();
        bannerEntity = bannerAddVo.transfer(bannerEntity);
        bannerEntity.setBannerId(bannerMapper.countBanner() + 1);

        bannerMapper.insertBannerByCondition(bannerEntity);
    }

    /**
     * 修改轮播图数据
     *
     * @param bannerUpdateVo
     */
    public void updateBanner(BannerUpdateVo bannerUpdateVo) {
//        bannerUpdateVo.setUpdateBy(SecurityUtils.getUsername());
        bannerUpdateVo.setUpdateBy("admin");
        bannerUpdateVo.setUpdateTime(DateUtils.getTime());

        bannerMapper.updateBannerByCondition(bannerUpdateVo);
    }

    /**
     * 删除轮播图
     *
     * @param bannerId
     */
    public void deleteBanner(Long bannerId) {
        bannerMapper.deleteBannerByCondition(bannerId);
    }

    public void releaseBanner(Long bannerId) {
        if (bannerMapper.checkRelease(bannerId) == 1) bannerMapper.unReleaseBanner(bannerId);
        else bannerMapper.releaseBanner(bannerId);
    }
}
