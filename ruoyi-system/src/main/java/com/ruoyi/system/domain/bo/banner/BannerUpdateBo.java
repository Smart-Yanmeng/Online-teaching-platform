package com.ruoyi.system.domain.bo.banner;

import com.ruoyi.system.domain.dto.banner.BannerUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BannerUpdateBo extends BannerUpdateDto {
    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;
}
