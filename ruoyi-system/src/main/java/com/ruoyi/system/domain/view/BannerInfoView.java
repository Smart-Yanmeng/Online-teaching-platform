package com.ruoyi.system.domain.view;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.entity.BBannerEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerInfoView {
    @ApiModelProperty("轮播图标题")
    private String bannerTitle;

    @ApiModelProperty("轮播图地址")
    private String bannerUrl;

    @ApiModelProperty("排序")
    private String bannerSort;

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Long isRelease;

    @ApiModelProperty("备注")
    private String remark;

    public BannerInfoView transfer(BBannerEntity entity) {
        BeanUtils.copyProperties(entity, this);

        return this;
    }
}
