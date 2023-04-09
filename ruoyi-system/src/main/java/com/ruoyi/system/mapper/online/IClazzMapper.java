package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.bo.clazz.ClazzCatalogueTaskAddBo;
import com.ruoyi.system.domain.bo.clazz.ClazzCatalogueUpdateBo;
import com.ruoyi.system.domain.po.BCataloguePo;
import com.ruoyi.system.domain.po.BChapterPo;
import com.ruoyi.system.domain.po.BClazzPo;
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

    void insertClazzByCondition(BClazzPo clazzPo);

    ClazzInfoVo queryClazzByCondition(Long clazzId);

    void updateClazzByCondition(BClazzPo clazzPo);

    void patchClazzByCondition(Long clazzId);

    List<ClazzDetailInfoVo> selectChapterByCondition(Long clazzId);

    List<String> selectCatalogueByCondition(Long chapterId);

    CoursewareInfoVo selectCoursewareByCondition(Long catalogueId);

    void updateClazzCatalogueByCondition(ClazzCatalogueUpdateBo clazzCatalogueUpdateBo);

    void insertChapterByCondition(BChapterPo chapterPo);

    void insertCatalogueByCondition(BCataloguePo cataloguePo);

    void deleteChapterByCondition(Long chapterId);

    void patchCatalogueByCondition(Long catalogueId);

    void insertTaskByCondition(ClazzCatalogueTaskAddBo clazzCatalogueTaskAddBo);

    List<TaskSubmitInfoVo> selectTaskByCondition(Long catalogueId);

    String selectTaskFileUrlByCondition(Long taskId);

    String selectTaskFileNameByCondition(Long taskId);

    List<CommentInfoVo> selectParentCommentByCondition(Long catalogueId);

    List<CommentInfoVo> selectChildrenCommentByCondition(Long commentId);

    void patchCommentByCondition(Long commentId);
}
