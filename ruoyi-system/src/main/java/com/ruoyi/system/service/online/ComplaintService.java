package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.view.ComplaintInfoView;
import com.ruoyi.system.domain.vo.complaint.ComplaintUpdateVo;
import com.ruoyi.system.mapper.online.IComplaintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    IComplaintMapper complaintMapper;

    public List<ComplaintInfoView> selectComplaintList() {
        List<ComplaintInfoView> complaintInfoViews = complaintMapper.selectComplaint();

        return complaintInfoViews;
    }

    public void deleteComplaint(Long complaintId) {
        complaintMapper.deleteComplaintByCondition(complaintId);
    }

    public void updateComplaint(ComplaintUpdateVo complaintUpdateVo) {
        complaintMapper.updateComplaint(complaintUpdateVo);
    }
}
