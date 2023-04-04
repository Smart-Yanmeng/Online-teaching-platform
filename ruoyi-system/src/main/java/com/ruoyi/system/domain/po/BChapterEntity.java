package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BChapterEntity {
    @ApiModelProperty("章节ID")
    private Long chapterId;

    @ApiModelProperty("班级ID")
    private Long clazzId;

    @ApiModelProperty("章节名称")
    private String chapterName;

    @ApiModelProperty("排序")
    private Integer chapterSort;

    @ApiModelProperty("删除标志(0代表存在，1代表删除)")
    private Character delFlag;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("备注")
    private String remark;
}
