package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.vo.online.ComplaintInfoView;
import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateVo;
import com.ruoyi.system.mapper.online.IComplaintMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComplaintService {
    @Resource
    IComplaintMapper complaintMapper;

    public List<ComplaintInfoView> selectComplaintList() {
        List<ComplaintInfoView> complaintInfoViews = complaintMapper.selectComplaint();

        return complaintInfoViews;
    }

    public void patchComplaintAll(Long[] complaintArr) {
        for (Long item : complaintArr) {
            complaintMapper.patchComplaintByCondition(item);
        }
    }

    public void deleteComplaint(Long complaintId) {
        complaintMapper.patchComplaintByCondition(complaintId);
    }

    public void updateComplaint(ComplaintUpdateVo complaintUpdateVo) {
        complaintMapper.updateComplaint(complaintUpdateVo);
    }
}
