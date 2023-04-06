package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateBo;
import com.ruoyi.system.domain.po.BComplaintPo;
import com.ruoyi.system.domain.dto.complaint.ComplaintUpdateDto;

import java.util.List;

public interface IComplaintMapper {
    List<BComplaintPo> selectComplaint();

    void patchComplaintByCondition(Long complaintId);

    void updateComplaint(ComplaintUpdateBo complaintUpdateBo);
}
