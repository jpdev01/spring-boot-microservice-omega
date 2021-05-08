package com.core.backend.controller;

import com.core.backend.entity.Category;
import com.core.backend.service.CategoryService;
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
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Category category) {
        service.save(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Category> get(@PathVariable Integer id)
    {
        if (id != null)
        {
            return service.get(id);
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
        Page<Category> categories = service.getAll(pageable);

//        if (customers == null || customers.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }

        return new ResponseEntity<Page<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/list/build", method = RequestMethod.GET)
    public ResponseEntity<EntityList> listBuild() {
        EntityList entityList = service.getList();
        return ResponseEntity.ok(entityList);
    }

}
