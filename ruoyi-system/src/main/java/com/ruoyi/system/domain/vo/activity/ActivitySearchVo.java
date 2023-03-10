package com.ruoyi.system.domain.vo.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivitySearchVo {
    @ApiModelProperty("标题")
    private String activityTitle;

    @ApiModelProperty("发布状态")
    private Long isRelease;
}
