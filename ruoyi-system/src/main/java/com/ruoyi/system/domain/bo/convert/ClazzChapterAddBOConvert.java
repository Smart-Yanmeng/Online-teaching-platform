package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzChapterAddBo;
import com.ruoyi.system.domain.po.BChapterPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzChapterAddBOConvert implements ClassConvertTool<ClazzChapterAddBo, BChapterPo> {
    @Override
    public BChapterPo convert(ClazzChapterAddBo clazzChapterAddBo) {
        BChapterPo chapterPo = new BChapterPo();
        BeanUtils.copyProperties(clazzChapterAddBo, chapterPo);

        return chapterPo;
    }
}
