package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentAddBo;
import com.ruoyi.system.domain.po.BStudentClazzPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentClazzAddBOConvert implements ClassConvertTool<StudentAddBo, BStudentClazzPo> {
    @Override
    public BStudentClazzPo convert(StudentAddBo studentAddBo) {
        BStudentClazzPo studentClazzPo = new BStudentClazzPo();
        BeanUtils.copyProperties(studentAddBo, studentClazzPo);

        return studentClazzPo;
    }
}
