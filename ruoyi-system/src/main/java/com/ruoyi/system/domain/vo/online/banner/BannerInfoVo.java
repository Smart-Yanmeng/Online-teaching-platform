package com.ruoyi.system.domain.vo.online.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BannerInfoVo {
    @ApiModelProperty("轮播图信息")
    List<BannerInfo> bannerInfos;

    @ApiModelProperty("轮播图数量")
    Long bannerSum;
}
