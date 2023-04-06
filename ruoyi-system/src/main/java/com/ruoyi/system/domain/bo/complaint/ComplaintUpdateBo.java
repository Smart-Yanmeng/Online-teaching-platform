package com.ruoyi.system.domain.bo.complaint;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ComplaintUpdateBo {
    @ApiModelProperty("投诉ID")
    private Long complaintId;

    @ApiModelProperty("备注")
    private String remark;
}
