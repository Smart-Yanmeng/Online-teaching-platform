package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BStudentClazzEntity {
    @ApiModelProperty("学生ID")
    private Long userId;

    @ApiModelProperty("班级ID")
    private Long clazzId;

    @ApiModelProperty("状态(0在班，1移出)")
    private Character status;

    @ApiModelProperty("创建时间")
    private String createTime;
}
