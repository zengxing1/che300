package com.che300.app.configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName SwaggerConfig.java
 * @Description TODO
 * @createTime 2023/12/15 13:58
 */
@Configuration
public class SwaggerConfig {

    @Bean
    Docket docket() {
        // 设置 swagger的版本
        return new Docket(DocumentationType.OAS_30)
                // 选择生成接口文档
                .select()
                // 包所在的路径
                .apis(RequestHandlerSelectors.basePackage("com.che300.app.controller"))
                // 当前包下所有接口都生成
                .paths(PathSelectors.any())
                .build()
                // 接口文档初始化
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("电话号码归属地查询项目接口文档")
                                .version("v1.0")
                                .title("API 测试文档")
                                .license("Apache 2.0")
                                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                                .contact(new Contact("caijiangfan", "", "caijiangfan0711@163.com"))
                                .build()
                );

    }
}
