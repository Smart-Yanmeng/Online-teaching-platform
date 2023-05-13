package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzAddBo;
import com.ruoyi.system.domain.po.BClazzPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzAddBOCovert implements ClassConvertTool<ClazzAddBo, BClazzPo> {
    @Override
    public BClazzPo convert(ClazzAddBo clazzAddBo) {
        BClazzPo clazzPo = new BClazzPo();
        BeanUtils.copyProperties(clazzAddBo, clazzPo);

        return clazzPo;
    }
}
