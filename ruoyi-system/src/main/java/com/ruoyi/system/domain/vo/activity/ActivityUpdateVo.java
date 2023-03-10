package com.ruoyi.system.domain.vo.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityUpdateVo {
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

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Long isRelease;

    @ApiModelProperty("是否外链(0否，1是)")
    private Character isLink;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("备注")
    private String remark;
}
