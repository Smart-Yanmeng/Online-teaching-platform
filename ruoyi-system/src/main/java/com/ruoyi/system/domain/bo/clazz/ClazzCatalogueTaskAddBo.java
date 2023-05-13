package com.ruoyi.system.domain.bo.clazz;

import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueTaskAddDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClazzCatalogueTaskAddBo extends ClazzCatalogueTaskAddDto {
    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("是否有作业(0没有，1有)")
    private Character hasTask;
}
