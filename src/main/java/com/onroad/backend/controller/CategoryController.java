package com.onroad.backend.controller;

import com.onroad.backend.entity.Category;
import com.onroad.backend.entity.Customer;
import com.onroad.backend.service.CategoryService;
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
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save(@PathVariable Category category) {
        service.save(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Category> get(@PathVariable Integer id)
    {
        if (id != null)
        {
            return service.findById(id);
        }
        return null;
        // FIXME deve retornar pagina de erro!
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<Category> getAll()
//    {
//        return service.findAll();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Category>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Category> categories = service.findAll(pageable);

//        if (customers == null || customers.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }

        return new ResponseEntity<Page<Category>>(categories, HttpStatus.OK);
    }

}
