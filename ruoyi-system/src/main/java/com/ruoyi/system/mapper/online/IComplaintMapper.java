package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.view.ComplaintInfoView;
import com.ruoyi.system.domain.vo.complaint.ComplaintUpdateVo;

import java.util.List;

public interface IComplaintMapper {
    List<ComplaintInfoView> selectComplaint();

    void patchComplaintByCondition(Long complaintId);

    void updateComplaint(ComplaintUpdateVo complaintUpdateVo);
}
