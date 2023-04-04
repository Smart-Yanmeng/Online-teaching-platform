package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class    StudentInfoView {
    @ApiModelProperty("学生姓名")
    private String nickName;

    @ApiModelProperty("账号")
    private String userName;

    @ApiModelProperty("班级")
    private String clazzName;

    @ApiModelProperty("出生年月日")
    private String birthday;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("学校")
    private String school;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("学习方向")
    private Character direction;

    @ApiModelProperty("是否结课(0否，1是)")
    private Character graduation;

    @ApiModelProperty("是否已经参加工作(0否，1是)")
    private Character worked;

    @ApiModelProperty("备注信息")
    private String remark;
}
