package com.ruoyi.system.domain.view;

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

    public static ResultView success(Object data) {
        ResultView view = new ResultView();
        view.setData(data);

        return view;
    }

    public static ResultView fail(String msg) {
        ResultView view = new ResultView();
        view.setCode(500);
        view.setMsg(msg);

        return view;
    }
}
