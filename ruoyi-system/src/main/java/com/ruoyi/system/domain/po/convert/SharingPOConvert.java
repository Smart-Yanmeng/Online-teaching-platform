package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BSharingPo;
import com.ruoyi.system.domain.vo.online.sharing.SharingInfo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class SharingPOConvert implements ClassConvertTool<BSharingPo, SharingInfo> {
    @Override
    public SharingInfo convert(BSharingPo bSharingPo) {
        SharingInfo sharingInfo = new SharingInfo();
        BeanUtils.copyProperties(bSharingPo, sharingInfo);

        return sharingInfo;
    }
}
