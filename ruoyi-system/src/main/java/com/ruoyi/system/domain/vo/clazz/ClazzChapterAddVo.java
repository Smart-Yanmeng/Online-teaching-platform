package com.ruoyi.system.domain.vo.clazz;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.entity.BChapterEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClazzChapterAddVo {
    @ApiModelProperty("班级ID")
    private Long clazzId;

    @ApiModelProperty("章节名称")
    private String chapterName;

    @ApiModelProperty("排序")
    private Integer chapterSort;

    public BChapterEntity transfer(BChapterEntity chapterEntity) {
        BeanUtils.copyProperties(this, chapterEntity);
        chapterEntity.setDelFlag('0');
//        chapterEntity.setCreateBy(SecurityUtils.getUsername());
        chapterEntity.setCreateBy("admin");
        chapterEntity.setCreateTime(DateUtils.getTime());
//        chapterEntity.setUpdateBy(SecurityUtils.getUsername());
        chapterEntity.setUpdateBy("admin");
        chapterEntity.setUpdateTime(DateUtils.getTime());

        return chapterEntity;
    }
}
