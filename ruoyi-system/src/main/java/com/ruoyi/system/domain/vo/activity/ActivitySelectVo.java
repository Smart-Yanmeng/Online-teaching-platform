package com.ruoyi.system.domain.vo.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ActivitySelectVo {
    @NotBlank
    @ApiModelProperty("当前页码")
    Integer pageNum = 1;

    @NotBlank
    @ApiModelProperty("页面容量")
    Integer pageSize = 10;
}
