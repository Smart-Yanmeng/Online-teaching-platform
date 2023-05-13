package com.ruoyi.system.domain.bo.student;

import com.ruoyi.system.domain.dto.student.StudentAddDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentAddBo extends StudentAddDto {
    @ApiModelProperty("用户 ID")
    private Long userId;

    @ApiModelProperty("班级 ID")
    private Long clazzId;

    @ApiModelProperty("部门 ID")
    private String employmentId;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("状态")
    private Character status;

    @ApiModelProperty("删除标志")
    private Character delFlag;
}
