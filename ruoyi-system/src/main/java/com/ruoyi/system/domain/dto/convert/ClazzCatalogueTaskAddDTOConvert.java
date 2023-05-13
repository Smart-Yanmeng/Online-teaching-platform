package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzCatalogueTaskAddBo;
import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueTaskAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzCatalogueTaskAddDTOConvert implements ClassConvertTool<ClazzCatalogueTaskAddDto, ClazzCatalogueTaskAddBo> {
    @Override
    public ClazzCatalogueTaskAddBo convert(ClazzCatalogueTaskAddDto clazzCatalogueTaskAddDto) {
        ClazzCatalogueTaskAddBo clazzCatalogueTaskAddBo = new ClazzCatalogueTaskAddBo();
        BeanUtils.copyProperties(clazzCatalogueTaskAddDto, clazzCatalogueTaskAddBo);

        return clazzCatalogueTaskAddBo;
    }
}
