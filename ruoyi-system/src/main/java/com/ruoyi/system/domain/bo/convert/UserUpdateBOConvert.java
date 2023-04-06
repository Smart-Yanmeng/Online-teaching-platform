package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentUpdateBo;
import com.ruoyi.system.domain.po.BUserPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class UserUpdateBOConvert implements ClassConvertTool<StudentUpdateBo, BUserPo> {
    @Override
    public BUserPo convert(StudentUpdateBo studentUpdateBo) {
        BUserPo userPo = new BUserPo();
        BeanUtils.copyProperties(studentUpdateBo, userPo);

        return userPo;
    }
}
