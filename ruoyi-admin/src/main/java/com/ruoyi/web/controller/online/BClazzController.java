package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.dto.clazz.*;
import com.ruoyi.system.domain.dto.convert.*;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.bo.clazz.*;
import com.ruoyi.system.domain.vo.online.*;
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

    @ApiOperation("获取班级列表")
    @GetMapping
    public ResultVo clazzInfoList(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                  @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ClazzInfoVo> clazzInfoVos = clazzService.selectClazzList();

        return ResultVo.querySuccess(clazzInfoVos);
    }

    @ApiOperation("查询班级列表")
    @GetMapping("/list")
    public ResultVo clazzInfoSearchList(@RequestParam("teacherName") String teacherName,
                                        @RequestParam("headmasterName") String headmasterName,
                                        @RequestParam("clazzName") String clazzName,
                                        @RequestParam("startTime") String startTime,
                                        @RequestParam("finishTime") String finishTime,
                                        @RequestParam("finish") Character finish,
                                        @RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                        @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        ClazzSearchBo clazzSearchBo = new ClazzSearchBo();
        clazzSearchBo.setTeacherName(teacherName);
        clazzSearchBo.setHeadmasterName(headmasterName);
        clazzSearchBo.setClazzName(clazzName);
        clazzSearchBo.setStartTime(startTime);
        clazzSearchBo.setFinishTime(finishTime);
        clazzSearchBo.setFinish(finish);

        PageHelper.startPage(pageNum, pageSize);
        List<ClazzInfoVo> clazzInfoVos = clazzService.queryClazzList(clazzSearchBo);

        return ResultVo.querySuccess(clazzInfoVos);
    }

    @ApiOperation("重置班级列表")
    @GetMapping("/reset")
    public ResultVo clazzReset() {
        List<ClazzInfoVo> clazzInfoVos = clazzService.selectClazzList();

        return ResultVo.querySuccess(clazzInfoVos);
    }

    @ApiOperation("新增班级")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzAdd(@RequestBody ClazzAddDto clazzAddDto) {
        ClazzAddBo clazzAddBo = new ClazzAddDTOConvert().convert(clazzAddDto);
        clazzService.insertClazz(clazzAddBo);

        return ResultVo.insertSuccess(new ClazzAddDto());
    }

//    @ApiOperation("查询班级")
//    @GetMapping("/{clazzId}")
//    @Transactional(rollbackFor = Exception.class)
//    public ResultVo clazzInfo(@PathVariable Long clazzId) {
//        ClazzInfoVo clazzInfoVo = clazzService.queryClazz(clazzId);
//
//        ResultVo<ClazzInfoVo> resultVo = new ResultVo<>();
//        resultVo.setData(clazzInfoVo);
//
//        return ResultVo.querySuccess(clazzInfoVo);
//    }

    @ApiOperation("修改班级")
    @PutMapping("/update/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzUpdate(@PathVariable Long clazzId,
                                @RequestBody ClazzUpdateDto clazzUpdateDto) {
        ClazzUpdateBo clazzUpdateBo = new ClazzUpdateDTOConvert().convert(clazzUpdateDto);
        clazzUpdateBo.setClazzId(clazzId);
        clazzService.updateClazz(clazzUpdateBo);

        return ResultVo.updateSuccess(new ClazzUpdateDto());
    }

    @ApiOperation("删除班级")
    @PatchMapping("/delete/{clazzId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzPatch(@PathVariable Long clazzId) {
        clazzService.patchClazz(clazzId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("批量删除班级")
    @PatchMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzDeleteAll(@RequestParam Long[] clazzIdArr) {
        clazzService.patchClazzAll(clazzIdArr);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("获取班级章节")
    @GetMapping("/{clazzId}/detail")
    public ResultVo clazzDetailInfoList(@PathVariable Long clazzId) {
        List<ClazzDetailInfoVo> clazzDetailInfoVos = clazzService.selectChapterList(clazzId);

        return ResultVo.querySuccess(clazzDetailInfoVos);
    }

    @ApiOperation("获取目录课件")
    @GetMapping("/{clazzId}/detail/{catalogueId}")
    public ResultVo clazzCatalogueInfo(@PathVariable Long clazzId,
                                       @PathVariable Long catalogueId) {
        CoursewareInfoVo coursewareInfoVo = clazzService.selectCourseware(catalogueId);

        return ResultVo.querySuccess(coursewareInfoVo);
    }

    @ApiOperation("修改目录课件")
    @PutMapping("/{clazzId}/detail/{chapterId}/{catalogueId}")
    public ResultVo clazzCatalogueUpdate(@PathVariable Long chapterId,
                                         @PathVariable Long clazzId,
                                         @PathVariable Long catalogueId,
                                         @RequestBody ClazzCatalogueUpdateDto clazzCatalogueUpdateDto) {
        ClazzCatalogueUpdateBo clazzCatalogueUpdateBo = new ClazzCatalogueUpdateDTOConvert().convert(clazzCatalogueUpdateDto);
        clazzCatalogueUpdateBo.setCatalogueId(catalogueId);
        clazzService.updateClazzCatalogue(clazzCatalogueUpdateBo);

        return ResultVo.updateSuccess(new ClazzCatalogueUpdateDto());
    }

    @ApiOperation("新增章")
    @PostMapping("/{clazzId}/detail/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzChapterAdd(@PathVariable Long clazzId,
                                    @RequestBody ClazzChapterAddDto clazzChapterAddDto) {
        ClazzChapterAddBo clazzChapterAddBo = new ClazzChapterAddDTOConvert().convert(clazzChapterAddDto);
        clazzChapterAddBo.setClazzId(clazzId);
        clazzService.insertChapter(clazzChapterAddBo);

        return ResultVo.insertSuccess(new ClazzChapterAddDto());
    }

    @ApiOperation("新增节")
    @PostMapping("/{clazzId}/detail/{chapterId}/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzCatalogueAdd(@PathVariable Long clazzId,
                                      @PathVariable Long chapterId,
                                      @RequestBody ClazzCatalogueAddDto clazzCatalogueAddDto) {
        ClazzCatalogueAddBo clazzCatalogueAddBo = new ClazzCatalogueAddDTOConvert().convert(clazzCatalogueAddDto);
        clazzCatalogueAddBo.setChapterId(chapterId);
        clazzService.insertCatalogue(clazzCatalogueAddBo);

        return ResultVo.insertSuccess(new ClazzChapterAddDto());
    }

    @ApiOperation("删除章")
    @PatchMapping("/{clazzId}/detail/{chapterId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzChapterDelete(@PathVariable Long clazzId,
                                       @PathVariable Long chapterId) {
        clazzService.deleteChapter(chapterId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("删除节")
    @PatchMapping("/{clazzId}/detail/{chapterId}/{catalogueId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzCatalogueDelete(@PathVariable Long clazzId,
                                         @PathVariable Long chapterId,
                                         @PathVariable Long catalogueId) {
        clazzService.patchCatalogue(catalogueId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("发布作业")
    @PostMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/addTask")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo clazzCatalogueTaskAdd(@PathVariable Long clazzId,
                                          @PathVariable Long chapterId,
                                          @PathVariable Long catalogueId,
                                          @RequestBody ClazzCatalogueTaskAddDto clazzCatalogueTaskAddDto) {
        ClazzCatalogueTaskAddBo clazzCatalogueTaskAddBo = new ClazzCatalogueTaskAddDTOConvert().convert(clazzCatalogueTaskAddDto);
        clazzCatalogueTaskAddBo.setCatalogueId(catalogueId);
        clazzCatalogueTaskAddBo.setHasTask('1');
        clazzService.insertTask(clazzCatalogueTaskAddBo);

        return ResultVo.insertSuccess(new ClazzCatalogueTaskAddDto());
    }

    @ApiOperation("刷新作业提交列表")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/task")
    public ResultVo taskInfoList(@PathVariable Long clazzId,
                                 @PathVariable Long chapterId,
                                 @PathVariable Long catalogueId) {
        List<TaskSubmitInfoVo> taskSubmitInfoVos = clazzService.selectTaskList(catalogueId);

        return ResultVo.querySuccess(taskSubmitInfoVos);
    }

//    @ApiOperation("下载学生作业")
//    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/{taskId}")
//    public ResultVo taskDownload(@PathVariable Long clazzId,
//                                 @PathVariable Long chapterId,
//                                 @PathVariable Long catalogueId,
//                                 @PathVariable Long taskId) {
//        clazzService.downloadTask(taskId);
//
//        return ResultVo.success("下载成功", null);
//    }

    @ApiOperation("获取评论列表")
    @GetMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/comment")
    public ResultVo commentInfoList(@PathVariable Long clazzId,
                                    @PathVariable Long chapterId,
                                    @PathVariable Long catalogueId) {
        List<CommentInfoVo> commentInfoVos = clazzService.selectComment(catalogueId);

        return ResultVo.querySuccess(commentInfoVos);
    }

    @ApiOperation("删除评论")
    @PatchMapping("/{clazzId}/detail/{chapterId}/{catalogueId}/{commentId}")
    public ResultVo commentDelete(@PathVariable Long clazzId,
                                  @PathVariable Long chapterId,
                                  @PathVariable Long catalogueId,
                                  @PathVariable Long commentId) {
        clazzService.patchComment(commentId);

        return ResultVo.deleteSuccess();
    }
}
