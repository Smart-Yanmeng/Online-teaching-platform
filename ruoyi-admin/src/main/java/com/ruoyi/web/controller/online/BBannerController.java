package com.ruoyi.web.controller.online;

import com.ruoyi.system.domain.view.BannerInfoView;
import com.ruoyi.system.domain.view.ResultView;
import com.ruoyi.system.domain.vo.banner.BannerAddVo;
import com.ruoyi.system.domain.vo.banner.BannerSearchVo;
import com.ruoyi.system.domain.vo.banner.BannerUpdateVo;
import com.ruoyi.system.service.online.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/banner")
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
        BannerSearchVo bannerSearchVo = new BannerSearchVo();
        bannerSearchVo.setBannerTitle(bannerTitle);
        bannerSearchVo.setIsRelease(isRelease);
        List<BannerInfoView> bannerInfoViews = bannerService.queryBannerList(bannerSearchVo);

        ResultView<List<BannerInfoView>> resultView = new ResultView<>();
        resultView.setData(bannerInfoViews);

        return resultView;
    }

    @ApiOperation("重置轮播图列表")
    @GetMapping("/reset")
    public ResultView<List<BannerInfoView>> bannerReset() {
        List<BannerInfoView> bannerInfoViews = bannerService.selectBannerList();

        ResultView<List<BannerInfoView>> resultView = new ResultView<>();
        resultView.setData(bannerInfoViews);

        return resultView;
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerAdd(@RequestBody BannerAddVo bannerAddVo) {
        bannerService.insertBanner(bannerAddVo);

        return new ResultView<>();
    }

    @ApiOperation("修改轮播图")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerUpdate(@RequestBody BannerUpdateVo bannerUpdateVo) {
        bannerService.updateBanner(bannerUpdateVo);

        return new ResultView<>();
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerDelete(@RequestParam @Valid Long bannerId) {
        bannerService.deleteBanner(bannerId);

        return new ResultView<>();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerIsRelease(@RequestParam @Valid Long bannerId) {
        bannerService.releaseBanner(bannerId);

        return new ResultView<>();
    }
}
