package com.ruoyi.system.domain.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ComplaintInfoView {
    @ApiModelProperty("投诉类型")
    private String complaintType;

    @ApiModelProperty("投诉内容")
    private String complaintContent;

    @ApiModelProperty("备注")
    private String remark;
}
