package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzAddBo;
import com.ruoyi.system.domain.dto.clazz.ClazzAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzAddDTOConvert implements ClassConvertTool<ClazzAddDto, ClazzAddBo> {
    @Override
    public ClazzAddBo convert(ClazzAddDto clazzAddDto) {
        ClazzAddBo clazzAddBo = new ClazzAddBo();
        BeanUtils.copyProperties(clazzAddDto, clazzAddBo);

        // 新增数据
        clazzAddBo.setDelFlag('0');
        clazzAddBo.setCreateTime(DateUtils.getTime());
        clazzAddBo.setCreateBy("admin");
        clazzAddBo.setUpdateTime(DateUtils.getTime());
        clazzAddBo.setUpdateBy("admin");

        return clazzAddBo;
    }
}
