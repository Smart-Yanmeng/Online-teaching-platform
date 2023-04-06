package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BUserPo {
    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("部门ID")
    private Long deptId;

    @ApiModelProperty("用户账号")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户类型(00系统用户)")
    private String userType;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String phonenumber;

    @ApiModelProperty("用户性别(0男，1女，2未知)")
    private Character sex;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("帐号状态(0正常，1停用)")
    private Character status;

    @ApiModelProperty("删除标注(0代表存在，2代表删除)")
    private Character delFlag;

    @ApiModelProperty("最后登录IP")
    private String loginIp;

    @ApiModelProperty("最后登录时间")
    private String loginDate;

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
