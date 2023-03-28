package com.ruoyi.system.domain.view.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultView<T> {
    @ApiModelProperty("消息状态码")
    private Integer code = 200;

    @ApiModelProperty("数据信息")
    private T data;

    @ApiModelProperty("信息返回")
    private String msg = "success";

    /**
     * 新增
     *
     * @return
     */
    public static <K> ResultView insertSuccess(K date) {
        ResultView view = new ResultView();
        view.setCode(200);
        view.setData(date);
        view.setMsg("插入成功");

        return view;
    }

    /**
     * 删除
     *
     * @return
     */
    public static <K> ResultView deleteSuccess() {
        ResultView view = new ResultView();
        view.setCode(200);
        view.setData(null);
        view.setMsg("删除成功");

        return view;
    }

    /**
     * 修改
     *
     * @return
     */
    public static <K> ResultView updateSuccess(K date) {
        ResultView view = new ResultView();
        view.setCode(200);
        view.setData(date);
        view.setMsg("修改成功");

        return view;
    }

    /**
     * 查询
     *
     * @return
     */
    public static <K> ResultView querySuccess(K date) {
        ResultView view = new ResultView();
        view.setCode(200);
        view.setData(date);
        view.setMsg("查询成功");

        return view;
    }

    /**
     * 自定义
     *
     * @param msg
     * @param date
     * @param <K>
     * @return
     */
    public static <K> ResultView success(String msg, K date) {
        ResultView view = new ResultView();
        view.setCode(200);
        view.setData(date);
        view.setMsg(msg);

        return view;
    }
}
