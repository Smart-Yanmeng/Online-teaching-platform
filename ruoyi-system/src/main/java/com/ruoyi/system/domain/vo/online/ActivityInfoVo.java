package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ActivityInfoVo {
    @ApiModelProperty("活动信息")
    List<ActivityInfo> activityInfos;

    @ApiModelProperty("活动数量")
    Long activitySum;
}
