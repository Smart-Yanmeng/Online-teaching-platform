package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.vo.online.ComplaintInfoVo;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateVo;
import com.ruoyi.system.service.online.ComplaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/complaint")
@Api(tags = "Complaint")
public class BComplaintController {
    @Resource
    private ComplaintService complaintService;

    @ApiOperation("获取投诉列表")
    @GetMapping
    public ResultVo complaintInfoList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ComplaintInfoVo> complaintInfoVos = complaintService.selectComplaintList();

        return ResultVo.querySuccess(complaintInfoVos);
    }

    @ApiOperation("批量删除投诉")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultVo complaintPatchAll(@RequestParam Long[] complaintIdArr) {
        complaintService.patchComplaintAll(complaintIdArr);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("删除投诉")
    @PatchMapping("/{complaintId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo complaintDelete(@PathVariable Long complaintId) {
        complaintService.deleteComplaint(complaintId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("修改备注")
    @PutMapping("/update/{complaintId}")
    public ResultVo complaintsUpdate(@PathVariable Long complaintId, @RequestBody ComplaintUpdateVo complaintUpdateVo) {
        complaintUpdateVo.setComplaintId(complaintId);
        complaintService.updateComplaint(complaintUpdateVo);

        return ResultVo.updateSuccess(null);
    }
}
