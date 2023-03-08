package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.vo.banner.BannerAddVo;
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
    private IBannerMapper bannerDao;

    public List<BannerInfoView> selectBannerList() {
        List<BBannerEntity> bannerEntities = bannerDao.selectBanner();

        return bannerEntities.stream().map(item -> new BannerInfoView().transfer(item)).collect(Collectors.toList());
    }

    public List<BannerInfoView> queryBannerList(BannerAddVo bannerAddVo) {
        List<BBannerEntity> bannerEntities = bannerDao.queryBannerBuCondition(bannerAddVo);

        System.out.println(bannerEntities);

        return bannerEntities.stream().map(item -> new BannerInfoView().transfer(item)).collect(Collectors.toList());
    }
}
