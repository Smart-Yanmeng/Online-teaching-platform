package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.bo.banner.BannerAddBo;
import com.ruoyi.system.domain.bo.banner.BannerSearchBo;
import com.ruoyi.system.domain.bo.banner.BannerUpdateBo;
import com.ruoyi.system.domain.bo.convert.BannerAddBOConvert;
import com.ruoyi.system.domain.bo.convert.BannerUpdateBOConvert;
import com.ruoyi.system.domain.po.convert.BannerPOConvert;
import com.ruoyi.system.domain.vo.online.BannerInfo;
import com.ruoyi.system.mapper.online.IBannerMapper;
import com.ruoyi.system.domain.po.BBannerPo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerService {
    @Resource
    private IBannerMapper bannerMapper;

    /**
     * 获取 - 重置轮播图信息
     *
     * @return List<BannerInfoVo>
     */
    public List<BannerInfo> selectBannerList() {
        List<BBannerPo> bannerPos = bannerMapper.selectBanner();

        return bannerPos.stream().map(item -> new BannerPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 可用轮播图数量
     *
     * @return Long
     */
    public Long countUseBanner(BannerSearchBo bannerSearchBo) {
        return bannerMapper.countUseBanner(bannerSearchBo);
    }

    /**
     * 查询轮播图
     *
     * @param bannerSearchBo 查询轮播图条件
     * @return List<BannerInfoVo>
     */
    public List<BannerInfo> queryBannerList(BannerSearchBo bannerSearchBo) {
        List<BBannerPo> bannerPos = bannerMapper.queryBannerByCondition(bannerSearchBo);

        return bannerPos.stream().map(item -> new BannerPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 插入轮播图
     *
     * @param bannerAddBo 插入轮播图信息
     */
    public void insertBanner(BannerAddBo bannerAddBo) {
        BBannerPo bannerPo = new BannerAddBOConvert().convert(bannerAddBo);
        bannerPo.setBannerSort(String.format("%10s", bannerPo.getBannerSort()));
        bannerPo.setBannerId(bannerMapper.countBanner() + 1);

        bannerMapper.insertBannerByCondition(bannerPo);
    }

    /**
     * 修改轮播图数据
     *
     * @param bannerUpdateBo 轮播图修改数据
     */
    public void updateBanner(BannerUpdateBo bannerUpdateBo) {
        BBannerPo bannerPo = new BannerUpdateBOConvert().convert(bannerUpdateBo);
        bannerPo.setBannerSort(String.format("%10s", bannerPo.getBannerSort()));

        bannerMapper.updateBannerByCondition(bannerPo);
    }

    /**
     * 批量删除轮播图
     *
     * @param bannerIdArr 轮播图 ID 集合
     */
    public void patchBannerAll(Long[] bannerIdArr) {
        for (Long item : bannerIdArr) {
            bannerMapper.patchBannerByCondition(item);
        }
    }

    /**
     * 删除轮播图
     *
     * @param bannerId 轮播图 ID
     */
    public void patchBanner(Long bannerId) {
        bannerMapper.patchBannerByCondition(bannerId);
    }

    /**
     * 发布 - 取消发布轮播图
     *
     * @param bannerId 轮播图 ID
     * @return Boolean
     */
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
