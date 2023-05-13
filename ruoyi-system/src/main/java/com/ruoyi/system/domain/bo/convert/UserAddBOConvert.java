package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.student.StudentAddBo;
import com.ruoyi.system.domain.po.BUserPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class UserAddBOConvert implements ClassConvertTool<StudentAddBo, BUserPo> {
    @Override
    public BUserPo convert(StudentAddBo studentAddBo) {
        BUserPo userPo = new BUserPo();
        BeanUtils.copyProperties(studentAddBo, userPo);

        return userPo;
    }
}
