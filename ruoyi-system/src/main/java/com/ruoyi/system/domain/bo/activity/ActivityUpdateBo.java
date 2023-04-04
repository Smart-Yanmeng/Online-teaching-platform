package com.ruoyi.system.domain.bo.activity;

import com.ruoyi.system.domain.dto.active.ActivityUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityUpdateBo extends ActivityUpdateDto {
    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("创建者")
    private String updateBy;
}
