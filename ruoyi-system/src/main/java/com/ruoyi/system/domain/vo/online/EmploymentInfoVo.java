package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmploymentInfoVo {
    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("公司")
    private String company;

    @ApiModelProperty("工资")
    private String salary;

    @ApiModelProperty("岗位")
    private String position;

    @ApiModelProperty("备注")
    private String remark;
}
