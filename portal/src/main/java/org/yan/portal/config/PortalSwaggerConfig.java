package org.yan.portal.config;

import org.springframework.context.annotation.Configuration;
import org.yan.common.config.BaseSwaggerConfig;
import org.yan.common.domain.SwaggerProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class PortalSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("org.yan.portal.api")
                .title("Yan前台系统")
                .description("Yan前台系统API接口文档")
                .contactName("lsf")
                .version("v2.1")
                .enableSecurity(false)
                .build();
    }
}
