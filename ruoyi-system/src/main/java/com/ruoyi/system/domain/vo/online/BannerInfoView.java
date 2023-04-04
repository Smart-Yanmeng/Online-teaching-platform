package com.ruoyi.system.domain.vo.online;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BBannerEntity;
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

    // entity -> view
    public BannerInfoView transfer(BBannerEntity bannerEntity) {
        BeanUtils.copyProperties(bannerEntity, this);

        return this;
    }
}
