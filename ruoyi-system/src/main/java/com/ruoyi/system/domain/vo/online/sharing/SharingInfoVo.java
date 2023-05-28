package com.ruoyi.system.domain.vo.online.sharing;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SharingInfoVo {
    @ApiModelProperty("分享信息")
    private List<SharingInfo> sharingInfos;

    @ApiModelProperty("分享数量")
    private Long sharingUseSum;
}
