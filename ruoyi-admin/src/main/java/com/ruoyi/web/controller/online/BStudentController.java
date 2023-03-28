package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.EmploymentInfoView;
import com.ruoyi.system.domain.view.common.ResultView;
import com.ruoyi.system.domain.view.StudentInfoView;
import com.ruoyi.system.domain.vo.student.EmploymentUpdateVo;
import com.ruoyi.system.domain.vo.student.StudentAddVo;
import com.ruoyi.system.domain.vo.student.StudentSearchVo;
import com.ruoyi.system.domain.vo.student.StudentUpdateVo;
import com.ruoyi.system.service.online.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/student")
@Api(tags = "Student")
public class BStudentController {
    @Resource
    StudentService studentService;

    @ApiOperation("刷新学生列表")
    @GetMapping()
    public ResultView studentInfo(@RequestParam @Valid Integer pageNum, @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<StudentInfoView> studentInfoViews = studentService.selectStudentList();

        return ResultView.querySuccess(studentInfoViews);
    }

    @ApiOperation("查询学生")
    @GetMapping("/list")
    public ResultView studentInfoSearchList(StudentSearchVo studentSearchVo) {
        List<StudentInfoView> studentInfoViews = studentService.queryStudentList(studentSearchVo);

        return ResultView.querySuccess(studentInfoViews);
    }

    @ApiOperation("重置学生列表")
    @GetMapping("/reset")
    public ResultView studentReset() {
        List<StudentInfoView> studentInfoViews = studentService.selectStudentList();

        return ResultView.querySuccess(studentInfoViews);
    }

    @ApiOperation("新增学生")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView studentAdd(@RequestBody StudentAddVo studentAddVo) {
        studentService.addStudent(studentAddVo);

        return ResultView.insertSuccess(null);
    }

    @ApiOperation("修改学生")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> studentUpdate(@RequestBody StudentUpdateVo studentUpdateVo) {
        studentService.updateStudent(studentUpdateVo);

        return ResultView.updateSuccess(null);
    }

    @ApiOperation("删除学生")
    @PatchMapping("/{userId}")
    public ResultView studentPatch(@PathVariable Long userId) {
        studentService.patchStudent(userId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("刷新就业信息")
    @GetMapping("/list/{userId}")
    public ResultView employmentInfo(@PathVariable Long userId) {
        EmploymentInfoView employmentInfoView = studentService.selectEmploymentInfo(userId);

        return ResultView.querySuccess(employmentInfoView);
    }

    @ApiOperation("修改就业信息")
    @PutMapping("/update/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView employmentUpdate(@PathVariable Long userId, @RequestBody EmploymentUpdateVo employmentUpdateVo) {
        employmentUpdateVo.setUserId(userId);
        studentService.updateEmployment(employmentUpdateVo);

        return ResultView.updateSuccess(null);
    }
}
