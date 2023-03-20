package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.entity.BStudentClazzEntity;
import com.ruoyi.system.domain.entity.BStudentEntity;
import com.ruoyi.system.domain.entity.BUserEntity;
import com.ruoyi.system.domain.view.EmploymentInfoView;
import com.ruoyi.system.domain.view.StudentInfoView;
import com.ruoyi.system.domain.vo.student.*;
import com.ruoyi.system.mapper.online.IStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    IStudentMapper studentMapper;

    /**
     * 刷新 - 重置学生列表
     *
     * @return
     */
    public List<StudentInfoView> selectStudentList() {
        List<StudentInfoView> studentInfoViews = studentMapper.selectStudent();

        return studentInfoViews;
    }

    /**
     * 查询学生
     *
     * @param studentSearchVo
     */
    public List<StudentInfoView> queryStudentList(StudentSearchVo studentSearchVo) {
        List<StudentInfoView> studentInfoViews = studentMapper.queryStudentByCondition(studentSearchVo);

        return studentInfoViews;
    }

    /**
     * 新增学生
     *
     * @param studentAddVo
     */
    public void addStudent(StudentAddVo studentAddVo) {
        // 获取 userId
        Long userId = studentMapper.countUser() + 1;
        // 获取创建时间
        String createTime = DateUtils.getTime();
        // 获取创建人
//        String createBy = SecurityUtils.getUsername();
        String createBy = "Admin";
        // 获取班级 ID
        Long clazzId = studentMapper.selectClazzId(studentAddVo.getClazzName());
        // 加密密码
        String password = SecurityUtils.encryptPassword(studentAddVo.getPassword());
        // 获取 employmentId
        Long employmentId = studentMapper.countEmployment() + 1;

        // 插入 ms_student 表
        BStudentEntity studentEntity = studentAddVo.transferToStudentEntity(new BStudentEntity());
        studentEntity.setUserId(userId);
        studentEntity.setClazzId(clazzId);
        studentEntity.setCreateBy(createBy);
        studentEntity.setCreateTime(createTime);
        studentEntity.setUpdateBy(createBy);
        studentEntity.setUpdateTime(createTime);

        studentMapper.addStudent(studentEntity);

        // 插入 sys_user 表
        BUserEntity userEntity = studentAddVo.transferToUserEntity(new BUserEntity());
        userEntity.setUserId(userId);
        userEntity.setPassword(password);
        userEntity.setStatus('0');
        userEntity.setDelFlag('0');
        userEntity.setCreateBy(createBy);
        userEntity.setCreateTime(createTime);
        userEntity.setUpdateBy(createBy);
        userEntity.setUpdateTime(createTime);

        studentMapper.addUser(userEntity);

        // 插入 ms_student_class 表
        BStudentClazzEntity studentClazzEntity = studentAddVo.transferToStudentClazzEntity(new BStudentClazzEntity());
        studentClazzEntity.setUserId(userId);
        studentClazzEntity.setClazzId(clazzId);
        studentClazzEntity.setStatus('0');
        studentClazzEntity.setCreateTime(createTime);

        studentMapper.addStudentClazz(studentClazzEntity);

        // 插入 ms_employment_info 表
        EmploymentAddVo employmentAddVo = new EmploymentAddVo();
        employmentAddVo.setEmploymentId(employmentId);
        employmentAddVo.setUserId(userId);
        employmentAddVo.setCreateBy(createBy);
        employmentAddVo.setCreateTime(createTime);

        studentMapper.addEmploymentInfo(employmentAddVo);
    }

    /**
     * 修改学生信息
     *
     * @param studentUpdateVo
     */
    public void updateStudent(StudentUpdateVo studentUpdateVo) {
        // 获取更新时间
        String updateTime = DateUtils.getTime();
        // 获取更新者
//        String createBy = SecurityUtils.getUsername();
        String updateBy = "Admin";

        studentUpdateVo.setUpdateTime(updateTime);
        studentUpdateVo.setUpdateBy(updateBy);

        // 修改 ms_student 表
        studentMapper.updateStudent(studentUpdateVo);

        // 修改 sys_user 表
        studentMapper.updateUser(studentUpdateVo);

        // 修改 ms_student_class 表 ( 如果 clazzName 被修改了 )
        if (studentUpdateVo.getClazzName() != studentMapper.selectClazzName(studentUpdateVo.getUserId())) {
            studentMapper.updateStudentClazz(studentMapper.selectClazzId(studentUpdateVo.getClazzName()));
        }
    }

    /**
     * 删除学生
     *
     * @param userId
     */
    public void deleteStudent(Long userId) {
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
     * @param userId
     * @return
     */
    public EmploymentInfoView selectEmploymentInfo(Long userId) {
        studentMapper.selectEmployment(userId);

        return new EmploymentInfoView();
    }

    /**
     * 修改就业信息
     *
     * @param employmentUpdateVo
     */
    public void updateEmployment(EmploymentUpdateVo employmentUpdateVo) {
        studentMapper.updateEmployment(employmentUpdateVo);
    }
}
