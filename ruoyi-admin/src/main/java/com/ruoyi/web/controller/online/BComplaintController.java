package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.view.ComplaintInfoView;
import com.ruoyi.system.domain.view.ResultView;
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
    public ResultView<List<ComplaintInfoView>> complaintInfoList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<ComplaintInfoView> complaintInfoViews = complaintService.selectComplaintList();

        PageHelper.startPage(pageNum, pageSize);
        ResultView<List<ComplaintInfoView>> resultView = new ResultView<>();
        resultView.setData(complaintInfoViews);

        return resultView;
    }

    @ApiOperation("批量删除投诉")
    @DeleteMapping("/delete")
    public ResultView<Object> complaintDeleteAll(@RequestParam Long[] complaintIdArr) {
        complaintService.deleteComplaintAll(complaintIdArr);

        return new ResultView<>();
    }

    @ApiOperation("删除投诉")
    @DeleteMapping("/delete/{complaintId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultView<Object> complaintDelete(@PathVariable Long complaintId) {
        complaintService.deleteComplaint(complaintId);

        return new ResultView<>();
    }

    @ApiOperation("修改备注")
    @PutMapping("/update/{complaintId}")
    public ResultView<Object> complaintsUpdate(@PathVariable Long complaintId, @RequestBody ComplaintUpdateVo complaintUpdateVo) {
        complaintUpdateVo.setComplaintId(complaintId);
        complaintService.updateComplaint(complaintUpdateVo);

        return new ResultView<>();
    }
}
