package com.che300.app.VO;

import com.che300.app.annotation.PhoneValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName PhoneNumber.java
 * @Description TODO
 * @createTime 2023/12/14 11:27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("电话号码类")
public class PhoneNumber implements Serializable {
    @JsonProperty("mobile")
    @PhoneValidation
    @ApiModelProperty("手机号码")
    private String mobile;
}
