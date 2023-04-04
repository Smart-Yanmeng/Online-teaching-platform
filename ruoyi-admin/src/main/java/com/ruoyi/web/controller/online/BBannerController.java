package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.vo.online.BannerInfoView;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.bo.banner.BannerAddVo;
import com.ruoyi.system.domain.bo.banner.BannerSearchVo;
import com.ruoyi.system.domain.bo.banner.BannerUpdateVo;
import com.ruoyi.system.service.online.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/banner")
@Api(tags = "Banner")
public class BBannerController {
    @Resource
    private BannerService bannerService;

    @ApiOperation("刷新轮播图列表")
    @GetMapping()
    public ResultVo bannerInfoList(@RequestParam @Valid Integer pageNum,
                                   @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BannerInfoView> bannerInfoViews = bannerService.selectBannerList();

        return ResultVo.querySuccess(bannerInfoViews);
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/list")
    public ResultVo bannerInfoSearchList(@RequestParam("bannerTitle") String bannerTitle,
                                         @RequestParam("isRelease") Long isRelease) {
        BannerSearchVo bannerSearchVo = new BannerSearchVo();
        bannerSearchVo.setBannerTitle(bannerTitle);
        bannerSearchVo.setIsRelease(isRelease);
        List<BannerInfoView> bannerInfoViews = bannerService.queryBannerList(bannerSearchVo);

        return ResultVo.querySuccess(bannerInfoViews);
    }

    @ApiOperation("重置轮播图列表")
    @GetMapping("/reset")
    public ResultVo bannerReset() {
        List<BannerInfoView> bannerInfoViews = bannerService.selectBannerList();

        return ResultVo.querySuccess(bannerInfoViews);
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerAdd(@RequestBody BannerAddVo bannerAddVo) {
        bannerService.insertBanner(bannerAddVo);

        return ResultVo.insertSuccess(null);
    }

    @ApiOperation("批量删除轮播图")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultVo patchBannerAll(@RequestParam Long[] bannerIdArr) {
        bannerService.patchBannerAll(bannerIdArr);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("修改轮播图")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerUpdate(@RequestBody BannerUpdateVo bannerUpdateVo) {
        bannerService.updateBanner(bannerUpdateVo);

        return ResultVo.updateSuccess(null);
    }

    @ApiOperation("删除轮播图")
    @PatchMapping("/{bannerId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerPatch(@PathVariable Long bannerId) {
        bannerService.patchBanner(bannerId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo<Object> bannerIsRelease(@RequestParam @Valid Long bannerId) {
        boolean flag = bannerService.releaseBanner(bannerId);

        if (flag) return ResultVo.success("发布成功", null);
        else return ResultVo.success("取消发表成功", null);
    }
}
