package com.ruoyi.system.domain.vo.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzCatalogueTaskAddVo {
    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("作业")
    private String task;

    @ApiModelProperty("是否有作业(0没有，1有)")
    private Character hasTask;
}
