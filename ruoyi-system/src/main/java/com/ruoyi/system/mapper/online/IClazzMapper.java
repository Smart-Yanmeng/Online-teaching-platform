package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.po.BCataloguePo;
import com.ruoyi.system.domain.po.BChapterPo;
import com.ruoyi.system.domain.po.BClazzPo;
import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueTaskAddDto;
import com.ruoyi.system.domain.dto.clazz.ClazzCatalogueUpdateDto;
import com.ruoyi.system.domain.bo.clazz.ClazzSearchBo;
import com.ruoyi.system.domain.vo.online.*;

import java.util.List;

public interface IClazzMapper {
    // 查询 clazz 数量
    Long countClazz();

    // 查询 chapter 数量
    Long countChapter();

    // 查询 catalogue 数量
    Long countCatalogue();

    // 查询是否有子评论
    Long countComment(Long commentId);

    List<ClazzInfoVo> selectClazz();

    List<ClazzInfoVo> queryClazzListByCondition(ClazzSearchBo clazzSearchBo);

    void insertClazzByCondition(BClazzPo clazzEntity);

    ClazzInfoVo queryClazzByCondition(Long clazzId);

    void updateClazzByCondition(BClazzPo clazzPo);

    void patchClazzByCondition(Long clazzId);

    List<ClazzDetailInfoVo> selectChapterByCondition(Long clazzId);

    List<String> selectCatalogueByCondition(Long chapterId);

    CoursewareInfoVo selectCoursewareByCondition(Long catalogueId);

    void updateClazzCatalogueByCondition(ClazzCatalogueUpdateDto clazzCatalogueUpdateDto);

    void insertChapterByCondition(BChapterPo chapterEntity);

    void insertCatalogueByCondition(BCataloguePo cataloguePo);

    void deleteChapterByCondition(Long chapterId);

    void patchCatalogueByCondition(Long catalogueId);

    void insertTaskByCondition(ClazzCatalogueTaskAddDto clazzCatalogueTaskAddDto);

    List<TaskSubmitInfoView> selectTaskByCondition(Long catalogueId);

    String selectTaskFileUrlByCondition(Long taskId);

    String selectTaskFileNameByCondition(Long taskId);

    List<CommentInfoView> selectParentCommentByCondition(Long catalogueId);

    List<CommentInfoView> selectChildrenCommentByCondition(Long commentId);

    void patchCommentByCondition(Long commentId);
}
