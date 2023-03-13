package com.ruoyi.system.domain.vo.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentSearchVo {
    @ApiModelProperty("学生姓名")
    private String nickName;

    @ApiModelProperty("账号")
    private String userName;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("学校")
    private String school;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("学习方向")
    private Character direction;
}
