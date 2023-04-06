package com.ruoyi.system.domain.bo.student;

import com.ruoyi.system.domain.dto.student.StudentUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentUpdateBo extends StudentUpdateDto {
    @ApiModelProperty("班级 ID")
    private Long clazzId;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;
}
