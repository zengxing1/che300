package com.che300.app.VO;

import com.che300.app.annotation.PhoneValidation;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName NumberOwnership.java
 * @Description TODO
 * @createTime 2023/12/13 21:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("电话号码归属地信息")
public class NumberOwnership implements Serializable {

    @JsonProperty("ret")
    private String ret;
    @JsonProperty("mobile")
    @PhoneValidation
    @ApiModelProperty("手机号码")
    private String mobile;
    @JsonProperty("data")
    @ApiModelProperty("号码归属地")
    private List<String> data;
}
