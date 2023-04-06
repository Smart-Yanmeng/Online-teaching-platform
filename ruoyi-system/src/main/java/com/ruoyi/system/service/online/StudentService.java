package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.bo.convert.*;
import com.ruoyi.system.domain.po.*;
import com.ruoyi.system.domain.po.convert.StudentInfoPOConvert;
import com.ruoyi.system.domain.vo.online.EmploymentInfoVo;
import com.ruoyi.system.domain.vo.online.StudentInfoVo;
import com.ruoyi.system.domain.bo.student.*;
import com.ruoyi.system.mapper.online.IStudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Resource
    IStudentMapper studentMapper;

    /**
     * 刷新 - 重置学生列表
     *
     * @return List<StudentInfoVo>
     */
    public List<StudentInfoVo> selectStudentList() {
        List<BStudentInfoPo> studentInfoPos = studentMapper.selectStudent();

        return studentInfoPos.stream().map(item -> new StudentInfoPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 查询学生
     *
     * @param studentSearchBo 学生查询信息
     */
    public List<StudentInfoVo> queryStudentList(StudentSearchBo studentSearchBo) {
        List<BStudentInfoPo> studentInfoPos = studentMapper.queryStudentByCondition(studentSearchBo);

        return studentInfoPos.stream().map(item -> new StudentInfoPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 新增学生
     *
     * @param studentAddBo 新增学生信息
     */
    public void addStudent(StudentAddBo studentAddBo) {
        // 获取 userId
        Long userId = studentMapper.countUser() + 1;
        // 获取班级 ID
        Long clazzId = studentMapper.selectClazzId(studentAddBo.getClazzName());
        // 获取 employmentId
        Long employmentId = studentMapper.countEmployment() + 1;

        // 插入 ms_student 表
        BStudentPo studentPo = new StudentAddBOConvert().convert(studentAddBo);
        studentPo.setUserId(userId);
        studentPo.setClazzId(clazzId);

        studentMapper.addStudent(studentPo);

        // 插入 sys_user 表
        BUserPo userPo = new UserAddBOConvert().convert(studentAddBo);
        userPo.setUserId(userId);

        studentMapper.addUser(userPo);

        // 插入 ms_student_class 表
        BStudentClazzPo studentClazzPo = new StudentClazzAddBOConvert().convert(studentAddBo);
        studentClazzPo.setUserId(userId);
        studentClazzPo.setClazzId(clazzId);

        studentMapper.addStudentClazz(studentClazzPo);

        // 插入 ms_employment_info 表
        BEmploymentPo employmentPo = new EmploymentAddBOConvert().convert(studentAddBo);
        employmentPo.setUserId(userId);
        employmentPo.setEmploymentId(employmentId);

        studentMapper.addEmploymentInfo(employmentPo);
    }

    /**
     * 修改学生信息
     *
     * @param studentUpdateBo 学生修改信息
     */
    public void updateStudent(StudentUpdateBo studentUpdateBo) {
        // 修改 ms_student 表
        BStudentPo studentPo = new StudentUpdateBOConvert().convert(studentUpdateBo);
        studentMapper.updateStudent(studentPo);

        // 修改 sys_user 表
        BUserPo userPo = new UserUpdateBOConvert().convert(studentUpdateBo);
        studentMapper.updateUser(userPo);

        // 修改 ms_student_class 表 ( 如果 clazzName 被修改了 )
        if (studentUpdateBo.getClazzName() != studentMapper.selectClazzName(studentUpdateBo.getUserId())) {
            studentMapper.updateStudentClazz(studentMapper.selectClazzId(studentUpdateBo.getClazzName()));
        }
    }

    /**
     * 删除学生
     *
     * @param userId 用户 ID
     */
    public void patchStudent(Long userId) {
        // 移出学生
        studentMapper.moveOutStudent(userId);

        // 修改 sys_user 表中的删除标志
        studentMapper.changeUserDelFlag(userId);

        // 修改 ms_employment_info 表中的删除标志
        studentMapper.changeEmploymentInfoDelFlag(userId);
    }

    /**
     * 刷新结业信息
     *
     * @param userId 用户 ID
     * @return EmploymentInfoVo
     */
    public EmploymentInfoVo selectEmploymentInfo(Long userId) {
        EmploymentInfoVo employmentInfoVo = studentMapper.selectEmployment(userId);

        return employmentInfoVo;
    }

    /**
     * 修改就业信息
     *
     * @param employmentUpdateBo 就业信息修改信息
     */
    public void updateEmployment(EmploymentUpdateBo employmentUpdateBo) {
        studentMapper.updateEmployment(employmentUpdateBo);
    }
}
