package com.ruoyi.system.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BClazzEntity {
    @ApiModelProperty("班级ID")
    private Long clazzId;

    @ApiModelProperty("讲师ID")
    private Long teacherId;

    @ApiModelProperty("班主任ID")
    private Long headmasterId;

    @ApiModelProperty("班级名称")
    private String clazzName;

    @ApiModelProperty("班级封面")
    private String clazzCover;

    @ApiModelProperty("班级类型")
    private Character clazzType;

    @ApiModelProperty("开班日期")
    private String startTime;

    @ApiModelProperty("结课日期")
    private String finishTime;

    @ApiModelProperty("是否结课(0否，1是)")
    private Character finish;

    @ApiModelProperty("删除标志(0代表存在，2代表删除)")
    private Character delFlag;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("备注")
    private String remark;
}
