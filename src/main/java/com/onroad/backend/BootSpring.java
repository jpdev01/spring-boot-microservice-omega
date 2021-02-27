package com.onroad.backend;

import com.onroad.backend.entity.Provider;
import com.onroad.backend.service.CategoryService;
import com.onroad.backend.service.ProductService;
import com.onroad.backend.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BootSpring  implements CommandLineRunner {


    @Autowired
    private ProductService productService;

    @Autowired
    ProviderService providerService;

    @Autowired
    CategoryService categoryService;

    public static void main(String[] args)
    {
        SpringApplication.run(BootSpring.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        providerService.save(new Provider("monnari", ""));
    }
}
