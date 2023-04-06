package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.po.BComplaintPo;
import com.ruoyi.system.domain.po.convert.ComplaintPOConvert;
import com.ruoyi.system.domain.vo.online.ComplaintInfoVo;
import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateVo;
import com.ruoyi.system.mapper.online.IComplaintMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintService {
    @Resource
    IComplaintMapper complaintMapper;

    public List<ComplaintInfoVo> selectComplaintList() {
        List<BComplaintPo> complaintPos = complaintMapper.selectComplaint();

        return complaintPos.stream().map(item -> new ComplaintPOConvert().convert(item)).collect(Collectors.toList());
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
