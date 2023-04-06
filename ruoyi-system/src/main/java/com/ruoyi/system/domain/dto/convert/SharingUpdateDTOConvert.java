package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.sharing.SharingUpdateBo;
import com.ruoyi.system.domain.dto.sharing.SharingUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class SharingUpdateDTOConvert implements ClassConvertTool<SharingUpdateDto, SharingUpdateBo> {
    @Override
    public SharingUpdateBo convert(SharingUpdateDto sharingUpdateDto) {
        SharingUpdateBo sharingUpdateBo = new SharingUpdateBo();
        BeanUtils.copyProperties(sharingUpdateDto, sharingUpdateBo);

        sharingUpdateBo.setUpdateTime(DateUtils.getTime());
        sharingUpdateBo.setUpdateBy("admin");

        return sharingUpdateBo;
    }
}
