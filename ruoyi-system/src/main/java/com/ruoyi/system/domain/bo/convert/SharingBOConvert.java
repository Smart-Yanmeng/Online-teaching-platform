package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.sharing.SharingUpdateBo;
import com.ruoyi.system.domain.po.BSharingPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class SharingBOConvert implements ClassConvertTool<SharingUpdateBo, BSharingPo> {
    @Override
    public BSharingPo convert(SharingUpdateBo sharingUpdateBo) {
        BSharingPo sharingPo = new BSharingPo();
        BeanUtils.copyProperties(sharingUpdateBo, sharingPo);

        return sharingPo;
    }
}
