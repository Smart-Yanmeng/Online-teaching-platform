package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.bo.activity.ActivityAddBo;
import com.ruoyi.system.domain.bo.activity.ActivityUpdateBo;
import com.ruoyi.system.domain.dto.active.convert.ActivityAddDTOConvert;
import com.ruoyi.system.domain.dto.active.convert.ActivityUpdateDTOConvert;
import com.ruoyi.system.domain.vo.online.ActivityInfoVo;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.dto.active.ActivityAddDto;
import com.ruoyi.system.domain.bo.activity.ActivitySearchBo;
import com.ruoyi.system.domain.dto.active.ActivityUpdateDto;
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
    public ResultVo activityInfoList(@RequestParam @Valid Integer pageNum,
                                     @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActivityInfoVo> activityInfoVos = activityService.selectActivityList();

        return ResultVo.querySuccess(activityInfoVos);
    }

    @ApiOperation("查询活动")
    @GetMapping("/list")
    public ResultVo activityInfoSearch(@RequestParam String activityTitle, @RequestParam Long isRelease) {
        ActivitySearchBo activitySearchBo = new ActivitySearchBo();
        activitySearchBo.setActivityTitle(activityTitle);
        activitySearchBo.setIsRelease(isRelease);
        List<ActivityInfoVo> activityInfoVos = activityService.queryActivityList(activitySearchBo);

        return ResultVo.querySuccess(activityInfoVos);
    }

    @ApiOperation("重置活动列表")
    @GetMapping("/reset")
    public ResultVo activityReset(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActivityInfoVo> activityInfoVos = activityService.selectActivityList();

        return ResultVo.querySuccess(activityInfoVos);
    }

    @ApiOperation("新增活动")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo activityAdd(@RequestBody ActivityAddDto activityAddDto) {
        ActivityAddBo activityAddBo = new ActivityAddDTOConvert().convert(activityAddDto);
        activityService.insertActivity(activityAddBo);

        return ResultVo.insertSuccess(new ActivityAddDto());
    }

    @ApiOperation("修改活动")
    @PutMapping("/update/{activityId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo activityUpdate(@RequestBody ActivityUpdateDto activityUpdateDto) {
        ActivityUpdateBo activityUpdateBo = new ActivityUpdateDTOConvert().convert(activityUpdateDto);
        activityService.updateActivity(activityUpdateBo);

        return ResultVo.updateSuccess(new ActivityUpdateDto());
    }

    @ApiOperation("删除活动")
    @PatchMapping("/delete/{activityId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo activityPatch(@PathVariable Long activityId) {
        activityService.patchActivity(activityId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release/{activityId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo activityIsRelease(@PathVariable Long activityId) {
        boolean flag = activityService.releaseActivity(activityId);

        if (flag) return ResultVo.success("发布成功", null);
        else return ResultVo.success("取消发布成功", null);
    }
}
