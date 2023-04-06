package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BStudentPo {
    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("最新班级ID")
    private Long clazzId;

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

    @ApiModelProperty("省份")
    private String prov;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("家庭住址")
    private String homeAddress;

    @ApiModelProperty("现住址")
    private String currentAddress;

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
