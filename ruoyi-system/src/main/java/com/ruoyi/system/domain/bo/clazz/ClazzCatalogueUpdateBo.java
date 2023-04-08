package com.ruoyi.system.domain.bo.clazz;

import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClazzCatalogueUpdateBo extends ClazzCatalogueUpdateDto {
    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;
}
