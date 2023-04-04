package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.vo.online.EmploymentInfoView;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.vo.online.StudentInfoView;
import com.ruoyi.system.domain.bo.student.EmploymentUpdateVo;
import com.ruoyi.system.domain.bo.student.StudentAddVo;
import com.ruoyi.system.domain.bo.student.StudentSearchVo;
import com.ruoyi.system.domain.bo.student.StudentUpdateVo;
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
    public ResultVo studentInfo(@RequestParam @Valid Integer pageNum, @RequestParam @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<StudentInfoView> studentInfoViews = studentService.selectStudentList();

        return ResultVo.querySuccess(studentInfoViews);
    }

    @ApiOperation("查询学生")
    @GetMapping("/list")
    public ResultVo studentInfoSearchList(StudentSearchVo studentSearchVo) {
        List<StudentInfoView> studentInfoViews = studentService.queryStudentList(studentSearchVo);

        return ResultVo.querySuccess(studentInfoViews);
    }

    @ApiOperation("重置学生列表")
    @GetMapping("/reset")
    public ResultVo studentReset() {
        List<StudentInfoView> studentInfoViews = studentService.selectStudentList();

        return ResultVo.querySuccess(studentInfoViews);
    }

    @ApiOperation("新增学生")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo studentAdd(@RequestBody StudentAddVo studentAddVo) {
        studentService.addStudent(studentAddVo);

        return ResultVo.insertSuccess(null);
    }

    @ApiOperation("修改学生")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo<Object> studentUpdate(@RequestBody StudentUpdateVo studentUpdateVo) {
        studentService.updateStudent(studentUpdateVo);

        return ResultVo.updateSuccess(null);
    }

    @ApiOperation("删除学生")
    @PatchMapping("/{userId}")
    public ResultVo studentPatch(@PathVariable Long userId) {
        studentService.patchStudent(userId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("刷新就业信息")
    @GetMapping("/list/{userId}")
    public ResultVo employmentInfo(@PathVariable Long userId) {
        EmploymentInfoView employmentInfoView = studentService.selectEmploymentInfo(userId);

        return ResultVo.querySuccess(employmentInfoView);
    }

    @ApiOperation("修改就业信息")
    @PutMapping("/update/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo employmentUpdate(@PathVariable Long userId, @RequestBody EmploymentUpdateVo employmentUpdateVo) {
        employmentUpdateVo.setUserId(userId);
        studentService.updateEmployment(employmentUpdateVo);

        return ResultVo.updateSuccess(null);
    }
}
