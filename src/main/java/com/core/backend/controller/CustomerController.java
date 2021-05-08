package com.core.backend.controller;


import com.core.backend.entity.Customer;
import com.core.backend.service.CustomerService;
import com.core.backend.service.list.EntityList;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    //FIXME: FIND ALL WITH PAGEABLE
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Customer>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customers = service.getAll(pageable);

//        if (customers == null || customers.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }

        return new ResponseEntity<Page<Customer>>(customers, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<User>> findAll() {
//        List<User> users = service.findAll();
//
//        if (users == null || users.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(users);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Customer>> findById(@PathVariable Integer id) {
        Optional<Customer> customer = service.get(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Customer customer) {
        service.save(customer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Customer customer, @PathVariable Integer id) {
        if (service.get(id) == null) {
            // user not found
            return ResponseEntity.notFound().build();
        }
        service.save(customer);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/list/build", method = RequestMethod.GET)
    public ResponseEntity<EntityList> listBuild() {
        EntityList entityList = service.getList();
        return ResponseEntity.ok(entityList);
    }
}
