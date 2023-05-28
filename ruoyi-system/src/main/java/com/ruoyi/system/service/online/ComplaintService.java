package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateBo;
import com.ruoyi.system.domain.po.BComplaintPo;
import com.ruoyi.system.domain.po.convert.ComplaintPOConvert;
import com.ruoyi.system.domain.vo.online.complaint.ComplaintInfo;
import com.ruoyi.system.mapper.online.IComplaintMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintService {
    @Resource
    IComplaintMapper complaintMapper;

    /**
     * 获取投诉列表
     *
     * @return List<ComplaintInfoVo>
     */
    public List<ComplaintInfo> selectComplaintList() {
        List<BComplaintPo> complaintPos = complaintMapper.selectComplaint();

        return complaintPos.stream().map(item -> new ComplaintPOConvert().convert(item)).collect(Collectors.toList());
    }

    /**
     * 投诉数量
     *
     * @return
     */
    public Long countUseComplaint() {
        return complaintMapper.countUseComplaint();
    }

    /**
     * 批量删除投诉
     *
     * @param complaintArr 投诉 ID 集合
     */
    public void patchComplaintAll(Long[] complaintArr) {
        for (Long item : complaintArr) {
            complaintMapper.patchComplaintByCondition(item);
        }
    }

    /**
     * 删除投诉
     *
     * @param complaintId 投诉 ID
     */
    public void deleteComplaint(Long complaintId) {
        complaintMapper.patchComplaintByCondition(complaintId);
    }

    /**
     * 修改备注
     *
     * @param complaintUpdateBo 备注信息
     */
    public void updateComplaint(ComplaintUpdateBo complaintUpdateBo) {
        complaintMapper.updateComplaint(complaintUpdateBo);
    }
}
