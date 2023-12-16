package com.che300.app.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName RespBean.java
 * @Description TODO
 * @createTime 2023/12/14 14:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object data;

    public RespBean(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public static RespBean success(Object data) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), data);
    }

    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    //失败各有不同


    public static RespBean error(long code, String message) {
        return new RespBean(code, message);
    }

}
