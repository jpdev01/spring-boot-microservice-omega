package com.core.backend.controller;

import com.core.backend.entity.Sale;
import com.core.backend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired
    private SaleService service;

    //FIXME: FIND ALL WITH PAGEABLE
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Sale>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Sale> saleList = service.getAll(pageable);

        if (saleList == null || saleList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<Page<Sale>>(saleList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Sale>> findById(@PathVariable Integer id) {
        Optional<Sale> sale = service.get(id);
        if (sale == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sale);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Sale sale) {
        service.save(sale);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Sale sale, @PathVariable Integer id) {
        Sale saleDB = service.get(id).get();
        if (saleDB == null) {
            // user not found
            return ResponseEntity.notFound().build();
        }
        service.save(sale);
        return ResponseEntity.noContent().build();
    }
}
