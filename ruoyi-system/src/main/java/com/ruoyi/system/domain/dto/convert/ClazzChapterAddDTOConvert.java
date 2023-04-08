package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.clazz.ClazzChapterAddBo;
import com.ruoyi.system.domain.dto.clazz.ClazzChapterAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ClazzChapterAddDTOConvert implements ClassConvertTool<ClazzChapterAddDto, ClazzChapterAddBo> {
    @Override
    public ClazzChapterAddBo convert(ClazzChapterAddDto clazzChapterAddDto) {
        ClazzChapterAddBo clazzChapterAddBo = new ClazzChapterAddBo();
        BeanUtils.copyProperties(clazzChapterAddDto, clazzChapterAddBo);

        return clazzChapterAddBo;
    }
}
