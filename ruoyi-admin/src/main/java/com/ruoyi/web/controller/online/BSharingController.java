package com.ruoyi.web.controller.online;

import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.bo.sharing.SharingAddBo;
import com.ruoyi.system.domain.bo.sharing.SharingUpdateBo;
import com.ruoyi.system.domain.dto.convert.SharingAddDTOConvert;
import com.ruoyi.system.domain.dto.convert.SharingUpdateDTOConvert;
import com.ruoyi.system.domain.dto.sharing.SharingUpdateDto;
import com.ruoyi.system.domain.vo.common.ResultVo;
import com.ruoyi.system.domain.dto.sharing.SharingAddDto;
import com.ruoyi.system.domain.bo.sharing.SharingSearchBo;
import com.ruoyi.system.domain.vo.online.sharing.SharingInfoVo;
import com.ruoyi.system.service.online.SharingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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

        SharingInfoVo sharingInfoVo = new SharingInfoVo();
        sharingInfoVo.setSharingInfos(sharingService.selectSharingList());
        sharingInfoVo.setSharingUseSum(sharingService.countUseSharing(null));

        return ResultVo.querySuccess(sharingInfoVo);
    }

    @ApiOperation("查询分享列表")
    @GetMapping("/list")
    public ResultVo sharingInfoSearchList(@RequestParam(required = false) String sharingTitle,
                                          @RequestParam(required = false) String sharingSubtitle,
                                          @RequestParam(required = false) String sharingIntroduce,
                                          @RequestParam(required = false) String honouredGuest,
                                          @RequestParam(required = false) Character isRelease,
                                          @RequestParam(required = false) Character isLink,
                                          @RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                          @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        SharingSearchBo sharingSearchBo = new SharingSearchBo();
        sharingSearchBo.setSharingTitle(sharingTitle);
        sharingSearchBo.setSharingSubtitle(sharingSubtitle);
        sharingSearchBo.setSharingIntroduce(sharingIntroduce);
        sharingSearchBo.setHonouredGuest(honouredGuest);
        sharingSearchBo.setIsRelease(isRelease);
        sharingSearchBo.setIsLink(isLink);

        PageHelper.startPage(pageNum, pageSize);

        SharingInfoVo sharingInfoVo = new SharingInfoVo();
        sharingInfoVo.setSharingInfos(sharingService.querySharingList(sharingSearchBo));
        sharingInfoVo.setSharingUseSum(sharingService.countUseSharing(sharingSearchBo));

        return ResultVo.querySuccess(sharingInfoVo);
    }

    @ApiOperation("重置分享列表")
    @GetMapping("/reset")
    public ResultVo sharingReset(@RequestParam(defaultValue = "1") @Valid Integer pageNum,
                                 @RequestParam(defaultValue = "10") @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        SharingInfoVo sharingInfoVo = new SharingInfoVo();
        sharingInfoVo.setSharingInfos(sharingService.selectSharingList());
        sharingInfoVo.setSharingUseSum(sharingService.countUseSharing(null));

        return ResultVo.querySuccess(sharingInfoVo);
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
    public ResultVo sharingUpdate(@PathVariable Long sharingId,
                                  @RequestBody SharingUpdateDto sharingUpdateDto) {
        SharingUpdateBo sharingUpdateBo = new SharingUpdateDTOConvert().convert(sharingUpdateDto);
        sharingUpdateBo.setSharingId(sharingId);
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
