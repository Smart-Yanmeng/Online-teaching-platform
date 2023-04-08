package com.ruoyi.system.domain.bo.clazz;

import com.ruoyi.system.domain.dto.clazz.ClazzUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClazzUpdateBo extends ClazzUpdateDto {
    @ApiModelProperty("班级ID")
    private Long clazzId;

    @ApiModelProperty("删除标志")
    private Character delFlag;

    @ApiModelProperty("更新时间")
    private String UpdateTime;

    @ApiModelProperty("更新者")
    private String UpdateBy;
}
