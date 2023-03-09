package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ActivityInfoView;
import com.ruoyi.system.domain.view.ResultView;
import com.ruoyi.system.service.online.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homePageManage/activity")
@Api(tags = "activity")
public class BActivityController {
    @Autowired
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
}
