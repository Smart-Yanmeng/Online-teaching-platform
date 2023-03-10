package com.ruoyi.system.domain.vo.activity;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.entity.BActivityEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityAddVo {
    @ApiModelProperty("活动标题")
    private String activityTitle;

    @ApiModelProperty("活动简介")
    private String activityIntroduce;

    @ApiModelProperty("活动内容")
    private String activityContent;

    @ApiModelProperty("活动标记")
    private String activitySign;

    @ApiModelProperty("活动封面")
    private String coverUrl;

    @ApiModelProperty("是否发布(0待发布，1发布)")
    private Long isRelease;

    @ApiModelProperty("是否外链(0否，1是)")
    private Character isLink;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("备注")
    private String remark;

    // vo -> entity
    public BActivityEntity transfer(BActivityEntity activityEntity) {
        BeanUtils.copyProperties(this, activityEntity);
        activityEntity.setCreateTime(DateUtils.getTime());
        activityEntity.setCreateBy("admin");
//        activityEntity.setCreateBy(SecurityUtils.getUsername());
        activityEntity.setDelFlag('0');
        activityEntity.setUpdateTime(DateUtils.getTime());
        activityEntity.setUpdateBy("admin");
//        activityEntity.setUpdateBy(SecurityUtils.getUsername());

        return activityEntity;
    }
}
