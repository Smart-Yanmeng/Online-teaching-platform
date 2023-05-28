package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BComplaintPo;
import com.ruoyi.system.domain.vo.online.complaint.ComplaintInfoVo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ComplaintPOConvert implements ClassConvertTool<BComplaintPo, ComplaintInfoVo> {
    @Override
    public ComplaintInfoVo convert(BComplaintPo bComplaintPo) {
        ComplaintInfoVo complaintInfoVo = new ComplaintInfoVo();
        BeanUtils.copyProperties(bComplaintPo, complaintInfoVo);

        return complaintInfoVo;
    }
}
