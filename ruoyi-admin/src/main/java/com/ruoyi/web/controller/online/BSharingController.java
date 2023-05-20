package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.bo.sharing.SharingAddBo;
import com.ruoyi.system.domain.bo.sharing.SharingUpdateBo;
import com.ruoyi.system.domain.dto.convert.SharingAddDTOConvert;
import com.ruoyi.system.domain.dto.convert.SharingUpdateDTOConvert;
import com.ruoyi.system.domain.dto.sharing.SharingUpdateDto;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.vo.online.SharingInfoVo;
import com.ruoyi.system.domain.dto.sharing.SharingAddDto;
import com.ruoyi.system.domain.bo.sharing.SharingSearchBo;
import com.ruoyi.system.service.online.SharingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homePageManage/sharing")
@Api(tags = "Sharing")
public class BSharingController {
    @Resource
    SharingService sharingService;

    @ApiOperation("获取分享列表")
    @GetMapping()
    public ResultVo bannerInfo(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                               @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SharingInfoVo> sharingInfoVos = sharingService.selectSharingList();

        return ResultVo.querySuccess(sharingInfoVos);
    }

    @ApiOperation("查询分享列表")
    @GetMapping("/list")
    public ResultVo sharingInfoSearchList(@RequestParam(required = false) String sharingTitle,
                                          @RequestParam(required = false) String sharingSubtitle,
                                          @RequestParam(required = false) String honouredGuest,
                                          @RequestParam Character isRelease,
                                          @RequestParam Character isLink,
                                          @RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                          @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        SharingSearchBo sharingSearchBo = new SharingSearchBo();
        sharingSearchBo.setSharingTitle(sharingTitle);
        sharingSearchBo.setSharingSubtitle(sharingSubtitle);
        sharingSearchBo.setHonouredGuest(honouredGuest);
        sharingSearchBo.setIsRelease(isRelease);
        sharingSearchBo.setIsLink(isLink);

        PageHelper.startPage(pageNum, pageSize);
        List<SharingInfoVo> sharingInfoVos = sharingService.querySharingList(sharingSearchBo);

        return ResultVo.querySuccess(sharingInfoVos);
    }

    @ApiOperation("重置分享列表")
    @GetMapping("/reset")
    public ResultVo sharingReset(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                 @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SharingInfoVo> sharingInfoVos = sharingService.selectSharingList();

        return ResultVo.querySuccess(sharingInfoVos);
    }

    @ApiOperation("新增分享")
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo sharingAdd(@RequestBody SharingAddDto sharingAddDto) {
        SharingAddBo sharingAddBo = new SharingAddDTOConvert().convert(sharingAddDto);
        sharingService.insertSharing(sharingAddBo);

        return ResultVo.insertSuccess(new SharingAddDto());
    }

    @ApiOperation("批量删除分享")
    @PatchMapping
    @Transactional(rollbackFor = Exception.class)
    public ResultVo sharingPatchAll(@RequestParam Long[] sharingIdArr) {
        sharingService.patchSharingAll(sharingIdArr);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("修改分享")
    @PutMapping("/update/{sharingId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo sharingUpdate(@PathVariable String sharingId,
                                  @RequestBody SharingUpdateDto sharingUpdateDto) {
        SharingUpdateBo sharingUpdateBo = new SharingUpdateDTOConvert().convert(sharingUpdateDto);
        sharingService.updateSharing(sharingUpdateBo);

        return ResultVo.updateSuccess(new SharingUpdateDto());
    }

    @ApiOperation("删除分享")
    @PatchMapping("/delete/{sharingId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo sharingPatch(@PathVariable Long sharingId) {
        sharingService.patchSharing(sharingId);

        return ResultVo.deleteSuccess();
    }

    @ApiOperation("是否发布")
    @PostMapping("/release/{sharingId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultVo sharingIsRelease(@PathVariable Long sharingId) {
        Boolean flag = sharingService.releaseSharing(sharingId);

        if (flag) return ResultVo.success("发布成功", null);
        else return ResultVo.success("取消发布成功", null);
    }
}
