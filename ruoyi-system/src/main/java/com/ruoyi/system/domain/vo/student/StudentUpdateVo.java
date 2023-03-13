package com.ruoyi.system.domain.vo.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentUpdateVo {
    @NotBlank
    @ApiModelProperty("学生ID")
    private Long userId;

    @NotBlank
    @ApiModelProperty("账号")
    private String userName;

    @NotBlank
    @ApiModelProperty("密码")
    private String password;

    @NotBlank
    @ApiModelProperty("学生姓名")
    private String nickName;

    @NotBlank
    @ApiModelProperty("手机号码")
    private String phonenumber;

    @NotBlank
    @ApiModelProperty("邮箱")
    private String email;

    @NotBlank
    @ApiModelProperty("性别(0男，1女，2未知)")
    private Character sex;

    @NotBlank
    @ApiModelProperty("出生年月日")
    private String birthday;

    @NotBlank
    @ApiModelProperty("年级")
    private String grade;

    @NotBlank
    @ApiModelProperty("学校")
    private String school;

    @NotBlank
    @ApiModelProperty("专业")
    private String major;

    @NotBlank
    @ApiModelProperty("班级")
    private String clazzName;

    @NotBlank
    @ApiModelProperty("学习方向")
    private Character direction;

    @NotBlank
    @ApiModelProperty("是否结课(0否，1是)")
    private Character graduation;

    @NotBlank
    @ApiModelProperty("是否已经参加工作(0否，1是)")
    private Character worked;

    @ApiModelProperty("备注信息")
    private String remark;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;
}
