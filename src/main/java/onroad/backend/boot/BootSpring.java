package onroad.backend.boot;

import onroad.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootSpring {


    public static void main(String[] args)
    {
        SpringApplication.run(BootSpring.class, args);
    }
}
