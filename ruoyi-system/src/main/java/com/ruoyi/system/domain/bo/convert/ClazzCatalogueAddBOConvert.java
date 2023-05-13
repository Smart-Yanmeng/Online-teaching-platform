package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzCatalogueAddBo;
import com.ruoyi.system.domain.po.BCataloguePo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzCatalogueAddBOConvert implements ClassConvertTool<ClazzCatalogueAddBo, BCataloguePo> {
    @Override
    public BCataloguePo convert(ClazzCatalogueAddBo clazzCatalogueAddBo) {
        BCataloguePo cataloguePo = new BCataloguePo();
        BeanUtils.copyProperties(clazzCatalogueAddBo, cataloguePo);

        return cataloguePo;
    }
}
