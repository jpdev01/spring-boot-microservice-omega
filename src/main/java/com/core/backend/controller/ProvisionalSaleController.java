package com.core.backend.controller;

import com.core.backend.entity.ProvisionalSale;
import com.core.backend.service.ProvisionalSaleService;
import com.core.simulation.ProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/provisionalSale")
public class ProvisionalSaleController {

    @Autowired
    private ProvisionalSaleService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody ProvisionalSale provisionalSale) {
        service.save(provisionalSale);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void save() {
        new ProductTest().testAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ProvisionalSale>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable)
    {
        Page<ProvisionalSale> provisionalSaleList = service.getAll(pageable);
        if (provisionalSaleList == null || provisionalSaleList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<Page<ProvisionalSale>>(provisionalSaleList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ProvisionalSale> getProduct(@PathVariable Integer id) {
        return service.getById(id);
    }
}
