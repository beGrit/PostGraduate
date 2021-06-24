package org.yan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.yan.restful", "org.yan.persistence.config", "org.yan.admin.service", "org.yan.security"})
@EnableJpaRepositories(basePackages = {"org.yan.persistence.repository"})
@ServletComponentScan(basePackages = "org.yan.security.filter")
public class YanApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YanApiApplication.class, args);
    }
}