package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.*;
import com.ruoyi.system.domain.vo.clazz.*;
import com.ruoyi.system.service.online.ClazzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/clazz")
@Api(tags = "Clazz")
public class BClazzController {
    @Resource
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
    @PatchMapping("/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzPatch(@PathVariable Long clazzId) {
        clazzService.patchClazz(clazzId);

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
    @GetMapping("/{clazzId}/detail")
    public ResultView<List<ClazzDetailInfoView>> clazzDetailInfoList(@PathVariable Long clazzId) {
        List<ClazzDetailInfoView> clazzDetailInfoViews = clazzService.selectChapterList(clazzId);

        ResultView<List<ClazzDetailInfoView>> resultView = new ResultView<>();
        resultView.setData(clazzDetailInfoViews);

        return resultView;
    }

    @ApiOperation("获取目录课件")
    @GetMapping("/{clazzId}/detail/{catalogueId}")
    public ResultView<CoursewareInfoView> clazzCatalogueInfo(@PathVariable Long clazzId,
                                                             @PathVariable Long catalogueId) {
        CoursewareInfoView coursewareInfoView = clazzService.selectCourseware(catalogueId);

        ResultView<CoursewareInfoView> resultView = new ResultView<>();
        resultView.setData(coursewareInfoView);

        return resultView;
    }

    @ApiOperation("修改目录课件")
    @PutMapping("/{clazzId}/detail/{chapterId}/{catalogueId}")
    public ResultView<Object> clazzCatalogueUpdate(@PathVariable Long chapterId,
                                                   @PathVariable Long clazzId,
                                                   @PathVariable Long catalogueId,
                                                   @RequestBody ClazzCatalogueUpdateVo clazzCatalogueUpdateVo) {
        clazzCatalogueUpdateVo.setCatalogueId(catalogueId);
        clazzService.updateClazzCatalogue(clazzCatalogueUpdateVo);

        return new ResultView<>();
    }

    @ApiOperation("新增章")
    @PostMapping("/{clazzId}/detail/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzChapterAdd(@PathVariable Long clazzId,
                                              @RequestBody ClazzChapterAddVo clazzChapterAddVo) {
        clazzChapterAddVo.setClazzId(clazzId);
        clazzService.insertChapter(clazzChapterAddVo);

        return new ResultView<>();
    }

    @ApiOperation("新增节")
    @PostMapping("/{clazzId}/detail/{chapterId}/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzCatalogueAdd(@PathVariable Long clazzId,
                                                @PathVariable Long chapterId,
                                                @RequestBody ClazzCatalogueAddVo clazzCatalogueAddVo) {
        clazzCatalogueAddVo.setChapterId(chapterId);
        clazzService.insertCatalogue(clazzCatalogueAddVo);

        return new ResultView<>();
    }

    @ApiOperation("删除章")
    @DeleteMapping("/{clazzId}/detail/{chapterId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzChapterDelete(@PathVariable Long clazzId,
                                                 @PathVariable Long chapterId) {
        clazzService.deleteChapter(chapterId);

        return new ResultView<>();
    }

    @ApiOperation("删除节")
    @DeleteMapping("/{clazzId}/detail/{chapterId}/{catalogueId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzCatalogueDelete(@PathVariable Long clazzId,
                                                   @PathVariable Long chapterId,
                                                   @PathVariable Long catalogueId) {
        clazzService.deleteCatalogue(catalogueId);

        return new ResultView<>();
    }

    @ApiOperation("发布作业")
    @PostMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/addTask")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> clazzCatalogueTaskAdd(@PathVariable Long clazzId,
                                                    @PathVariable Long chapterId,
                                                    @PathVariable Long catalogueId,
                                                    @RequestBody ClazzCatalogueTaskAddVo clazzCatalogueTaskAddVo) {
        clazzCatalogueTaskAddVo.setCatalogueId(catalogueId);
        clazzService.insertTask(clazzCatalogueTaskAddVo);

        return new ResultView<>();
    }

    @ApiOperation("刷新作业提交列表")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/task")
    public ResultView<List<TaskSubmitInfoView>> taskInfoList(@PathVariable Long clazzId,
                                                             @PathVariable Long chapterId,
                                                             @PathVariable Long catalogueId) {
        List<TaskSubmitInfoView> taskSubmitInfoViews = clazzService.selectTaskList(catalogueId);

        ResultView<List<TaskSubmitInfoView>> resultView = new ResultView<>();
        resultView.setData(taskSubmitInfoViews);

        return resultView;
    }

    @ApiOperation("下载学生作业")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/{taskId}")
    public ResultView<Object> taskDownload(@PathVariable Long clazzId,
                                           @PathVariable Long chapterId,
                                           @PathVariable Long catalogueId,
                                           @PathVariable Long taskId) {
        clazzService.downloadTask(taskId);

        return new ResultView<>();
    }

    @ApiOperation("获取评论列表")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/comment")
    public ResultView<List<CommentInfoView>> commentInfoList(@PathVariable Long clazzId,
                                                             @PathVariable Long chapterId,
                                                             @PathVariable Long catalogueId) {
        List<CommentInfoView> commentInfoViews = clazzService.selectComment(catalogueId);

        ResultView<List<CommentInfoView>> resultView = new ResultView<>();
        resultView.setData(commentInfoViews);

        return resultView;
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/{commentId}")
    public ResultView<Object> commentDelete(@PathVariable Long clazzId,
                                            @PathVariable Long chapterId,
                                            @PathVariable Long catalogueId,
                                            @PathVariable Long commentId) {
        clazzService.deleteComment(commentId);

        return new ResultView<>();
    }
}
