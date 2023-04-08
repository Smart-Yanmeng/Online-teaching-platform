package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BEmploymentInfoPo {
    @ApiModelProperty("就业ID")
    private Long employmentId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("公司")
    private String company;

    @ApiModelProperty("工资")
    private String salary;

    @ApiModelProperty("岗位")
    private String position;

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
