package com.ruoyi.system.domain.bo.banner;

import com.ruoyi.system.domain.dto.banner.BannerAddDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BannerAddBo extends BannerAddDto {
    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("删除标志")
    private Character delFlag;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("创建者")
    private String updateBy;
}
