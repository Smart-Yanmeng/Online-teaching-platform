package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.EmploymentUpdateBo;
import com.ruoyi.system.domain.dto.student.EmploymentUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class EmploymentUpdateDTOConvert implements ClassConvertTool<EmploymentUpdateDto, EmploymentUpdateBo> {
    @Override
    public EmploymentUpdateBo convert(EmploymentUpdateDto employmentUpdateDto) {
        EmploymentUpdateBo employmentUpdateBo = new EmploymentUpdateBo();
        BeanUtils.copyProperties(employmentUpdateDto, employmentUpdateBo);

        employmentUpdateBo.setUpdateTime(DateUtils.getTime());
        employmentUpdateBo.setUpdateBy("admin");

        return employmentUpdateBo;
    }
}
