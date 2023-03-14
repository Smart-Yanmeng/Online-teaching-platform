package com.ruoyi.system.domain.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClazzDetailInfoView {
    @ApiModelProperty("章节ID")
    private Long chapterId;

    @ApiModelProperty("章节名称")
    private String chapterName;

    @ApiModelProperty("目录名称列表")
    private List<String> catalogueNameArr;
}
