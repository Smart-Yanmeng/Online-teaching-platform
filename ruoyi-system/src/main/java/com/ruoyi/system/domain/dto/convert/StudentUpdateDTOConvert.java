package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentUpdateBo;
import com.ruoyi.system.domain.dto.student.StudentUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class StudentUpdateDTOConvert implements ClassConvertTool<StudentUpdateDto, StudentUpdateBo> {
    @Override
    public StudentUpdateBo convert(StudentUpdateDto studentUpdateDto) {
        StudentUpdateBo studentUpdateBo = new StudentUpdateBo();
        BeanUtils.copyProperties(studentUpdateDto, studentUpdateBo);

        studentUpdateBo.setUpdateTime(DateUtils.getTime());
        studentUpdateBo.setUpdateBy("admin");

        return studentUpdateBo;
    }
}
