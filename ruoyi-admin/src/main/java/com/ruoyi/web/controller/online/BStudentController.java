package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.EmploymentInfoView;
import com.ruoyi.system.domain.view.ResultView;
import com.ruoyi.system.domain.view.StudentInfoView;
import com.ruoyi.system.domain.vo.student.EmploymentUpdateVo;
import com.ruoyi.system.domain.vo.student.StudentAddVo;
import com.ruoyi.system.domain.vo.student.StudentSearchVo;
import com.ruoyi.system.domain.vo.student.StudentUpdateVo;
import com.ruoyi.system.service.online.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/student")
@Api(tags = "Student")
public class BStudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation("刷新学生列表")
    @GetMapping()
    public ResultView<List<StudentInfoView>> studentInfo(@RequestParam @Valid Integer pageNum, @RequestParam @Valid Integer pageSize) {
        List<StudentInfoView> studentInfoViews = studentService.selectStudentList();

        PageHelper.startPage(pageNum, pageSize);
        ResultView<List<StudentInfoView>> resultView = new ResultView<>();
        resultView.setData(studentInfoViews);

        return resultView;
    }

    @ApiOperation("查询学生")
    @GetMapping("/list")
    public ResultView<List<StudentInfoView>> studentInfoSearchList(StudentSearchVo studentSearchVo) {
        List<StudentInfoView> studentInfoViews = studentService.queryStudentList(studentSearchVo);

        ResultView<List<StudentInfoView>> resultView = new ResultView<>();
        resultView.setData(studentInfoViews);

        return resultView;
    }

    @ApiOperation("重置学生列表")
    @GetMapping("/reset")
    public ResultView<List<StudentInfoView>> studentReset() {
        List<StudentInfoView> studentInfoViews = studentService.selectStudentList();

        ResultView<List<StudentInfoView>> resultView = new ResultView<>();
        resultView.setData(studentInfoViews);

        return resultView;
    }

    @ApiOperation("新增学生")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> studentAdd(@RequestBody StudentAddVo studentAddVo) {
        studentService.addStudent(studentAddVo);

        return new ResultView<>();
    }

    @ApiOperation("修改学生")
    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> studentUpdate(@RequestBody StudentUpdateVo studentUpdateVo) {
        studentService.updateStudent(studentUpdateVo);

        return new ResultView<>();
    }

    @ApiOperation("删除学生")
    @DeleteMapping("/delete")
    public ResultView<Object> studentDelete(@RequestParam Long userId) {
        studentService.deleteStudent(userId);

        return new ResultView<>();
    }

    @ApiOperation("刷新就业信息")
    @GetMapping("/list/{userId}")
    public ResultView<EmploymentInfoView> employmentInfo(@PathVariable Long userId) {
        EmploymentInfoView employmentInfoView = studentService.selectEmploymentInfo(userId);

        ResultView<EmploymentInfoView> resultView = new ResultView<>();
        resultView.setData(employmentInfoView);

        return resultView;
    }

    @ApiOperation("修改就业信息")
    @PutMapping("/update/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> employmentUpdate(@PathVariable Long userId, @RequestBody EmploymentUpdateVo employmentUpdateVo) {
        employmentUpdateVo.setUserId(userId);
        studentService.updateEmployment(employmentUpdateVo);

        return new ResultView<>();
    }
}
