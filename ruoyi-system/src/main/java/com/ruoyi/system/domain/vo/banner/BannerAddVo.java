package com.ruoyi.system.domain.vo.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerAddVo {
    @ApiModelProperty("轮播图标题")
    private String bannerTitle;

    @ApiModelProperty("发布状态(0待发布，1发布)")
    private Long isRelease;

}
