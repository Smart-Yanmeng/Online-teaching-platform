package com.ruoyi.system.mapper.online;

import com.ruoyi.system.domain.po.BComplaintPo;
import com.ruoyi.system.domain.vo.online.ComplaintInfoVo;
import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateVo;

import java.util.List;

public interface IComplaintMapper {
    List<BComplaintPo> selectComplaint();

    void patchComplaintByCondition(Long complaintId);

    void updateComplaint(ComplaintUpdateVo complaintUpdateVo);
}
