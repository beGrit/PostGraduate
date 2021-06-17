package org.yan.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin/welcome").setViewName("welcome/index");

        registry.addViewController("/admin/university/pageView").setViewName("university/index");
        registry.addViewController("/admin/university/addView").setViewName("university/add/index");
        registry.addViewController("/admin/university/detailView").setViewName("university/detail/index");

        registry.addViewController("/admin/location/pageView").setViewName("location/index");

        registry.addViewController("/admin/city/pageView").setViewName("city/index");

        registry.addViewController("/admin/major/pageView").setViewName("major/index");
        registry.addViewController("/admin/major/addView").setViewName("major/add/index");

        registry.addViewController("/admin/grade/pageView").setViewName("grade/index");
        registry.addViewController("/admin/grade/addView").setViewName("grade/add/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("http://localhost:8000");
                registry.addMapping("/api/**").allowedOrigins("http://localhost:8001");
            }
        };
    }
}
