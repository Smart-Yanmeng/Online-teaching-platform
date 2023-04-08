package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzCatalogueAddBo;
import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzCatalogueAddDTOConvert implements ClassConvertTool<ClazzCatalogueAddDto, ClazzCatalogueAddBo> {
    @Override
    public ClazzCatalogueAddBo convert(ClazzCatalogueAddDto clazzCatalogueAddDto) {
        ClazzCatalogueAddBo clazzCatalogueAddBo = new ClazzCatalogueAddBo();
        BeanUtils.copyProperties(clazzCatalogueAddDto, clazzCatalogueAddBo);

        // 新增数据
        clazzCatalogueAddBo.setDelFlag('0');
        clazzCatalogueAddBo.setCreateTime(DateUtils.getTime());
        clazzCatalogueAddBo.setCreateBy("admin");
        clazzCatalogueAddBo.setUpdateTime(DateUtils.getTime());
        clazzCatalogueAddBo.setUpdateBy("admin");

        return clazzCatalogueAddBo;
    }
}
