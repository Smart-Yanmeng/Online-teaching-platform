package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BTaskSubmitEntity {
    @ApiModelProperty("作业提交ID")
    private Long taskId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("文件地址")
    private String fileUrl;

    @ApiModelProperty("点评用户ID")
    private Long teacherUserId;

    @ApiModelProperty("点评内容")
    private String comment;

    @ApiModelProperty("是否通过(0不通过，1通过，2待批改)")
    private Character pass;

    @ApiModelProperty("删除标志(0代表存在，2代表删除)")
    private Character delFlag;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("备注")
    private String remark;
}
