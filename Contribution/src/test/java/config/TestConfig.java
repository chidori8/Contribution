package config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"ru.deposit.data.repository"})
@ComponentScan(basePackages = {"ru.deposit.business.services", "ru.deposit.data.repository"})
@EntityScan(basePackages = {"ru.deposit.data.entity"})
public class TestConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
