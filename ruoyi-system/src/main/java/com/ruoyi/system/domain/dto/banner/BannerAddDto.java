package com.ruoyi.system.domain.dto.banner;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BBannerPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerAddDto {
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
}
