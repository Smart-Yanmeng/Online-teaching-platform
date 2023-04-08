package com.ruoyi.system.domain.vo.online;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CoursewareInfoVo {
    @ApiModelProperty("目录名称")
    private String catalogueName;

    @ApiModelProperty("视频地址")
    private String playUrl;

    @ApiModelProperty("课件地址")
    private String coursewareUrl;

    @ApiModelProperty("排序")
    private Integer catalogueSort;

    @ApiModelProperty("是否是结课考核(0否，1是)")
    private Character last;
}
