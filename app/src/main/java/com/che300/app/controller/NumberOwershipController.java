package com.che300.app.controller;

import com.che300.app.VO.NumberOwnership;
import com.che300.app.VO.PhoneNumber;
import com.che300.app.VO.RespBean;
import com.che300.app.VO.RespBeanEnum;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName NumberOwershipController.java
 * @Description TODO
 * @createTime 2023/12/13 21:05
 */

@RestController
@RequestMapping("number")
@CrossOrigin(origins = "*")
@Slf4j
@Api(tags = "号码查询归属地")
public class NumberOwershipController {


    @Value("${token}")
    private String token;


    private RestTemplate restTemplate;


    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Autowired
    public NumberOwershipController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @param :
     * @return RespBean
     * @author caijiangfan
     * @description 测试
     * @date 2023/12/15 10:47
     */
    @GetMapping("/get")
    @ApiOperation(value = "测试", notes = "返回123456")
    public RespBean getNumber() {
        return RespBean.success("123456");
    }

    /**
     * 获取手机号码归属地
     *
     * @param phone  手机号码
     * @param result 校验结果
     * @return RespBean对象
     */
    @PostMapping("/getNumberOwnership")
    @ApiOperation(value = "查询号码归属地", notes = "根据电话号码查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone", value = "电话号码", required = true)})
    public RespBean getNumberOwnership(@RequestBody @Valid PhoneNumber phone, BindingResult result) {
        if (result.hasErrors()) {
            String message = result.getFieldError().getDefaultMessage();
            return RespBean.error(RespBeanEnum.PARAM_ERROR.getCode(), message);
        }
        //查询缓存
        NumberOwnership numberOwnership = (NumberOwnership) redisTemplate.opsForValue().get("phone:" + phone.getMobile());
        if (numberOwnership != null) {
            log.info("从缓存中获取归属地信息 " + phone.getMobile() + " " + numberOwnership);
            return RespBean.success(numberOwnership);
        }

        // 构建请求URL
        String url = "https://api.ip138.com/mobile/?mobile=" + phone.getMobile() + "&datatype=jsonp&token=" + token;
        // 发起GET请求
        ResponseEntity<NumberOwnership> entity = restTemplate.getForEntity(url, NumberOwnership.class);
        if (entity.getStatusCodeValue() == 200) {
            // 响应内容转换为实体对象NumberOwnership numberOwnershipcache= entity.getBody();
            log.info("存入缓存 " + phone.getMobile() + " " + entity.getBody());
            NumberOwnership numberOwnershipcache = entity.getBody();
            //存入缓存，过期时间为12小时
            redisTemplate.opsForValue().set("phone:" + phone.getMobile(), numberOwnershipcache, 12, TimeUnit.HOURS);
            return RespBean.success(entity.getBody());
        } else {
            return RespBean.error(entity.getStatusCodeValue(), entity.getStatusCode().toString());
        }
    }


}
