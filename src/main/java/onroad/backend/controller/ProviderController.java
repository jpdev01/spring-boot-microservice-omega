package onroad.backend.controller;

import onroad.backend.entity.Product;
import onroad.backend.entity.Provider;
import onroad.backend.service.ProductService;
import onroad.backend.service.ProviderService;
import onroad.simulation.ProductTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("provider")
public class ProviderController {
    private ProviderService service = new ProviderService();

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public void save(@PathVariable("product") Provider provider) {
        service.save(provider);
    }

}
