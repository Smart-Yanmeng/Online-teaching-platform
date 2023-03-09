package com.ruoyi.web.controller.online;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.view.ActivityInfoView;
import com.ruoyi.system.service.online.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homePageManage/activity")
@Api(tags = "activity")
public class BActivityController extends BaseController {
    @Autowired
    ActivityService activityService;

    @ApiOperation("获取活动列表")
    @GetMapping
    public TableDataInfo activityInfoList() {
        startPage();
        List<ActivityInfoView> activityInfoViews = activityService.selectActivityList();

        return getDataTable(activityInfoViews);
    }
}
