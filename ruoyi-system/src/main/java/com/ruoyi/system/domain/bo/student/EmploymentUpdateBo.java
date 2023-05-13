package com.ruoyi.system.domain.bo.student;

import com.ruoyi.system.domain.dto.student.EmploymentUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmploymentUpdateBo extends EmploymentUpdateDto {
    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;
}
