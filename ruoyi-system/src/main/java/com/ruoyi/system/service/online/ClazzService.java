package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.entity.BClazzEntity;
import com.ruoyi.system.domain.view.ClazzDetailInfoView;
import com.ruoyi.system.domain.view.ClazzInfoView;
import com.ruoyi.system.domain.vo.clazz.ClazzAddVo;
import com.ruoyi.system.domain.vo.clazz.ClazzSearchVo;
import com.ruoyi.system.domain.vo.clazz.ClazzUpdateVo;
import com.ruoyi.system.mapper.online.IClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService {
    @Autowired
    IClazzMapper clazzMapper;

    /**
     * 刷新 - 重置班级信息
     *
     * @return
     */
    public List<ClazzInfoView> selectClazzList() {
        List<ClazzInfoView> clazzInfoViews = clazzMapper.selectClazz();

        return clazzInfoViews;
    }

    /**
     * 查询班级列表
     *
     * @param clazzSearchVo
     * @return
     */
    public List<ClazzInfoView> queryClazzList(ClazzSearchVo clazzSearchVo) {
        List<ClazzInfoView> clazzInfoViews = clazzMapper.queryClazzListByCondition(clazzSearchVo);

        return clazzInfoViews;
    }

    /**
     * 插入班级
     *
     * @param clazzAddVo
     */
    public void insertClazz(ClazzAddVo clazzAddVo) {
        BClazzEntity clazzEntity = new BClazzEntity();
        clazzAddVo.transfer(clazzEntity);
        clazzEntity.setClazzId(clazzMapper.countClazz() + 1);

        clazzMapper.insertClazzByCondition(clazzEntity);
    }

    /**
     * 查询班级
     *
     * @param clazzId
     * @return
     */
    public ClazzInfoView queryClazz(Long clazzId) {
        ClazzInfoView clazzInfoView = clazzMapper.queryClazzByCondition(clazzId);

        return clazzInfoView;
    }

    /**
     * 修改班级
     *
     * @param clazzUpdateVo
     */
    public void updateClazz(ClazzUpdateVo clazzUpdateVo) {
        BClazzEntity clazzEntity = new BClazzEntity();
        clazzEntity = clazzUpdateVo.transfer(clazzEntity);
//        clazzEntity.setUpdateBy(SecurityUtils.getUsername());
        clazzEntity.setUpdateBy("admin");
        clazzEntity.setUpdateTime(DateUtils.getTime());

        clazzMapper.updateClazzByCondition(clazzEntity);
    }

    /**
     * 删除班级
     *
     * @param clazzId
     */
    public void deleteClazz(Long clazzId) {
        clazzMapper.deleteClazzByCondition(clazzId);
    }

    /**
     * 批量删除班级
     *
     * @param clazzIdArr
     */
    public void deleteClazzAll(Long[] clazzIdArr) {
        for (Long item : clazzIdArr) {
            clazzMapper.deleteClazzByCondition(item);
        }
    }

    public List<ClazzDetailInfoView> selectChapterList(Long clazzId) {
        List<ClazzDetailInfoView> clazzDetailInfoViews = clazzMapper.selectChapterByCondition(clazzId);
        for (ClazzDetailInfoView item : clazzDetailInfoViews) {
            item.setCatalogueNameArr(clazzMapper.selectCatalogueByCondition(item.getChapterId()));
        }

        return clazzDetailInfoViews;
    }
}
