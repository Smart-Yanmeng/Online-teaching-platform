package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.sharing.SharingAddBo;
import com.ruoyi.system.domain.dto.sharing.SharingAddDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class SharingAddDTOConvert implements ClassConvertTool<SharingAddDto, SharingAddBo> {
    @Override
    public SharingAddBo convert(SharingAddDto sharingAddDto) {
        SharingAddBo sharingAddBo = new SharingAddBo();
        BeanUtils.copyProperties(sharingAddDto, sharingAddBo);

        sharingAddBo.setCreateTime(DateUtils.getTime());
        sharingAddBo.setCreateBy("admin");
        sharingAddBo.setDelFlag('0');
        sharingAddBo.setUpdateTime(DateUtils.getTime());
        sharingAddBo.setUpdateBy("admin");

        return sharingAddBo;
    }
}
