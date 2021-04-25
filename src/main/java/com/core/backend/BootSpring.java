package com.core.backend;

import com.core.backend.entity.Category;
import com.core.backend.entity.Product;
import com.core.backend.entity.Provider;
import com.core.backend.entity.User;
import com.core.backend.service.CategoryService;
import com.core.backend.service.ProductService;
import com.core.backend.service.ProviderService;
import com.core.backend.service.UserService;
import com.core.custom.Permission;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BootSpring  implements CommandLineRunner {


    @Autowired
    private ProductService productService;

    @Autowired
    ProviderService providerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    public static void main(String[] args)
    {
        SpringApplication.run(BootSpring.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = userService.getAll();
        if (users == null || users.isEmpty())
        {
            User user = new User("adm", "adm", Permission.ADM);
            userService.save(user);
        }
        List<Product> products = productService.getAll();
        if (products == null || products.isEmpty())
        {
            Provider provider = new Provider("Monnari", "teste");
            providerService.save(provider);
            Category category = new Category("Inverno", "teste");
            categoryService.save(category);
            List<Category> categories = new ArrayList<>();
            categories.add(category);
            Product product = new Product("teste", new Float(100),  new Float(50), "teste", 1, "branco", "M", new Date(), "nenhu", "P", "40", "1", categories, provider);
            productService.save(product);
        }
//        providerService.save(new Provider("monnari", ""));
    }
}
