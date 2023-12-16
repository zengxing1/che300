package com.che300.app.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName RespBeanEnum.java
 * @Description TODO
 * @createTime 2023/12/14 14:20
 */

@AllArgsConstructor
@Getter
@ToString
public enum RespBeanEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    PARAM_ERROR(400, "手机号格式错误"),
    NOT_FOUND(404, "未找到"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_IMPLEMENTED(501, "未实现");

    private final Integer code;
    private final String message;
}
