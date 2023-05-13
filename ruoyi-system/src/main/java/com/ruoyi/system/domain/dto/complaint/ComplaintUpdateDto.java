package com.ruoyi.system.domain.dto.complaint;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ComplaintUpdateDto {
    @ApiModelProperty("投诉ID")
    private Long complaintId;

    @ApiModelProperty("备注")
    private String remark;
}
