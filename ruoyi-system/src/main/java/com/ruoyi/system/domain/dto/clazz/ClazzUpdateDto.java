package com.ruoyi.system.domain.dto.clazz;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.po.BClazzPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClazzUpdateDto {
    @ApiModelProperty("班级封面")
    private String clazzCover;

    @NotBlank
    @ApiModelProperty("讲师ID")
    private Long teacherId;

    @NotBlank
    @ApiModelProperty("班主任ID")
    private Long headmasterId;

    @NotBlank
    @ApiModelProperty("班级名称")
    private String clazzName;

    @NotBlank
    @ApiModelProperty("班级类型")
    private Character clazzType;

    @NotBlank
    @ApiModelProperty("开班日期")
    private String startTime;

    @ApiModelProperty("结课日期")
    private String finishTime;

    @NotBlank
    @ApiModelProperty("是否结课(0否，1是)")
    private Character finish;

    @ApiModelProperty("备注")
    private String remark;
}
