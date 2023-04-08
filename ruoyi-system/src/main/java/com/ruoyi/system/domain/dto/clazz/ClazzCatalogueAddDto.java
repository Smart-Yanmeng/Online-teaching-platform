package com.ruoyi.system.domain.dto.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzCatalogueAddDto {
    @ApiModelProperty("目录名称")
    private String catalogueName;

    @ApiModelProperty("排序")
    private Integer catalogueSort;
}
