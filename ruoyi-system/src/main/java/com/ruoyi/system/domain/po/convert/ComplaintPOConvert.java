package com.ruoyi.system.domain.po.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BComplaintPo;
import com.ruoyi.system.domain.vo.online.complaint.ComplaintInfo;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ComplaintPOConvert implements ClassConvertTool<BComplaintPo, ComplaintInfo> {
    @Override
    public ComplaintInfo convert(BComplaintPo bComplaintPo) {
        ComplaintInfo complaintInfo = new ComplaintInfo();
        BeanUtils.copyProperties(bComplaintPo, complaintInfo);

        return complaintInfo;
    }
}
