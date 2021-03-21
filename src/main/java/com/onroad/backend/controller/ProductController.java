package com.onroad.backend.controller;

import com.onroad.backend.entity.Product;
import com.onroad.backend.entity.User;
import com.onroad.backend.service.ProductService;
import com.onroad.simulation.ProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Page<Product>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable)
    {
        Page<Product> products = service.getAll(pageable);
        if (products == null || products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<Page<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable Integer id) {
        return service.getById(id);
    }

}
