package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentAddBo;
import com.ruoyi.system.domain.dto.student.StudentAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentAddDTOConvert implements ClassConvertTool<StudentAddDto, StudentAddBo> {
    @Override
    public StudentAddBo convert(StudentAddDto studentAddDto) {
        StudentAddBo studentAddBo = new StudentAddBo();
        BeanUtils.copyProperties(studentAddDto, studentAddBo);

        studentAddBo.setCreateTime(DateUtils.getTime());
        studentAddBo.setCreateBy("admin");
        studentAddBo.setUpdateTime(DateUtils.getTime());
        studentAddBo.setUpdateBy("admin");
        studentAddBo.setStatus('0');
        studentAddBo.setDelFlag('0');
        // 加密密码
        studentAddBo.setPassword(SecurityUtils.encryptPassword(studentAddDto.getPassword()));

        return studentAddBo;
    }
}
