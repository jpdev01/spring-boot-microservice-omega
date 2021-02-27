package onroad.backend.controller;


import onroad.backend.entity.Provider;
import onroad.backend.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private ProviderService service;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save(@PathVariable Provider provider) {
        service.save(provider);
    }

}
