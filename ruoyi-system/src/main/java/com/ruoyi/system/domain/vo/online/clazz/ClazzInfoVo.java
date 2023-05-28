package com.ruoyi.system.domain.vo.online.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClazzInfoVo {
    @ApiModelProperty("班级信息")
    List<ClazzInfo> clazzInfos;

    @ApiModelProperty("班级数量")
    Long clazzUseSum;
}
