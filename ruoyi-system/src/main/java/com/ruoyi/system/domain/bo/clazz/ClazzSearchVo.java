package com.ruoyi.system.domain.bo.clazz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzSearchVo {
    @ApiModelProperty("讲师姓名")
    private String teacherName;

    @ApiModelProperty("班主任姓名")
    private String headmasterName;

    @ApiModelProperty("班级名称")
    private String clazzName;

    @ApiModelProperty("开班日期")
    private String startTime;

    @ApiModelProperty("结课日期")
    private String finishTime;

    @ApiModelProperty("是否结课")
    private Character finish;
}
