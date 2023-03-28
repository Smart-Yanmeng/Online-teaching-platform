package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ComplaintInfoView;
import com.ruoyi.system.domain.view.common.ResultView;
import com.ruoyi.system.domain.vo.complaint.ComplaintUpdateVo;
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

    @ApiOperation("刷新投诉列表")
    @GetMapping
    public ResultView complaintInfoList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<ComplaintInfoView> complaintInfoViews = complaintService.selectComplaintList();

        return ResultView.querySuccess(complaintInfoViews);
    }

    @ApiOperation("批量删除投诉")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultView complaintPatchAll(@RequestParam Long[] complaintIdArr) {
        complaintService.patchComplaintAll(complaintIdArr);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("删除投诉")
    @PatchMapping("/{complaintId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView complaintDelete(@PathVariable Long complaintId) {
        complaintService.deleteComplaint(complaintId);

        return ResultView.deleteSuccess();
    }

    @ApiOperation("修改备注")
    @PutMapping("/update/{complaintId}")
    public ResultView complaintsUpdate(@PathVariable Long complaintId, @RequestBody ComplaintUpdateVo complaintUpdateVo) {
        complaintUpdateVo.setComplaintId(complaintId);
        complaintService.updateComplaint(complaintUpdateVo);

        return ResultView.updateSuccess(null);
    }
}
