package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.bo.student.*;
import com.ruoyi.system.domain.dto.convert.EmploymentUpdateDTOConvert;
import com.ruoyi.system.domain.dto.convert.StudentAddDTOConvert;
import com.ruoyi.system.domain.dto.convert.StudentUpdateDTOConvert;
import com.ruoyi.system.domain.dto.student.EmploymentUpdateDto;
import com.ruoyi.system.domain.vo.online.student.EmploymentInfoVo;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.vo.online.student.StudentInfoVo;
import com.ruoyi.system.domain.dto.student.StudentAddDto;
import com.ruoyi.system.domain.dto.student.StudentUpdateDto;
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
    public ResultVo studentInfo(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentInfoVo> studentInfoVos = studentService.selectStudentList();

        return ResultVo.querySuccess(studentInfoVos);
    }

    @ApiOperation("查询学生")
    @GetMapping("/list")
    public ResultVo studentInfoSearchList(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                          @RequestParam(defaultValue = "10") @Valid Integer pageSize,
                                          @RequestParam(required = false) String nickName,
                                          @RequestParam(required = false) String phoneNumber,
                                          @RequestParam(required = false) String grade,
                                          @RequestParam(required = false) String school,
                                          @RequestParam(required = false) String major,
                                          @RequestParam(required = false) Character direction) {
        StudentSearchBo studentSearchBo = new StudentSearchBo();
        studentSearchBo.setNickName(nickName);
        studentSearchBo.setPhoneNumber(phoneNumber);
        studentSearchBo.setGrade(grade);
        studentSearchBo.setSchool(school);
        studentSearchBo.setMajor(major);
        studentSearchBo.setDirection(direction);

        PageHelper.startPage(pageNum, pageSize);
        List<StudentInfoVo> studentInfoVos = studentService.queryStudentList(studentSearchBo);

        return ResultVo.querySuccess(studentInfoVos);
    }

    @ApiOperation("重置学生列表")
    @GetMapping("/reset")
    public ResultVo studentReset(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                 @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentInfoVo> studentInfoVos = studentService.selectStudentList();

        return ResultVo.querySuccess(studentInfoVos);
    }

    @ApiOperation("新增学生")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo studentAdd(@RequestBody StudentAddDto studentAddDto) {
        StudentAddBo studentAddBo = new StudentAddDTOConvert().convert(studentAddDto);
        studentService.addStudent(studentAddBo);

        return ResultVo.insertSuccess(new StudentAddDto());
    }

    @ApiOperation("批量删除学生")
    @PatchMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo studentPatchAll(@RequestParam Long[] studentIdArr) {
        for (Long item : studentIdArr) {
            studentService.patchStudent(item);
        }

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("修改学生")
    @PutMapping("/update/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo studentUpdate(@PathVariable Long userId,
                                  @RequestBody StudentUpdateDto studentUpdateDto) {
        studentUpdateDto.setUserId(userId);
        StudentUpdateBo studentUpdateBo = new StudentUpdateDTOConvert().convert(studentUpdateDto);
        studentService.updateStudent(studentUpdateBo);

        return ResultVo.updateSuccess(new StudentAddDto());
    }

    @ApiOperation("删除学生")
    @PatchMapping("/delete/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo studentPatch(@PathVariable Long userId) {
        studentService.patchStudent(userId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("获取就业信息")
    @GetMapping("/list/{userId}")
    public ResultVo employmentInfo(@PathVariable Long userId) {
        EmploymentInfoVo employmentInfoVo = studentService.selectEmploymentInfo(userId);

        return ResultVo.querySuccess(employmentInfoVo);
    }

    @ApiOperation("修改就业信息")
    @PutMapping("/employment/update/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo employmentUpdate(@PathVariable Long userId,
                                     @RequestBody EmploymentUpdateDto employmentUpdateDto) {
        employmentUpdateDto.setUserId(userId);
        EmploymentUpdateBo employmentUpdateBo = new EmploymentUpdateDTOConvert().convert(employmentUpdateDto);
        studentService.updateEmployment(employmentUpdateBo);

        return ResultVo.updateSuccess(new EmploymentUpdateDto());
    }
}
