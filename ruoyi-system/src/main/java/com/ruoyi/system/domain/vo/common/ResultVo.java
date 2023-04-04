package com.ruoyi.system.domain.vo.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultVo<T> {
    @ApiModelProperty("消息状态码")
    private Integer code = 200;

    @ApiModelProperty("数据信息")
    private T data;

    @ApiModelProperty("信息返回")
    private String msg = "success";

    /**
     * 新增
     */
    public static <K> ResultVo insertSuccess(K date) {
        ResultVo vo = new ResultVo();
        vo.setCode(200);
        vo.setData(date);
        vo.setMsg("插入成功");

        return vo;
    }

    /**
     * 删除
     */
    public static ResultVo deleteSuccess() {
        ResultVo vo = new ResultVo();
        vo.setCode(200);
        vo.setData(null);
        vo.setMsg("删除成功");

        return vo;
    }

    /**
     * 修改
     */
    public static <K> ResultVo<Object> updateSuccess(K date) {
        ResultVo<Object> vo = new ResultVo<>();
        vo.setCode(200);
        vo.setData(date);
        vo.setMsg("修改成功");

        return vo;
    }

    /**
     * 查询
     */
    public static <K> ResultVo querySuccess(K date) {
        ResultVo vo = new ResultVo();
        vo.setCode(200);
        vo.setData(date);
        vo.setMsg("查询成功");

        return vo;
    }

    /**
     * 自定义
     */
    public static <K> ResultVo success(String msg, K date) {
        ResultVo vo = new ResultVo();
        vo.setCode(200);
        vo.setData(date);
        vo.setMsg(msg);

        return vo;
    }
}
