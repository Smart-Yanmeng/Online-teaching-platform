package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.entity.BStudentClazzEntity;
import com.ruoyi.system.domain.entity.BStudentEntity;
import com.ruoyi.system.domain.entity.BUserEntity;
import com.ruoyi.system.domain.view.StudentInfoView;
import com.ruoyi.system.domain.vo.student.StudentAddVo;
import com.ruoyi.system.domain.vo.student.StudentSearchVo;
import com.ruoyi.system.domain.vo.student.StudentUpdateVo;
import com.ruoyi.system.mapper.online.IStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
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
    }

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
}
