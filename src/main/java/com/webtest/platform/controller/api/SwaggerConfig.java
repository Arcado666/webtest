
package com.webtest.platform.controller.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 
 * @date 
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public Docket buildDocket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select().apis(RequestHandlerSelectors.basePackage("org.suren.autotest.platform.controller.api"))//controller路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf()
    {
        return new ApiInfoBuilder()
                .title("商米WebUI自动化测试平台")
                .termsOfServiceUrl("https://mall.sunmi.com")
                .description("商米WebUI自动化测试平台")
                .contact(new Contact("sunmi", "https://mall.sunmi.com", "zhangshiqiang@sunmi.com"))
                .build();
    }
}
