package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BCataloguePo {
    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("章节ID")
    private Long chapterId;

    @ApiModelProperty("目录名称")
    private String catalogueName;

    @ApiModelProperty("视频文件名")
    private String playName;

    @ApiModelProperty("视频地址")
    private String playUrl;

    @ApiModelProperty("播放数量")
    private Integer playNum;

    @ApiModelProperty("播放时长")
    private Integer playLength;

    @ApiModelProperty("课件文件名")
    private Character coursewareName;

    @ApiModelProperty("课件地址")
    private String coursewareUrl;

    @ApiModelProperty("作业")
    private String task;

    @ApiModelProperty("是否有作业(0没有，1有)")
    private Character hasTask;

    @ApiModelProperty("目录排序")
    private Integer catalogueSort;

    @ApiModelProperty("是否是结课考核(0否，1是)")
    private Character last;

    @ApiModelProperty("删除标志(0代表存在，2代表删除)")
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
