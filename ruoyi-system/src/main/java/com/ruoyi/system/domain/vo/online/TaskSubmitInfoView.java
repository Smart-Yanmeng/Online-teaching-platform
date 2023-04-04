package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TaskSubmitInfoView {
    @ApiModelProperty("学生姓名")
    private String nickName;

    @ApiModelProperty("作业名称")
    private String fileName;

    @ApiModelProperty("是否通过(0不通过，1通过，2待批改)")
    private Character pass;

    @ApiModelProperty("点评内容")
    private String comment;
}
