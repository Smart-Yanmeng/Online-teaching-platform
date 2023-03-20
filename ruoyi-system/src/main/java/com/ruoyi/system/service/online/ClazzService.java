package com.ruoyi.system.service.online;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.entity.BChapterEntity;
import com.ruoyi.system.domain.entity.BClazzEntity;
import com.ruoyi.system.domain.view.*;
import com.ruoyi.system.domain.vo.clazz.*;
import com.ruoyi.system.mapper.online.IClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class ClazzService {
    @Resource
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

    /**
     * 刷新班级章节信息
     *
     * @param clazzId
     * @return
     */
    public List<ClazzDetailInfoView> selectChapterList(Long clazzId) {
        List<ClazzDetailInfoView> clazzDetailInfoViews = clazzMapper.selectChapterByCondition(clazzId);
        for (ClazzDetailInfoView item : clazzDetailInfoViews) {
            item.setCatalogueNameArr(clazzMapper.selectCatalogueByCondition(item.getChapterId()));
        }

        return clazzDetailInfoViews;
    }

    /**
     * 刷新目录信息
     *
     * @param catalogueId
     * @return
     */
    public CoursewareInfoView selectCourseware(Long catalogueId) {
        CoursewareInfoView coursewareInfoView = clazzMapper.selectCoursewareByCondition(catalogueId);

        return coursewareInfoView;
    }

    /**
     * 修改目录信息
     *
     * @param clazzCatalogueUpdateVo
     */
    public void updateClazzCatalogue(ClazzCatalogueUpdateVo clazzCatalogueUpdateVo) {
//        clazzCatalogueUpdateVo.setUpdateBy(SecurityUtils.getUsername());
        clazzCatalogueUpdateVo.setUpdateBy("admin");
        clazzCatalogueUpdateVo.setUpdateTime(DateUtils.getTime());

        clazzMapper.updateClazzCatalogueByCondition(clazzCatalogueUpdateVo);
    }

    /**
     * 插入章
     *
     * @param clazzChapterAddVo
     */
    public void insertChapter(ClazzChapterAddVo clazzChapterAddVo) {
        BChapterEntity chapterEntity = new BChapterEntity();
        chapterEntity = clazzChapterAddVo.transfer(chapterEntity);
        chapterEntity.setChapterId(clazzMapper.countChapter() + 1);

        clazzMapper.insertChapterByCondition(chapterEntity);
    }

    /**
     * 插入节
     *
     * @param clazzCatalogueAddVo
     */
    public void insertCatalogue(ClazzCatalogueAddVo clazzCatalogueAddVo) {
        clazzCatalogueAddVo.setCatalogueId(clazzMapper.countCatalogue() + 1);
        clazzCatalogueAddVo.setDelFlag('0');
//        clazzCatalogueAddVo.setCreateBy(SecurityUtils.getUsername());
        clazzCatalogueAddVo.setCreateBy("admin");
        clazzCatalogueAddVo.setCreateTime(DateUtils.getTime());
//        clazzCatalogueAddVo.setUpdateBy(SecurityUtils.getUsername());
        clazzCatalogueAddVo.setUpdateBy("admin");
        clazzCatalogueAddVo.setUpdateTime(DateUtils.getTime());

        clazzMapper.insertCatalogueByCondition(clazzCatalogueAddVo);
    }

    /**
     * 删除章
     *
     * @param chapterId
     */
    public void deleteChapter(Long chapterId) {
        clazzMapper.deleteChapterByCondition(chapterId);
    }

    /**
     * 删除节
     *
     * @param catalogueId
     */
    public void deleteCatalogue(Long catalogueId) {
        clazzMapper.deleteCatalogueByCondition(catalogueId);
    }

    /**
     * 发布作业
     *
     * @param clazzCatalogueTaskAddVo
     */
    public void insertTask(ClazzCatalogueTaskAddVo clazzCatalogueTaskAddVo) {
        clazzMapper.insertTaskByCondition(clazzCatalogueTaskAddVo);
    }


    /**
     * 刷新学生作业列表
     *
     * @param catalogueId
     * @return
     */
    public List<TaskSubmitInfoView> selectTaskList(Long catalogueId) {
        List<TaskSubmitInfoView> taskSubmitInfoViews = clazzMapper.selectTaskByCondition(catalogueId);

        return taskSubmitInfoViews;
    }

    /**
     * 下载学生作业
     *
     * @param taskId
     */
    public void downloadTask(Long taskId) {
        String saveDir = "C:\\Downloads\\";
        String fileUrl = clazzMapper.selectTaskFileUrlByCondition(taskId);
        String fileName = clazzMapper.selectTaskFileNameByCondition(taskId);

        try {
            URL url = new URL(fileUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            int responseCode = httpConn.getResponseCode();

            // 检查是否连接成功
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 打开输入输出流
                InputStream inputStream = httpConn.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(saveDir + fileName);

                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();

                System.out.println("File download successfully!");
            } else {
                System.out.println("File download failed, Server replied HTTP code: " + responseCode);
            }
            httpConn.disconnect();
        } catch (Exception e) {
            System.out.println("Error while downloading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 查询评论信息
     *
     * @param catalogueId
     * @return
     */
    public List<CommentInfoView> selectComment(Long catalogueId) {
        // 原始评论
        List<CommentInfoView> commentInfoViews = clazzMapper.selectParentCommentByCondition(catalogueId);
        // 添加子评论
        addChildren(commentInfoViews);

        return commentInfoViews;
    }

    public void addChildren(List<CommentInfoView> parentComment) {
        for (CommentInfoView item : parentComment) {
            Long parentCommentId = item.getCommentId();
            if (clazzMapper.countComment(parentCommentId) == 0) break;
            else {
                List<CommentInfoView> childrenComment = clazzMapper.selectChildrenCommentByCondition(parentCommentId);

                item.setChildren(childrenComment);
            }
        }
    }

    /**
     * 删除评论
     *
     * @param commentId
     */
    public void deleteComment(Long commentId) {
        clazzMapper.deleteCommentByCondition(commentId);
    }
}
