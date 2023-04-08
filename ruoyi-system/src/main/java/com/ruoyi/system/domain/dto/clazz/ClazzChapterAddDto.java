package com.ruoyi.system.domain.dto.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzChapterAddDto {
    @ApiModelProperty("章节名称")
    private String chapterName;

    @ApiModelProperty("排序")
    private Integer chapterSort;
}
