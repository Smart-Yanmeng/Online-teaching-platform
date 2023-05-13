package com.ruoyi.system.domain.bo.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.sharing.SharingAddBo;
import com.ruoyi.system.domain.po.BSharingPo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class SharingAddBOConvert implements ClassConvertTool<SharingAddBo, BSharingPo> {
    @Override
    public BSharingPo convert(SharingAddBo sharingAddBo) {
        BSharingPo sharingPo = new BSharingPo();
        BeanUtils.copyProperties(sharingAddBo, sharingPo);

        return sharingPo;
    }
}
