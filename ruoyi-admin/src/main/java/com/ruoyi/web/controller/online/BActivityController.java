package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ActivityInfoView;
import com.ruoyi.system.domain.view.common.ResultView;
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

        return resultView.querySuccess(activityInfoViews);
    }

    @ApiOperation("查询活动")
    @GetMapping("/list")
    public ResultView activityInfoSearch(@RequestParam String activityTitle, @RequestParam Long isRelease) {
        ActivitySearchVo activitySearchVo = new ActivitySearchVo();
        activitySearchVo.setActivityTitle(activityTitle);
        activitySearchVo.setIsRelease(isRelease);
        List<ActivityInfoView> activityInfoViews = activityService.queryActivityList(activitySearchVo);

        return ResultView.querySuccess(activityInfoViews);
    }

    @ApiOperation("重置活动列表")
    @GetMapping("/reset")
    public ResultView activityReset() {
        List<ActivityInfoView> activityInfoViews = activityService.selectActivityList();

        return ResultView.querySuccess(activityInfoViews);
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView bannerAdd(@RequestBody ActivityAddVo activityAddVo) {
        activityService.insertActivity(activityAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("修改活动")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> bannerUpdate(@RequestBody ActivityUpdateVo activityUpdateVo) {
        activityService.updateActivity(activityUpdateVo);

        return ResultView.updateSuccess(null);
    }

    @ApiOperation("删除活动")
    @PatchMapping("/{activityId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> activityPatch(@PathVariable Long activityId) {
        activityService.patchActivity(activityId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> activityIsRelease(@RequestParam @Valid Long activityId) {
        Boolean flag = activityService.releaseActivity(activityId);

        if (flag) return ResultView.success("发布成功", null);
        else return ResultView.success("取消发布成功", null);
    }
}
