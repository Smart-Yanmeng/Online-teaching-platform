package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.bo.banner.BannerAddVo;
import com.ruoyi.system.domain.bo.banner.BannerSearchVo;
import com.ruoyi.system.domain.bo.banner.BannerUpdateVo;
import com.ruoyi.system.mapper.online.IBannerMapper;
import com.ruoyi.system.domain.po.BBannerPo;
import com.ruoyi.system.domain.vo.online.BannerInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerService {
    @Resource
    private IBannerMapper bannerMapper;

    /**
     * 刷新 - 重置轮播图信息
     *
     * @return
     */
    public List<BannerInfoVo> selectBannerList() {
        List<BBannerPo> bannerPos = bannerMapper.selectBanner();

        return bannerPos.stream().map(item -> new BannerInfoVo().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 查询轮播图
     *
     * @param bannerSearchVo
     * @return
     */
    public List<BannerInfoVo> queryBannerList(BannerSearchVo bannerSearchVo) {
        List<BBannerPo> bannerEntities = bannerMapper.queryBannerByCondition(bannerSearchVo);

        return bannerEntities.stream().map(item -> new BannerInfoVo().transfer(item)).collect(Collectors.toList());
    }

    /**
     * 插入轮播图
     *
     * @param bannerAddVo
     */
    public void insertBanner(BannerAddVo bannerAddVo) {
        BBannerPo bannerEntity = new BBannerPo();
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
     * 批量删除轮播图
     *
     * @param bannerIdArr
     */
    public void patchBannerAll(Long[] bannerIdArr) {
        for (Long item : bannerIdArr) {
            bannerMapper.patchBannerByCondition(item);
        }
    }

    /**
     * 删除轮播图
     *
     * @param bannerId
     */
    public void patchBanner(Long bannerId) {
        bannerMapper.patchBannerByCondition(bannerId);
    }

    public Boolean releaseBanner(Long bannerId) {
        if (bannerMapper.checkRelease(bannerId) == 1) {
            bannerMapper.unReleaseBanner(bannerId);
            return false;
        } else {
            bannerMapper.releaseBanner(bannerId);
            return true;
        }
    }
}
