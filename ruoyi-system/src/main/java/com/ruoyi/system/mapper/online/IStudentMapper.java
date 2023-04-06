package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.bo.student.EmploymentUpdateBo;
import com.ruoyi.system.domain.po.*;
import com.ruoyi.system.domain.vo.online.EmploymentInfoVo;
import com.ruoyi.system.domain.bo.student.EmploymentUpdateVo;
import com.ruoyi.system.domain.bo.student.StudentSearchBo;

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

    List<BStudentInfoPo> selectStudent();

    List<BStudentInfoPo> queryStudentByCondition(StudentSearchBo studentSearchBo);

    void addStudent(BStudentPo studentPo);

    void addUser(BUserPo userPo);

    void addStudentClazz(BStudentClazzPo studentClazzPo);

    void addEmploymentInfo(BEmploymentPo employmentPo);

    void updateStudent(BStudentPo studentPo);

    void updateUser(BUserPo userPo);

    void updateStudentClazz(Long clazzId);

    void moveOutStudent(Long userId);

    void changeUserDelFlag(Long userId);

    void changeEmploymentInfoDelFlag(Long userId);

    EmploymentInfoVo selectEmployment(Long userId);

    void updateEmployment(EmploymentUpdateBo employmentUpdateBo);
}
