package com.ruoyi.system.domain.vo.online.complaint;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ComplaintInfo {
    @ApiModelProperty("投诉ID")
    private Long complaintId;

    @ApiModelProperty("投诉类型")
    private String complaintType;

    @ApiModelProperty("投诉内容")
    private String complaintContent;

    @ApiModelProperty("备注")
    private String remark;
}
