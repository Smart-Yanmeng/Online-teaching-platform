package com.ruoyi.system.domain.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CommentInfoView {
    @ApiModelProperty("评论ID")
    private Long commentId;

    @ApiModelProperty("账号")
    private String userName;

    @ApiModelProperty("姓名")
    private String nickName;

    @ApiModelProperty("评论内容")
    private String commentContent;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("子评论")
    private List<CommentInfoView> children;
}
