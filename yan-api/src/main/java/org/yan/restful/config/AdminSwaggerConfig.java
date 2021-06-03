package org.yan.restful.config;

import org.springframework.context.annotation.Configuration;
import org.yan.common.config.BaseSwaggerConfig;
import org.yan.common.domain.page.SwaggerProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AdminSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("org.yan.restful.api")
                .title("Yan-API接口系统")
                .description("Yan-API接口文档")
                .contactName("lsf")
                .version("v2.3")
                .enableSecurity(false)
                .build();
    }
}
