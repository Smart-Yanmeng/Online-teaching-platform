package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentAddBo;
import com.ruoyi.system.domain.po.BEmploymentPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class EmploymentAddBOConvert implements ClassConvertTool<StudentAddBo, BEmploymentPo> {
    @Override
    public BEmploymentPo convert(StudentAddBo studentAddBo) {
        BEmploymentPo employmentPo = new BEmploymentPo();
        BeanUtils.copyProperties(studentAddBo, employmentPo);

        return employmentPo;
    }
}
