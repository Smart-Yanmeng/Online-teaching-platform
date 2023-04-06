package com.ruoyi.system.domain.dto.sharing;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SharingUpdateDto {
    @NotBlank
    @ApiModelProperty("知识分享活动标题")
    private String activityTitle;

    @NotBlank
    @ApiModelProperty("知识分享活动副标题")
    private String sharingSubtitle;

    @NotBlank
    @ApiModelProperty("知识分享活动简介")
    private String sharingIntroduce;

    @ApiModelProperty("知识分享活动内容")
    private String sharingContent;

    @ApiModelProperty("知识分享活动标记")
    private String sharingSign;

    @ApiModelProperty("知识分享活动封面")
    private String coverUrl;

    @ApiModelProperty("邀请嘉宾")
    private String honouredGuest;

    @NotBlank
    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Character isRelease;

    @NotBlank
    @ApiModelProperty("是否外链(0否，1是)")
    private Character isLink;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("备注")
    private String remark;
}
