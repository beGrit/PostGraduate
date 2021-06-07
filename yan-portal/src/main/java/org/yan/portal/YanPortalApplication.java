package org.yan.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.yan.portal", "org.yan.persistence.config"})
@EnableJpaRepositories(basePackages = {"org.yan.persistence.repository"})
public class YanPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(YanPortalApplication.class, args);
    }
}
