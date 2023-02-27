package com.example.employee.configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("employee-api").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.employee.controller")).paths(PathSelectors.any()).build();

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee API").description("Spring Rest API Reference")
                .licenseUrl("licenseUrl").version("1.0").build();
    }
}
