package onroad.backend.controller;

import onroad.backend.entity.Product;
import onroad.backend.entity.Provider;
import onroad.backend.repository.ProductRepository;
import onroad.backend.repository.ProviderRepository;
import onroad.backend.service.ProductService;
import onroad.simulation.ProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductService service = new ProductService();

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save(@PathVariable Product product) {
        service.save(product);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void save() {
        new ProductTest().testAll();
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Product> getAll()
    {
        return service.getAll();
    }

}
