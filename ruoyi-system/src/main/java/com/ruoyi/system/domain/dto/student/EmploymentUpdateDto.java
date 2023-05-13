package com.ruoyi.system.domain.dto.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmploymentUpdateDto {
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

    @ApiModelProperty("备注")
    private String remark;
}
