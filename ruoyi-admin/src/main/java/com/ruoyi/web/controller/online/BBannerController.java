package com.ruoyi.web.controller.online;

import com.ruoyi.system.domain.view.BannerInfoView;
import com.ruoyi.system.domain.view.ResultView;
import com.ruoyi.system.domain.vo.banner.BannerAddVo;
import com.ruoyi.system.service.online.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/banner")
@Api(tags = "Banner")
public class BBannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation("刷新轮播图列表")
    @GetMapping()
    public ResultView<List<BannerInfoView>> bannerInfo() {
        List<BannerInfoView> bannerInfoViews = bannerService.selectBannerList();

        ResultView<List<BannerInfoView>> resultView = new ResultView<>();
        resultView.setData(bannerInfoViews);

        return resultView;
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/list")
    public ResultView<List<BannerInfoView>> bannerInfoSearchList(@RequestParam("bannerTitle") String bannerTitle, @RequestParam("isRelease") Long isRelease) {
        BannerAddVo bannerAddVo = new BannerAddVo();
        bannerAddVo.setBannerTitle(bannerTitle);
        bannerAddVo.setIsRelease(isRelease);
        List<BannerInfoView> bannerInfoViews = bannerService.queryBannerList(bannerAddVo);

        ResultView<List<BannerInfoView>> resultView = new ResultView<>();
        resultView.setData(bannerInfoViews);

        return resultView;
    }
}
