package com.ruoyi.system.domain.vo.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerUpdateVo {
    @ApiModelProperty("轮播图ID")
    private Long bannerId;

    @ApiModelProperty("轮播图标题")
    private String bannerTitle;

    @ApiModelProperty("轮播图地址")
    private String bannerUrl;

    @ApiModelProperty("链接地址")
    private String link;

    @ApiModelProperty("轮播图排序")
    private String bannerSort;

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Long isRelease;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;
}
