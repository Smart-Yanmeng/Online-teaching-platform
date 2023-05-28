package com.ruoyi.system.domain.vo.online.complaint;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ComplaintInfoVo {
    @ApiModelProperty("投诉信息")
    private List<ComplaintInfo> complaintInfos;

    @ApiModelProperty("投诉数量")
    private Long complaintUseSum;
}
