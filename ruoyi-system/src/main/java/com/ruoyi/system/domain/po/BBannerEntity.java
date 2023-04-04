package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BBannerEntity {
    @ApiModelProperty("轮播图ID")
    private Long bannerId;
    @ApiModelProperty("轮播图标题")
    private String bannerTitle;

    @ApiModelProperty("轮播图地址")
    private String bannerUrl;

    @ApiModelProperty("排序")
    private String bannerSort;

    @ApiModelProperty("链接地址")
    private String link;

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Long isRelease;

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
