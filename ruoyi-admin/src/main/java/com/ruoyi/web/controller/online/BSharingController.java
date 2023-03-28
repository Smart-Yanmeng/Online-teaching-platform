package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ResultView;
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
    public ResultView<List<SharingInfoView>> bannerInfo(@RequestParam @Valid Integer pageNum, @RequestParam @Valid Integer pageSize) {
        List<SharingInfoView> sharingInfoViews = sharingService.selectSharingList();

        PageHelper.startPage(pageNum, pageSize);
        ResultView<List<SharingInfoView>> resultView = new ResultView<>();
        resultView.setData(sharingInfoViews);

        return resultView;
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/list")
    public ResultView<List<SharingInfoView>> sharingInfoSearchList(@RequestParam("sharingTitle") String sharingTitle,
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

        ResultView<List<SharingInfoView>> resultView = new ResultView<>();
        resultView.setData(sharingInfoViews);

        return resultView;
    }

    @ApiOperation("重置分享列表")
    @GetMapping("/reset")
    public ResultView<List<SharingInfoView>> sharingReset() {
        List<SharingInfoView> sharingInfoViews = sharingService.selectSharingList();

        ResultView<List<SharingInfoView>> resultView = new ResultView<>();
        resultView.setData(sharingInfoViews);

        return resultView;
    }

    @ApiOperation("新增分享")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerAdd(@RequestBody SharingAddVo sharingAddVo) {
        sharingService.insertSharing(sharingAddVo);

        return new ResultView<>();
    }

    @ApiOperation("修改分享")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> sharingUpdate(@RequestBody SharingUpdateVo sharingUpdateVo) {
        sharingService.updateSharing(sharingUpdateVo);

        return new ResultView<>();
    }

    @ApiOperation("删除分享")
    @DeleteMapping("/delete/{sharingId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> sharingDelete(@PathVariable Long sharingId) {
        sharingService.deleteSharing(sharingId);

        return new ResultView<>();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> sharingIsRelease(@RequestParam @Valid Long sharingId) {
        sharingService.releaseSharing(sharingId);

        return new ResultView<>();
    }
}
