package com.ruoyi.system.domain.bo.sharing;

import com.ruoyi.system.domain.dto.sharing.SharingUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SharingUpdateBo extends SharingUpdateDto {
    @ApiModelProperty("分享 ID")
    private Long sharingId;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;
}
