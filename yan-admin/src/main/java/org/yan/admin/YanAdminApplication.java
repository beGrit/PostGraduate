package org.yan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.yan.admin", "org.yan.persistence.config"})
@EnableJpaRepositories(basePackages = {"org.yan.persistence.repository"})
@ServletComponentScan(basePackages = "org.yan.admin.filter")
public class YanAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(YanAdminApplication.class, args);
    }
}
