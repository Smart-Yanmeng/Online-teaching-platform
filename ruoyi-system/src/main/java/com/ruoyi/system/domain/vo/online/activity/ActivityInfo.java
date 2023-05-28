package com.ruoyi.system.domain.vo.online.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityInfo {
    @ApiModelProperty("活动ID")
    private Long activityId;

    @ApiModelProperty("活动标题")
    private String activityTitle;

    @ApiModelProperty("活动简介")
    private String activityIntroduce;

    @ApiModelProperty("活动内容")
    private String activityContent;

    @ApiModelProperty("活动标记")
    private String activitySign;

    @ApiModelProperty("活动封面")
    private String coverUrl;

    @ApiModelProperty("是否发布")
    private Long isRelease;

    @ApiModelProperty("是否外链")
    private Character isLink;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("备注信息")
    private String remark;
}
