package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.bo.convert.ClazzAddBOCovert;
import com.ruoyi.system.domain.bo.convert.ClazzCatalogueAddBOConvert;
import com.ruoyi.system.domain.bo.convert.ClazzChapterAddBOConvert;
import com.ruoyi.system.domain.bo.convert.ClazzUpdateBOConvert;
import com.ruoyi.system.domain.po.BCataloguePo;
import com.ruoyi.system.domain.po.BChapterPo;
import com.ruoyi.system.domain.po.BClazzPo;
import com.ruoyi.system.domain.bo.clazz.*;
import com.ruoyi.system.domain.vo.online.clazz.*;
import com.ruoyi.system.mapper.online.IClazzMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClazzService {
    @Resource
    IClazzMapper clazzMapper;

    /**
     * 刷新 - 重置班级信息
     *
     * @return List<ClazzInfoVo>
     */
    public List<ClazzInfo> selectClazzList() {
        return clazzMapper.selectClazz();
    }

    /**
     * 查询班级列表
     *
     * @param clazzSearchBo 班级查询条件
     * @return List<ClazzInfoVo>
     */
    public List<ClazzInfo> queryClazzList(ClazzSearchBo clazzSearchBo) {
        return clazzMapper.queryClazzListByCondition(clazzSearchBo);
    }

    public Long countUseClazz(ClazzSearchBo clazzSearchBo) {
        return clazzMapper.countUseClazz(clazzSearchBo);
    }

    /**
     * 插入班级
     *
     * @param clazzAddBo 班级插入数据
     */
    public void insertClazz(ClazzAddBo clazzAddBo) {
        clazzAddBo.setClazzId(clazzMapper.countClazz() + 1);
        BClazzPo clazzPo = new ClazzAddBOCovert().convert(clazzAddBo);

        clazzMapper.insertClazzByCondition(clazzPo);
    }

    /**
     * 修改班级
     *
     * @param clazzUpdateBo 修改班级数据
     */
    public void updateClazz(ClazzUpdateBo clazzUpdateBo) {
        BClazzPo clazzPo = new ClazzUpdateBOConvert().convert(clazzUpdateBo);

        clazzMapper.updateClazzByCondition(clazzPo);
    }

    /**
     * 删除班级
     *
     * @param clazzId 班级 ID
     */
    public void patchClazz(Long clazzId) {
        clazzMapper.patchClazzByCondition(clazzId);
    }

    /**
     * 批量删除班级
     *
     * @param clazzIdArr 班级 ID 集合
     */
    public void patchClazzAll(Long[] clazzIdArr) {
        for (Long item : clazzIdArr) {
            clazzMapper.patchClazzByCondition(item);
        }
    }

    /**
     * 获取班级章节信息
     *
     * @param clazzId 班级 ID
     * @return List<ClazzDetailInfoVo>
     */
    public List<ClazzDetailInfoVo> selectChapterList(Long clazzId) {
        List<ClazzDetailInfoVo> clazzDetailInfoVos = clazzMapper.selectChapterByCondition(clazzId);
        for (ClazzDetailInfoVo item : clazzDetailInfoVos) {
            item.setCatalogueNameArr(clazzMapper.selectCatalogueByCondition(item.getChapterId()));
        }

        return clazzDetailInfoVos;
    }

    /**
     * 刷新目录信息
     *
     * @param catalogueId 目录 ID
     * @return CoursewareInfoVo
     */
    public CoursewareInfoVo selectCourseware(Long catalogueId) {
        return clazzMapper.selectCoursewareByCondition(catalogueId);
    }

    /**
     * 修改目录信息
     *
     * @param clazzCatalogueUpdateBo 目录修改条件
     */
    public void updateClazzCatalogue(ClazzCatalogueUpdateBo clazzCatalogueUpdateBo) {
        clazzMapper.updateClazzCatalogueByCondition(clazzCatalogueUpdateBo);
    }

    /**
     * 插入章
     *
     * @param clazzChapterAddBo 插入章数据
     */
    public void insertChapter(ClazzChapterAddBo clazzChapterAddBo) {
        clazzChapterAddBo.setChapterId(clazzMapper.countChapter() + 1);
        BChapterPo chapterPo = new ClazzChapterAddBOConvert().convert(clazzChapterAddBo);

        clazzMapper.insertChapterByCondition(chapterPo);
    }

    /**
     * 插入节
     *
     * @param clazzCatalogueAddBo 插入节数据
     */
    public void insertCatalogue(ClazzCatalogueAddBo clazzCatalogueAddBo) {
        clazzCatalogueAddBo.setCatalogueId(clazzMapper.countCatalogue() + 1);
        BCataloguePo cataloguePo = new ClazzCatalogueAddBOConvert().convert(clazzCatalogueAddBo);

        clazzMapper.insertCatalogueByCondition(cataloguePo);
    }

    /**
     * 删除章
     *
     * @param chapterId 章节 ID
     */
    public void deleteChapter(Long chapterId) {
        clazzMapper.deleteChapterByCondition(chapterId);
    }

    /**
     * 删除节
     *
     * @param catalogueId 目录 ID
     */
    public void patchCatalogue(Long catalogueId) {
        clazzMapper.patchCatalogueByCondition(catalogueId);
    }

    /**
     * 发布作业
     *
     * @param clazzCatalogueTaskAddBo 作业发布数据
     */
    public void insertTask(ClazzCatalogueTaskAddBo clazzCatalogueTaskAddBo) {
        clazzMapper.insertTaskByCondition(clazzCatalogueTaskAddBo);
    }

    /**
     * 刷新学生作业列表
     *
     * @param catalogueId 目录 ID
     * @return List<TaskSubmitInfoView>
     */
    public List<TaskSubmitInfoVo> selectTaskList(Long catalogueId) {
        return clazzMapper.selectTaskByCondition(catalogueId);
    }

    /**
     * 查询评论信息
     *
     * @param catalogueId 目录 ID
     * @return List<CommentInfoVo>
     */
    public List<CommentInfoVo> selectComment(Long catalogueId) {
        // 原始评论
        List<CommentInfoVo> commentInfoVos = clazzMapper.selectParentCommentByCondition(catalogueId);
        // 添加子评论
        addChildren(commentInfoVos);

        return commentInfoVos;
    }

    // 添加子评论实现
    public void addChildren(List<CommentInfoVo> parentComment) {
        for (CommentInfoVo item : parentComment) {
            Long parentCommentId = item.getCommentId();
            if (clazzMapper.countComment(parentCommentId) == 0) break;
            else {
                List<CommentInfoVo> childrenComment = clazzMapper.selectChildrenCommentByCondition(parentCommentId);

                item.setChildren(childrenComment);
            }
        }
    }

    /**
     * 删除评论
     *
     * @param commentId 评论 ID
     */
    public void patchComment(Long commentId) {
        clazzMapper.patchCommentByCondition(commentId);
    }
}
