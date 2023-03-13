package com.ruoyi.system.domain.view;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.entity.BEmploymentEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmploymentInfoView {
    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("公司")
    private String company;

    @ApiModelProperty("工资")
    private String salary;

    @ApiModelProperty("岗位")
    private String position;

    @ApiModelProperty("备注")
    private String remark;

    // entity -> view
    public EmploymentInfoView transfer(BEmploymentEntity employmentEntity) {
        BeanUtils.copyProperties(employmentEntity, this);

        return this;
    }
}
