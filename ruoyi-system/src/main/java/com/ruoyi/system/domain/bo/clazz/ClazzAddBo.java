package com.ruoyi.system.domain.bo.clazz;

import com.ruoyi.system.domain.dto.clazz.ClazzAddDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClazzAddBo extends ClazzAddDto {
    @ApiModelProperty("班级 ID")
    private Long clazzId;

    @ApiModelProperty("删除标志")
    private Character delFlag;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新时间")
    private String UpdateTime;

    @ApiModelProperty("更新者")
    private String UpdateBy;
}
