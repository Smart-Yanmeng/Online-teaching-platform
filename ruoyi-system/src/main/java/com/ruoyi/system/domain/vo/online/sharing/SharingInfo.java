package com.ruoyi.system.domain.vo.online.sharing;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SharingInfo {
    @ApiModelProperty("知识分享ID")
    private Long sharingId;

    @ApiModelProperty("知识分享标题")
    private String sharingTitle;

    @ApiModelProperty("知识分享活动副标题")
    private String sharingSubtitle;

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

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Character isRelease;

    @ApiModelProperty("是否外链(0否，1是)")
    private Character isLink;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("备注")
    private String remark;
}
