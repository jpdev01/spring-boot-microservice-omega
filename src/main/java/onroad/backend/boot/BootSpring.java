package onroad.backend.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "onroad.backend.entity" })
@EnableJpaRepositories(basePackages = { "onroad.backend.repository" })
@ComponentScan(basePackages = {"onroad.backend.controller"})
public class BootSpring {

    public static void main(String[] args)
    {
        SpringApplication.run(BootSpring.class, args);
    }
}
