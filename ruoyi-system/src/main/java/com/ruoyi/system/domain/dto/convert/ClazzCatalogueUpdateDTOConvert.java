package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzCatalogueUpdateBo;
import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzCatalogueUpdateDTOConvert implements ClassConvertTool<ClazzCatalogueUpdateDto, ClazzCatalogueUpdateBo> {
    @Override
    public ClazzCatalogueUpdateBo convert(ClazzCatalogueUpdateDto clazzCatalogueUpdateDto) {
        ClazzCatalogueUpdateBo clazzCatalogueUpdateBo = new ClazzCatalogueUpdateBo();
        BeanUtils.copyProperties(clazzCatalogueUpdateDto, clazzCatalogueUpdateBo);

        // 新增数据
        clazzCatalogueUpdateBo.setUpdateTime(DateUtils.getTime());
        clazzCatalogueUpdateBo.setUpdateBy("admin");

        return clazzCatalogueUpdateBo;
    }
}
