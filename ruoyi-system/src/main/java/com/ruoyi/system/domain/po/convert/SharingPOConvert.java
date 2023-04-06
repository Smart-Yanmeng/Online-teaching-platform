package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BSharingPo;
import com.ruoyi.system.domain.vo.online.SharingInfoVo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class SharingPOConvert implements ClassConvertTool<BSharingPo, SharingInfoVo> {
    @Override
    public SharingInfoVo convert(BSharingPo bSharingPo) {
        SharingInfoVo sharingInfoVo = new SharingInfoVo();
        BeanUtils.copyProperties(bSharingPo, sharingInfoVo);

        return sharingInfoVo;
    }
}
