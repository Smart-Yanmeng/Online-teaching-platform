package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentAddBo;
import com.ruoyi.system.domain.po.BEmploymentInfoPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class EmploymentAddBOConvert implements ClassConvertTool<StudentAddBo, BEmploymentInfoPo> {
    @Override
    public BEmploymentInfoPo convert(StudentAddBo studentAddBo) {
        BEmploymentInfoPo employmentPo = new BEmploymentInfoPo();
        BeanUtils.copyProperties(studentAddBo, employmentPo);

        return employmentPo;
    }
}
