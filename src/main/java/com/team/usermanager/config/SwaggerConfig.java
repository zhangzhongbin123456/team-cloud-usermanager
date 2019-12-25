package com.team.usermanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author viroyal.zzbin
 * @version 1.0
 * @date: 2019/12/10
 * @description: Swagger Configuration .
 */
@Configuration      //表明是配置信息让spring启动时加载
@EnableSwagger2     //启用Swagger2
public class SwaggerConfig {

    //创建多个方法并用Bean注解，这样就可以针对不同的Controller创建出各自的API文档，当创建多个API时，需要指定API的名称
    //这里如果函数上面不配置@Bean注解，那么Swagger只是启动了。没有创建API信息
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())     //apiInfo()用来创建Api基本信息
                .enable(true)       //是否开启
                .useDefaultResponseMessages(false)      //是否开启默认响应码
                .select()       //选择那些路径和api会生成document，返回一个Api
                // .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))        //这里可以全局扫描有@Api注解得类
                // .apis(RequestHandlerSelectors.any())             //也可以扫描所有的
                .apis(RequestHandlerSelectors.basePackage("com.team.usermanager.controller"))      //一般都是扫描固定包
                .paths(PathSelectors.any())     // 对所有路径进行监控
                .build();
    }

    /**
     * @return api Information
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户中心")      //标题
                .description("springcloud用户中心API文档")        //描述
                //.termsOfServiceUrl("www.baidu.com")        服务条款网址
                .contact(new Contact("ZzbinXh", "zzbin992@gmail.com", "gmail"))       //作者
                //.license("google")      执照
                //.licenseUrl("https://www.google.com.tw/")       执照地址
                .version("1.0")      //版本
                .build();
    }

    private void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
