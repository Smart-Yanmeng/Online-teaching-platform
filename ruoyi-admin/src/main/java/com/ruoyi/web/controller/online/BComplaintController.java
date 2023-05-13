package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.bo.complaint.ComplaintUpdateBo;
import com.ruoyi.system.domain.dto.convert.ComplaintUpdateDTOConvert;
import com.ruoyi.system.domain.vo.online.ComplaintInfoVo;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.dto.complaint.ComplaintUpdateDto;
import com.ruoyi.system.service.online.ComplaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/complaint")
@Api(tags = "Complaint")
public class BComplaintController {
    @Resource
    private ComplaintService complaintService;

    @ApiOperation("获取投诉列表")
    @GetMapping("/list")
    public ResultVo complaintInfoList(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                      @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
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
    @PatchMapping("/delete/{complaintId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo complaintDelete(@PathVariable Long complaintId) {
        complaintService.deleteComplaint(complaintId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("修改备注")
    @PutMapping("/update/{complaintId}")
    public ResultVo complaintsUpdate(@PathVariable Long complaintId, @RequestBody ComplaintUpdateDto complaintUpdateDto) {
        complaintUpdateDto.setComplaintId(complaintId);
        ComplaintUpdateBo complaintUpdateBo = new ComplaintUpdateDTOConvert().convert(complaintUpdateDto);
        complaintService.updateComplaint(complaintUpdateBo);

        return ResultVo.updateSuccess(new ComplaintUpdateDto());
    }
}
