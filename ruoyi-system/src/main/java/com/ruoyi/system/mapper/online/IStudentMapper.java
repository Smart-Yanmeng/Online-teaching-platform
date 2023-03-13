package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BStudentClazzEntity;
import com.ruoyi.system.domain.entity.BStudentEntity;
import com.ruoyi.system.domain.entity.BUserEntity;
import com.ruoyi.system.domain.view.EmploymentInfoView;
import com.ruoyi.system.domain.view.StudentInfoView;
import com.ruoyi.system.domain.vo.student.EmploymentAddVo;
import com.ruoyi.system.domain.vo.student.EmploymentUpdateVo;
import com.ruoyi.system.domain.vo.student.StudentSearchVo;
import com.ruoyi.system.domain.vo.student.StudentUpdateVo;

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
