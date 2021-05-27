package org.yan.admin.config;

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
                .apiBasePackage("org.yan.admin.api")
                .title("Yan后台管理系统")
                .description("Yan后台管理系统API接口文档")
                .contactName("lsf")
                .version("v2.1")
                .enableSecurity(false)
                .build();
    }
}
