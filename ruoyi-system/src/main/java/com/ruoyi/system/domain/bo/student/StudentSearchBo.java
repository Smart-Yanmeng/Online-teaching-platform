package com.ruoyi.system.domain.bo.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentSearchBo {
    @ApiModelProperty("学生姓名")
    private String nickName;

    @ApiModelProperty("电话")
    private String phoneNumber;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("学校")
    private String school;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("学习方向")
    private Character direction;
}
