package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.bo.banner.BannerAddBo;
import com.ruoyi.system.domain.bo.banner.BannerUpdateBo;
import com.ruoyi.system.domain.dto.banner.BannerAddDto;
import com.ruoyi.system.domain.bo.banner.BannerSearchBo;
import com.ruoyi.system.domain.dto.banner.BannerUpdateDto;
import com.ruoyi.system.domain.dto.convert.BannerAddDTOConvert;
import com.ruoyi.system.domain.dto.convert.BannerUpdateDTOConvert;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.vo.online.BannerInfoVo;
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

    @ApiOperation("获取轮播图列表")
    @GetMapping()
    public ResultVo bannerInfoList(@RequestParam @Valid Integer pageNum,
                                   @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BannerInfoVo> bannerInfoVos = bannerService.selectBannerList();

        return ResultVo.querySuccess(bannerInfoVos);
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/list")
    public ResultVo bannerInfoSearchList(@RequestParam("bannerTitle") String bannerTitle,
                                         @RequestParam("isRelease") Long isRelease) {
        BannerSearchBo bannerSearchBo = new BannerSearchBo();
        bannerSearchBo.setBannerTitle(bannerTitle);
        bannerSearchBo.setIsRelease(isRelease);
        List<BannerInfoVo> bannerInfoVos = bannerService.queryBannerList(bannerSearchBo);

        return ResultVo.querySuccess(bannerInfoVos);
    }

    @ApiOperation("重置轮播图列表")
    @GetMapping("/reset")
    public ResultVo bannerReset(@RequestParam @Valid Integer pageNum,
                                @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BannerInfoVo> bannerInfoVos = bannerService.selectBannerList();

        return ResultVo.querySuccess(bannerInfoVos);
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerAdd(@RequestBody BannerAddDto bannerAddDto) {
        BannerAddBo bannerAddBo = new BannerAddDTOConvert().convert(bannerAddDto);
        bannerService.insertBanner(bannerAddBo);

        return ResultVo.insertSuccess(new BannerAddDto());
    }

    @ApiOperation("批量删除轮播图")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultVo patchBannerAll(@RequestParam("bannerIdArr") Long[] bannerIdArr) {
        bannerService.patchBannerAll(bannerIdArr);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("修改轮播图")
    @PutMapping("/update/{bannerId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerUpdate(@RequestBody BannerUpdateDto bannerUpdateDto) {
        BannerUpdateBo bannerUpdateBo = new BannerUpdateDTOConvert().convert(bannerUpdateDto);
        bannerService.updateBanner(bannerUpdateBo);

        return ResultVo.updateSuccess(new BannerUpdateDto());
    }

    @ApiOperation("删除轮播图")
    @PatchMapping("/delete/{bannerId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerPatch(@PathVariable Long bannerId) {
        bannerService.patchBanner(bannerId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release/{bannerId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo bannerIsRelease(@PathVariable Long bannerId) {
        boolean flag = bannerService.releaseBanner(bannerId);

        if (flag) return ResultVo.success("发布成功", null);
        else return ResultVo.success("取消发表成功", null);
    }
}
