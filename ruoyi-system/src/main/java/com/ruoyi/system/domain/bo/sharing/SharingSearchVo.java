package com.ruoyi.system.domain.bo.sharing;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SharingSearchVo {
    @ApiModelProperty("标题")
    private String sharingTitle;

    @ApiModelProperty("副标题")
    private String sharingSubtitle;

    @ApiModelProperty("邀请嘉宾")
    private String honouredGuest;

    @ApiModelProperty("发布状态")
    private Character isRelease;

    @ApiModelProperty("是否外链")
    private Character isLink;
}
