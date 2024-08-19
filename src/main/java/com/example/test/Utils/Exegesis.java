package com.example.test.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Exegesis {//Swagger工具
    /****
     * 前端接口配置
     * @return
     */
    @Bean
    public Docket getClientDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("ClientApi")
                .select()
                //扫描的包名称
                .apis(RequestHandlerSelectors.basePackage("com.library.Controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /****
     * 后台管理接口配置
     * @return
     */
    @Bean
    public Docket getBackgroundDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("BackgroundApi")
                .select()
                .apis(RequestHandlerSelectors.basePackage(""))
                .paths(PathSelectors.any())
                .build();
    }

    /***
     * 构建 api文档的详细信息函数
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("action-swagger").description("swagger实战").termsOfServiceUrl("")
                .version("1.0").build();
    }
}
