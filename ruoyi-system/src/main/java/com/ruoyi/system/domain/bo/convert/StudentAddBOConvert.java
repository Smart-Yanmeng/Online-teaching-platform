package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentAddBo;
import com.ruoyi.system.domain.po.BStudentPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentAddBOConvert implements ClassConvertTool<StudentAddBo, BStudentPo> {
    @Override
    public BStudentPo convert(StudentAddBo studentAddBo) {
        BStudentPo studentPo = new BStudentPo();
        BeanUtils.copyProperties(studentAddBo, studentPo);

        return studentPo;
    }
}
