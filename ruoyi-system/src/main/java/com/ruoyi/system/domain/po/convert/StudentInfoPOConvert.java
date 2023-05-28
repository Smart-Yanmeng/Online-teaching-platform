package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BStudentInfoPo;
import com.ruoyi.system.domain.vo.online.student.StudentInfoVo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentInfoPOConvert implements ClassConvertTool<BStudentInfoPo, StudentInfoVo> {
    @Override
    public StudentInfoVo convert(BStudentInfoPo bStudentInfoPo) {
        StudentInfoVo studentInfoVo = new StudentInfoVo();
        BeanUtils.copyProperties(bStudentInfoPo, studentInfoVo);

        return studentInfoVo;
    }
}
