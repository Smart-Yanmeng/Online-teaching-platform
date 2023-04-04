package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.po.BStudentClazzEntity;
import com.ruoyi.system.domain.po.BStudentEntity;
import com.ruoyi.system.domain.po.BUserEntity;
import com.ruoyi.system.domain.vo.online.EmploymentInfoView;
import com.ruoyi.system.domain.vo.online.StudentInfoView;
import com.ruoyi.system.domain.bo.student.EmploymentAddVo;
import com.ruoyi.system.domain.bo.student.EmploymentUpdateVo;
import com.ruoyi.system.domain.bo.student.StudentSearchVo;
import com.ruoyi.system.domain.bo.student.StudentUpdateVo;

import java.util.List;

public interface IStudentMapper {
    // 获取 userId
    Long countUser();

    // 获取 clazzId
    Long selectClazzId(String clazzName);

    // 获取 clazzName
    String selectClazzName(Long clazzId);

    // 获取 employmentId
    Long countEmployment();

    List<StudentInfoView> selectStudent();

    List<StudentInfoView> queryStudentByCondition(StudentSearchVo studentSearchVo);

    void addStudent(BStudentEntity studentEntity);

    void addUser(BUserEntity userEntity);

    void addStudentClazz(BStudentClazzEntity studentClazzEntity);

    void addEmploymentInfo(EmploymentAddVo employmentAddVo);

    void updateStudent(StudentUpdateVo studentUpdateVo);

    void updateUser(StudentUpdateVo studentUpdateVo);

    void updateStudentClazz(Long clazzId);

    void moveOutStudent(Long userId);

    void changeUserDelFlag(Long userId);

    void changeEmploymentInfoDelFlag(Long userId);

    EmploymentInfoView selectEmployment(Long userId);

    void updateEmployment(EmploymentUpdateVo employmentUpdateVo);
}
