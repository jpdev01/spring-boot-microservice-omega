package onroad.backend.controller;

import onroad.backend.entity.Product;
import onroad.backend.repository.ProductRepository;
import onroad.backend.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService = null;
    private ProductRepository productRepository;

    @RequestMapping(value = "/{product}", method = RequestMethod.GET)
    public void save(@PathVariable("product") Product product) {
        if (product != null) {
            productRepository.save(product);
        }
    }

}
