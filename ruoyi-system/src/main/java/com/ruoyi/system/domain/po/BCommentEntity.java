package com.ruoyi.system.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BCommentEntity {
    @ApiModelProperty("评论ID")
    private Long commentId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("目录ID")
    private Long catalogueId;

    @ApiModelProperty("原始评论ID，一样的原始评论ID代表一个原生评论衍生出来的信息")
    private Long ancestryId;

    @ApiModelProperty("父评论ID")
    private Long parentId;

    @ApiModelProperty("评论内容")
    private Integer commentContent;

    @ApiModelProperty("删除标志(0代表存在，2代表删除)")
    private Integer delFlag;

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
