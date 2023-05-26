package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BannerInfoVo {
    @ApiModelProperty("轮播图信息")
    List<BannerInfo> list;

    @ApiModelProperty("轮播图数量")
    Long bannerSum;
}
