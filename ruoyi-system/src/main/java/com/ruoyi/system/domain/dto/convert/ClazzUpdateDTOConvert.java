package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzUpdateBo;
import com.ruoyi.system.domain.dto.clazz.ClazzUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzUpdateDTOConvert implements ClassConvertTool<ClazzUpdateDto, ClazzUpdateBo> {
    @Override
    public ClazzUpdateBo convert(ClazzUpdateDto clazzUpdateDto) {
        ClazzUpdateBo clazzUpdateBo = new ClazzUpdateBo();
        BeanUtils.copyProperties(clazzUpdateDto, clazzUpdateBo);

        return clazzUpdateBo;
    }
}
