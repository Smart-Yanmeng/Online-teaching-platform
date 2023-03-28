package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.*;
import com.ruoyi.system.domain.view.common.ResultView;
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
    public ResultView clazzInfoList(@RequestParam @Valid Integer pageNum,
                                    @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<ClazzInfoView> clazzInfoViews = clazzService.selectClazzList();

        return ResultView.querySuccess(clazzInfoViews);
    }

    @ApiOperation("查询班级列表")
    @GetMapping("/list")
    public ResultView clazzInfoSearchList(@RequestParam("teacherName") String teacherName,
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

        return ResultView.querySuccess(clazzInfoViews);
    }

    @ApiOperation("重置班级列表")
    @GetMapping("/reset")
    public ResultView clazzReset() {
        List<ClazzInfoView> clazzInfoViews = clazzService.selectClazzList();

        return ResultView.querySuccess(clazzInfoViews);
    }

    @ApiOperation("新增班级")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzAdd(@RequestBody ClazzAddVo clazzAddVo) {
        clazzService.insertClazz(clazzAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("查询班级")
    @GetMapping("/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzInfo(@PathVariable Long clazzId) {
        ClazzInfoView clazzInfoView = clazzService.queryClazz(clazzId);

        ResultView<ClazzInfoView> resultView = new ResultView<>();
        resultView.setData(clazzInfoView);

        return ResultView.querySuccess(clazzInfoView);
    }

    @ApiOperation("修改班级")
    @PutMapping("/{clazzId}/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzUpdate(@PathVariable Long clazzId,
                                  @RequestBody ClazzUpdateVo clazzUpdateVo) {
        clazzUpdateVo.setClazzId(clazzId);
        clazzService.updateClazz(clazzUpdateVo);

        return ResultView.updateSuccess(null);
    }

    @ApiOperation("删除班级")
    @PatchMapping("/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzPatch(@PathVariable Long clazzId) {
        clazzService.patchClazz(clazzId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("批量删除班级")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzDeleteAll(@RequestParam Long[] clazzIdArr) {
        clazzService.patchClazzAll(clazzIdArr);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("获取班级详情")
    @GetMapping("/{clazzId}/detail")
    public ResultView clazzDetailInfoList(@PathVariable Long clazzId) {
        List<ClazzDetailInfoView> clazzDetailInfoViews = clazzService.selectChapterList(clazzId);

        return ResultView.querySuccess(clazzDetailInfoViews);
    }

    @ApiOperation("获取目录课件")
    @GetMapping("/{clazzId}/detail/{catalogueId}")
    public ResultView clazzCatalogueInfo(@PathVariable Long clazzId,
                                         @PathVariable Long catalogueId) {
        CoursewareInfoView coursewareInfoView = clazzService.selectCourseware(catalogueId);

        return ResultView.querySuccess(coursewareInfoView);
    }

    @ApiOperation("修改目录课件")
    @PutMapping("/{clazzId}/detail/{chapterId}/{catalogueId}")
    public ResultView clazzCatalogueUpdate(@PathVariable Long chapterId,
                                           @PathVariable Long clazzId,
                                           @PathVariable Long catalogueId,
                                           @RequestBody ClazzCatalogueUpdateVo clazzCatalogueUpdateVo) {
        clazzCatalogueUpdateVo.setCatalogueId(catalogueId);
        clazzService.updateClazzCatalogue(clazzCatalogueUpdateVo);

        return ResultView.updateSuccess(null);
    }

    @ApiOperation("新增章")
    @PostMapping("/{clazzId}/detail/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzChapterAdd(@PathVariable Long clazzId,
                                      @RequestBody ClazzChapterAddVo clazzChapterAddVo) {
        clazzChapterAddVo.setClazzId(clazzId);
        clazzService.insertChapter(clazzChapterAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("新增节")
    @PostMapping("/{clazzId}/detail/{chapterId}/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzCatalogueAdd(@PathVariable Long clazzId,
                                        @PathVariable Long chapterId,
                                        @RequestBody ClazzCatalogueAddVo clazzCatalogueAddVo) {
        clazzCatalogueAddVo.setChapterId(chapterId);
        clazzService.insertCatalogue(clazzCatalogueAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("删除章")
    @PatchMapping("/{clazzId}/detail/{chapterId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzChapterDelete(@PathVariable Long clazzId,
                                         @PathVariable Long chapterId) {
        clazzService.deleteChapter(chapterId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("删除节")
    @PatchMapping("/{clazzId}/detail/{chapterId}/{catalogueId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzCatalogueDelete(@PathVariable Long clazzId,
                                           @PathVariable Long chapterId,
                                           @PathVariable Long catalogueId) {
        clazzService.patchCatalogue(catalogueId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("发布作业")
    @PostMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/addTask")
    @Transactional(rollbackFor = Exception.class)
    public ResultView clazzCatalogueTaskAdd(@PathVariable Long clazzId,
                                            @PathVariable Long chapterId,
                                            @PathVariable Long catalogueId,
                                            @RequestBody ClazzCatalogueTaskAddVo clazzCatalogueTaskAddVo) {
        clazzCatalogueTaskAddVo.setCatalogueId(catalogueId);
        clazzService.insertTask(clazzCatalogueTaskAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("刷新作业提交列表")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/task")
    public ResultView taskInfoList(@PathVariable Long clazzId,
                                   @PathVariable Long chapterId,
                                   @PathVariable Long catalogueId) {
        List<TaskSubmitInfoView> taskSubmitInfoViews = clazzService.selectTaskList(catalogueId);

        return ResultView.querySuccess(taskSubmitInfoViews);
    }

    @ApiOperation("下载学生作业")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/{taskId}")
    public ResultView taskDownload(@PathVariable Long clazzId,
                                   @PathVariable Long chapterId,
                                   @PathVariable Long catalogueId,
                                   @PathVariable Long taskId) {
        clazzService.downloadTask(taskId);

        return ResultView.success("下载成功", null);
    }

    @ApiOperation("获取评论列表")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/comment")
    public ResultView commentInfoList(@PathVariable Long clazzId,
                                      @PathVariable Long chapterId,
                                      @PathVariable Long catalogueId) {
        List<CommentInfoView> commentInfoViews = clazzService.selectComment(catalogueId);

        return ResultView.querySuccess(commentInfoViews);
    }

    @ApiOperation("删除评论")
    @PatchMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/{commentId}")
    public ResultView commentDelete(@PathVariable Long clazzId,
                                    @PathVariable Long chapterId,
                                    @PathVariable Long catalogueId,
                                    @PathVariable Long commentId) {
        clazzService.patchComment(commentId);

        return ResultView.deleteSuccess();
    }
}
