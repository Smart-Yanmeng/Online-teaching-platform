package com.ruoyi.system.domain.vo.banner;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.entity.BBannerEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BannerAddVo {
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

    // vo -> entity
    public BBannerEntity transfer(BBannerEntity bannerEntity) {
        BeanUtils.copyProperties(this, bannerEntity);
        bannerEntity.setCreateTime(DateUtils.getTime());
        bannerEntity.setCreateBy("admin");
//        bannerEntity.setCreateBy(SecurityUtils.getUsername());
        bannerEntity.setDelFlag('0');
        bannerEntity.setUpdateTime(DateUtils.getTime());
        bannerEntity.setUpdateBy("admin");
//        bannerEntity.setUpdateBy(SecurityUtils.getUsername());

        return bannerEntity;
    }
}
