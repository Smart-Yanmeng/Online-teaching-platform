package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ClazzDetailInfoView;
import com.ruoyi.system.domain.view.ClazzInfoView;
import com.ruoyi.system.domain.view.ResultView;
import com.ruoyi.system.domain.vo.clazz.ClazzAddVo;
import com.ruoyi.system.domain.vo.clazz.ClazzSearchVo;
import com.ruoyi.system.domain.vo.clazz.ClazzUpdateVo;
import com.ruoyi.system.service.online.ClazzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/clazz")
@Api(tags = "Clazz")
public class BClazzController {
    @Autowired
    ClazzService clazzService;

    @ApiOperation("刷新班级列表")
    @GetMapping
    public ResultView<List<ClazzInfoView>> clazzInfoList(@RequestParam @Valid Integer pageNum,
                                                         @RequestParam @Valid Integer pageSize) {
        List<ClazzInfoView> clazzInfoViews = clazzService.selectClazzList();

        PageHelper.startPage(pageNum, pageSize);
        ResultView<List<ClazzInfoView>> resultView = new ResultView<>();
        resultView.setData(clazzInfoViews);

        return resultView;
    }

    @ApiOperation("查询班级")
    @GetMapping("/list")
    public ResultView<List<ClazzInfoView>> clazzInfoSearchList(@RequestParam("teacherName") String teacherName,
                                                               @RequestParam("headmasterName") String headmasterName,
                                                               @RequestParam("clazzName") String clazzName,
                                                               @RequestParam("startTime") String startTime,
                                                               @RequestParam("finishTime") String finishTime,
                                                               @RequestParam("finish") Character finish) {
        ClazzSearchVo clazzSearchVo = new ClazzSearchVo();
        clazzSearchVo.setTeacherName(teacherName);
        clazzSearchVo.setHeadmasterName(headmasterName);
        clazzSearchVo.setClazzName(clazzName);
        clazzSearchVo.setStartTime(startTime);
        clazzSearchVo.setFinishTime(finishTime);
        clazzSearchVo.setFinish(finish);

        List<ClazzInfoView> clazzInfoViews = clazzService.queryClazzList(clazzSearchVo);

        ResultView<List<ClazzInfoView>> resultView = new ResultView<>();
        resultView.setData(clazzInfoViews);

        return resultView;
    }

    @ApiOperation("重置班级列表")
    @GetMapping("/reset")
    public ResultView<List<ClazzInfoView>> clazzReset() {
        List<ClazzInfoView> clazzInfoViews = clazzService.selectClazzList();

        ResultView<List<ClazzInfoView>> resultView = new ResultView<>();
        resultView.setData(clazzInfoViews);

        return resultView;
    }

    @ApiOperation("新增班级")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzAdd(@RequestBody ClazzAddVo clazzAddVo) {
        clazzService.insertClazz(clazzAddVo);

        return new ResultView<>();
    }

    @ApiOperation("查询班级")
    @GetMapping("/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<ClazzInfoView> clazzInfo(@PathVariable Long clazzId) {
        ClazzInfoView clazzInfoView = clazzService.queryClazz(clazzId);

        ResultView<ClazzInfoView> resultView = new ResultView<>();
        resultView.setData(clazzInfoView);

        return resultView;
    }

    @ApiOperation("修改班级")
    @PutMapping("/{clazzId}/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzUpdate(@PathVariable Long clazzId,
                                          @RequestBody ClazzUpdateVo clazzUpdateVo) {
        clazzUpdateVo.setClazzId(clazzId);
        clazzService.updateClazz(clazzUpdateVo);

        return new ResultView<>();
    }

    @ApiOperation("删除班级")
    @DeleteMapping("/delete/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzDelete(@PathVariable Long clazzId) {
        clazzService.deleteClazz(clazzId);

        return new ResultView<>();
    }

    @ApiOperation("批量删除班级")
    @DeleteMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzDeleteAll(@RequestParam Long[] clazzIdArr) {
        clazzService.deleteClazzAll(clazzIdArr);

        return new ResultView<>();
    }

    @ApiOperation("获取班级详情")
    @GetMapping("/{clazzId}/Detail")
    public ResultView<List<ClazzDetailInfoView>> clazzDetailInfoList(@PathVariable Long clazzId) {
        List<ClazzDetailInfoView> clazzDetailInfoViews = clazzService.selectChapterList(clazzId);

        ResultView<List<ClazzDetailInfoView>> resultView = new ResultView<>();
        resultView.setData(clazzDetailInfoViews);

        return resultView;
    }
}
