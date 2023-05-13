package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentUpdateBo;
import com.ruoyi.system.domain.po.BStudentPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentUpdateBOConvert implements ClassConvertTool<StudentUpdateBo, BStudentPo> {
    @Override
    public BStudentPo convert(StudentUpdateBo studentUpdateBo) {
        BStudentPo studentPo = new BStudentPo();
        BeanUtils.copyProperties(studentUpdateBo, studentPo);

        return studentPo;
    }
}
