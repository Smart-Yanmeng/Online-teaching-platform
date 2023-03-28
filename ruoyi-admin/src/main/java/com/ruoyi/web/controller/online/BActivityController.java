package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ActivityInfoView;
import com.ruoyi.system.domain.view.ResultView;
import com.ruoyi.system.domain.vo.activity.ActivityAddVo;
import com.ruoyi.system.domain.vo.activity.ActivitySearchVo;
import com.ruoyi.system.domain.vo.activity.ActivityUpdateVo;
import com.ruoyi.system.service.online.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/activity")
@Api(tags = "Activity")
public class BActivityController {

    @Resource
    ActivityService activityService;

    @ApiOperation("获取活动列表")
    @GetMapping
    public ResultView<List<ActivityInfoView>> activityInfoList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        ResultView<List<ActivityInfoView>> resultView = new ResultView<>();

        PageHelper.startPage(pageNum, pageSize);
        List<ActivityInfoView> activityInfoViews = activityService.selectActivityList();
        resultView.setData(activityInfoViews);

        return resultView;
    }

    @ApiOperation("查询活动")
    @GetMapping("/list")
    public ResultView<List<ActivityInfoView>> activityInfoSearch(@RequestParam String activityTitle, @RequestParam Long isRelease) {
        ActivitySearchVo activitySearchVo = new ActivitySearchVo();
        activitySearchVo.setActivityTitle(activityTitle);
        activitySearchVo.setIsRelease(isRelease);
        List<ActivityInfoView> activityInfoViews = activityService.queryActivityList(activitySearchVo);

        ResultView<List<ActivityInfoView>> resultView = new ResultView<>();
        resultView.setData(activityInfoViews);

        return resultView;
    }

    @ApiOperation("重置活动列表")
    @GetMapping("/reset")
    public ResultView<List<ActivityInfoView>> activityReset() {
        List<ActivityInfoView> activityInfoViews = activityService.selectActivityList();

        ResultView<List<ActivityInfoView>> resultView = new ResultView<>();
        resultView.setData(activityInfoViews);

        return resultView;
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerAdd(@RequestBody ActivityAddVo activityAddVo) {
        activityService.insertActivity(activityAddVo);

        return new ResultView<>();
    }

    @ApiOperation("修改活动")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerUpdate(@RequestBody ActivityUpdateVo activityUpdateVo) {
        activityService.updateActivity(activityUpdateVo);

        return new ResultView<>();
    }

    @ApiOperation("删除活动")
    @DeleteMapping("/delete/{activityId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> activityDelete(@PathVariable Long activityId) {
        activityService.deleteActivity(activityId);

        return new ResultView<>();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> activityIsRelease(@RequestParam @Valid Long activityId) {
        activityService.releaseActivity(activityId);

        return new ResultView<>();
    }
}
