package com.ruoyi.system.domain.bo.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmploymentAddVo {
    @ApiModelProperty("就业ID")
    private Long employmentId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;
}
