package com.onroad.backend.controller;


import com.onroad.backend.entity.Provider;
import com.onroad.backend.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/save2", method = RequestMethod.GET)
    public void save()
    {
        service.save(new Provider("monarri2", ""));
    }

}
