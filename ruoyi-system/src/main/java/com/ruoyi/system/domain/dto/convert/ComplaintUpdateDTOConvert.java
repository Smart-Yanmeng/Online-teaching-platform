package com.ruoyi.system.domain.dto.convert;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateBo;
import com.ruoyi.system.domain.dto.complaint.ComplaintUpdateDto;
import com.ruoyi.system.tool.intf.ClassConvertTool;

public class ComplaintUpdateDTOConvert implements ClassConvertTool<ComplaintUpdateDto, ComplaintUpdateBo> {
    @Override
    public ComplaintUpdateBo convert(ComplaintUpdateDto complaintUpdateDto) {
        ComplaintUpdateBo complaintUpdateBo = new ComplaintUpdateBo();
        BeanUtils.copyProperties(complaintUpdateDto, complaintUpdateBo);

        return complaintUpdateBo;
    }
}
