package com.ruoyi.system.domain.vo.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmploymentUpdateVo {
    @ApiModelProperty("用户ID")
    private Long userId;

    @NotBlank
    @ApiModelProperty("城市")
    private String city;

    @NotBlank
    @ApiModelProperty("公司")
    private String company;

    @NotBlank
    @ApiModelProperty("工资")
    private String salary;

    @NotBlank
    @ApiModelProperty("岗位")
    private String position;

    private String updateBy;

    private String updateTime;

    @ApiModelProperty("备注")
    private String remark;
}
