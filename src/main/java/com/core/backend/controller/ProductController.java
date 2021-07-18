package com.core.backend.controller;

import com.core.backend.entity.Product;
import com.core.backend.service.ProductService;
import com.core.backend.service.list.EntityList;
import com.core.components.form.Eform;
import com.core.simulation.ProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Product product) {
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
        return service.get(id);
    }

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    public Optional<Product> getProductByCode(@PathVariable String code) {
        return service.findByCode(code);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public  ResponseEntity<List<Product>> getAllFromCategory(@PathVariable String id) {
        Integer categoryId = Integer.parseInt(id);
        Optional<List<Product>> products = service.getAllFromCategory(categoryId);
        if (!products.isPresent())
        {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<List<Product>>(products.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/provider/{id}", method = RequestMethod.GET)
    public  ResponseEntity<List<Product>> getAllFromProvider(@PathVariable String id) {
        Integer providerId = Integer.parseInt(id);
        Optional<List<Product>> products = service.getAllFromProvider(providerId);
        if (!products.isPresent())
        {
            return ResponseEntity.noContent().build();  
        }
        return new ResponseEntity<List<Product>>(products.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/eform/build", method = RequestMethod.GET)
    public ResponseEntity<Eform> eFormBuild() {
        Eform eform = service.buildEform();
        return ResponseEntity.ok(eform);
    }

    @RequestMapping(value = "/list/build", method = RequestMethod.GET)
    public ResponseEntity<EntityList> listBuild(@RequestParam(required = false, name = "category") String category) {
        EntityList entityList = service.getList();
        return ResponseEntity.ok(entityList);
    }

}
