package com.ruoyi.system.domain.vo.complaint;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ComplaintUpdateVo {
    @ApiModelProperty("投诉ID")
    private Long complaintId;

    @ApiModelProperty("备注")
    private String remark;
}
