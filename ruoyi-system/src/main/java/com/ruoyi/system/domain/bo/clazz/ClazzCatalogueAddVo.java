package com.ruoyi.system.domain.bo.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzCatalogueAddVo {
    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("章节ID")
    private Long chapterId;

    @ApiModelProperty("目录名称")
    private String catalogueName;

    @ApiModelProperty("排序")
    private Integer catalogueSort;

    @ApiModelProperty("删除标志(0代表存在，2代表删除)")
    private Character delFlag;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("更新着")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;
}
