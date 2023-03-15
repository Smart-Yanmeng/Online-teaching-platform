package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BChapterEntity;
import com.ruoyi.system.domain.entity.BClazzEntity;
import com.ruoyi.system.domain.view.ClazzDetailInfoView;
import com.ruoyi.system.domain.view.ClazzInfoView;
import com.ruoyi.system.domain.view.CoursewareInfoView;
import com.ruoyi.system.domain.view.TaskSubmitInfoView;
import com.ruoyi.system.domain.vo.clazz.ClazzCatalogueAddVo;
import com.ruoyi.system.domain.vo.clazz.ClazzCatalogueTaskAddVo;
import com.ruoyi.system.domain.vo.clazz.ClazzCatalogueUpdateVo;
import com.ruoyi.system.domain.vo.clazz.ClazzSearchVo;

import java.util.List;

public interface IClazzMapper {
    // 查询 clazz 数量
    Long countClazz();

    // 查询 chapter 数量
    Long countChapter();

    Long countCatalogue();

    List<ClazzInfoView> selectClazz();

    List<ClazzInfoView> queryClazzListByCondition(ClazzSearchVo clazzSearchVo);

    void insertClazzByCondition(BClazzEntity clazzEntity);

    ClazzInfoView queryClazzByCondition(Long clazzId);

    void updateClazzByCondition(BClazzEntity clazzEntity);

    void deleteClazzByCondition(Long clazzId);

    List<ClazzDetailInfoView> selectChapterByCondition(Long clazzId);

    List<String> selectCatalogueByCondition(Long chapterId);

    CoursewareInfoView selectCoursewareByCondition(Long catalogueId);

    void updateClazzCatalogueByCondition(ClazzCatalogueUpdateVo clazzCatalogueUpdateVo);

    void insertChapterByCondition(BChapterEntity chapterEntity);

    void insertCatalogueByCondition(ClazzCatalogueAddVo clazzCatalogueAddVo);

    void deleteChapterByCondition(Long chapterId);

    void deleteCatalogueByCondition(Long catalogueId);

    void insertTaskByCondition(ClazzCatalogueTaskAddVo clazzCatalogueTaskAddVo);

    List<TaskSubmitInfoView> selectTaskByCondition(Long catalogueId);
}
