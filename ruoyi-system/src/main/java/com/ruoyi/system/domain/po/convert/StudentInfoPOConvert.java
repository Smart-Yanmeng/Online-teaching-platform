package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BStudentInfoPo;
import com.ruoyi.system.domain.vo.online.student.StudentInfo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentInfoPOConvert implements ClassConvertTool<BStudentInfoPo, StudentInfo> {
    @Override
    public StudentInfo convert(BStudentInfoPo bStudentInfoPo) {
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(bStudentInfoPo, studentInfo);

        return studentInfo;
    }
}
