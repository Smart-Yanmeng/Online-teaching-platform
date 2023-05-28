package com.ruoyi.system.domain.vo.online.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentInfoVo {
    @ApiModelProperty("学生信息")
    private List<StudentInfo> studentInfos;

    @ApiModelProperty("学生数量")
    private Long studentUseSum;
}
