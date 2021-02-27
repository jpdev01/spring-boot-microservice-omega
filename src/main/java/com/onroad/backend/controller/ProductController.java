package com.onroad.backend.controller;

import com.onroad.backend.entity.Product;
import com.onroad.backend.service.ProductService;
import com.onroad.simulation.ProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save(@PathVariable Product product) {
        service.save(product);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void save() {
        new ProductTest().testAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll()
    {
        return service.getAll();
    }

}
