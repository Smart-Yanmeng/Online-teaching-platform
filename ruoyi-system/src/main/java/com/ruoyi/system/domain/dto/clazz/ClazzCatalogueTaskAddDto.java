package com.ruoyi.system.domain.dto.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzCatalogueTaskAddDto {
    @ApiModelProperty("作业")
    private String task;
}
