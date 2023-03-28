package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.common.ResultView;
import com.ruoyi.system.domain.view.SharingInfoView;
import com.ruoyi.system.domain.vo.sharing.SharingAddVo;
import com.ruoyi.system.domain.vo.sharing.SharingSearchVo;
import com.ruoyi.system.domain.vo.sharing.SharingUpdateVo;
import com.ruoyi.system.service.online.SharingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/sharing")
@Api(tags = "Sharing")
public class BSharingController {
    @Resource
    SharingService sharingService;

    @ApiOperation("刷新分享列表")
    @GetMapping()
    public ResultView bannerInfo(@RequestParam @Valid Integer pageNum, @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<SharingInfoView> sharingInfoViews = sharingService.selectSharingList();

        return ResultView.querySuccess(sharingInfoViews);
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/list")
    public ResultView sharingInfoSearchList(@RequestParam("sharingTitle") String sharingTitle,
                                            @RequestParam("sharingSubtitle") String sharingSubtitle,
                                            @RequestParam("honouredGuest") String honouredGuest,
                                            @RequestParam("isRelease") Character isRelease,
                                            @RequestParam("isLink") Character isLink) {
        SharingSearchVo sharingSearchVo = new SharingSearchVo();
        sharingSearchVo.setSharingTitle(sharingTitle);
        sharingSearchVo.setSharingSubtitle(sharingSubtitle);
        sharingSearchVo.setHonouredGuest(honouredGuest);
        sharingSearchVo.setIsRelease(isRelease);
        sharingSearchVo.setIsLink(isLink);

        List<SharingInfoView> sharingInfoViews = sharingService.querySharingList(sharingSearchVo);

        return ResultView.querySuccess(sharingInfoViews);
    }

    @ApiOperation("重置分享列表")
    @GetMapping("/reset")
    public ResultView sharingReset() {
        List<SharingInfoView> sharingInfoViews = sharingService.selectSharingList();

        return ResultView.querySuccess(sharingInfoViews);
    }

    @ApiOperation("新增分享")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView sharingAdd(@RequestBody SharingAddVo sharingAddVo) {
        sharingService.insertSharing(sharingAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("批量删除分享")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultView sharingPatchAll(@RequestParam Long[] sharingIdArr) {
        sharingService.patchSharingAll(sharingIdArr);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("修改分享")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView sharingUpdate(@RequestBody SharingUpdateVo sharingUpdateVo) {
        sharingService.updateSharing(sharingUpdateVo);

        return ResultView.updateSuccess(null);
    }

    @ApiOperation("删除分享")
    @PatchMapping("/{sharingId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView sharingPatch(@PathVariable Long sharingId) {
        sharingService.patchSharing(sharingId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release/{sharingId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView sharingIsRelease(@PathVariable Long sharingId) {
        Boolean flag = sharingService.releaseSharing(sharingId);

        if (flag) return ResultView.success("发布成功", null);
        else return ResultView.success("取消发布成功", null);
    }
}
