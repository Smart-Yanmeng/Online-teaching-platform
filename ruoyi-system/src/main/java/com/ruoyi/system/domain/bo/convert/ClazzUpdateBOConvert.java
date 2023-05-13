package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzUpdateBo;
import com.ruoyi.system.domain.po.BClazzPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzUpdateBOConvert implements ClassConvertTool<ClazzUpdateBo, BClazzPo> {
    @Override
    public BClazzPo convert(ClazzUpdateBo clazzUpdateBo) {
        BClazzPo clazzPo = new BClazzPo();
        BeanUtils.copyProperties(clazzUpdateBo, clazzPo);

        return clazzPo;
    }
}
