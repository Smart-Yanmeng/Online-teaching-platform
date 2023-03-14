package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.entity.BClazzEntity;
import com.ruoyi.system.domain.view.ClazzDetailInfoView;
import com.ruoyi.system.domain.view.ClazzInfoView;
import com.ruoyi.system.domain.vo.clazz.ClazzSearchVo;

import java.util.List;

public interface IClazzMapper {
    // 查询 clazz 数量
    Long countClazz();

    List<ClazzInfoView> selectClazz();

    List<ClazzInfoView> queryClazzListByCondition(ClazzSearchVo clazzSearchVo);

    void insertClazzByCondition(BClazzEntity clazzEntity);

    ClazzInfoView queryClazzByCondition(Long clazzId);

    void updateClazzByCondition(BClazzEntity clazzEntity);

    void deleteClazzByCondition(Long clazzId);

    List<ClazzDetailInfoView> selectChapterByCondition(Long clazzId);

    List<String> selectCatalogueByCondition(Long chapterId);
}
