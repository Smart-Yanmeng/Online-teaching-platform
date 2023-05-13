package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzInfoVo {
    @ApiModelProperty("班级 ID")
    private Long clazzId;

    @ApiModelProperty("班级封面")
    private String clazzCover;

    @ApiModelProperty("讲师姓名")
    private String teacherName;

    @ApiModelProperty("班主任姓名")
    private String headmasterName;

    @ApiModelProperty("班级名称")
    private String clazzName;

    @ApiModelProperty("班级类型")
    private Character clazzType;

    @ApiModelProperty("开班日期")
    private String startTime;

    @ApiModelProperty("结课日期")
    private String finishTime;

    @ApiModelProperty("是否结课(0否，1是)")
    private Character finish;

    @ApiModelProperty("备注信息")
    private String remark;
}
