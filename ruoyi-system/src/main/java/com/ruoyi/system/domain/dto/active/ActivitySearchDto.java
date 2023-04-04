package com.ruoyi.system.domain.dto.active;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivitySearchDto {
    @ApiModelProperty("标题")
    private String activityTitle;

    @ApiModelProperty("发布状态")
    private Long isRelease;
}
