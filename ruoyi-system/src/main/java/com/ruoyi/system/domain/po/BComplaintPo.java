package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BComplaintPo {
    @ApiModelProperty("投诉ID")
    private Long complaintId;

    @ApiModelProperty("投诉类型")
    private String complaintType;

    @ApiModelProperty("投诉内容")
    private String complaintContent;

    @ApiModelProperty("删除标志(0代表存在，2代表删除)")
    private Character delFlag;

    @ApiModelProperty("备注")
    private String remark;
}
