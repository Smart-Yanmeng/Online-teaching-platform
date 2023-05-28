package com.ruoyi.system.domain.vo.online.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerInfo {
    @ApiModelProperty("轮播图ID")
    private Long bannerId;

    @ApiModelProperty("轮播图标题")
    private String bannerTitle;

    @ApiModelProperty("轮播图地址")
    private String bannerUrl;

    @ApiModelProperty("排序")
    private String bannerSort;

    @ApiModelProperty("跳转链接")
    private String link;

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Long isRelease;

    @ApiModelProperty("备注")
    private String remark;
}
