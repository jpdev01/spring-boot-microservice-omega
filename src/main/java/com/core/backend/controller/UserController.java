package com.core.backend.controller;

import com.core.backend.entity.User;
import com.core.backend.service.EFormService;
import com.core.backend.service.UserService;
import com.core.components.form.Eform;
import com.core.backend.service.list.EntityList;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private EFormService formService;

    //FIXME: FIND ALL WITH PAGEABLE
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<User>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<User> users = service.getAll(pageable);

        if (users == null || users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {
        Optional<User> user = service.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ResponseEntity<Void> save(@RequestBody User user)
//    {
//        service.save(user);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(user.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//
//
//    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        service.save(user);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody User user, @PathVariable Integer id) {
        if (service.get(id) == null) {
            // user not fouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuund
            return ResponseEntity.notFound().build();
        }
        service.save(user);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/eform/build", method = RequestMethod.GET)
    public ResponseEntity<Eform> eFormBuild() {
        Eform eform = service.buildEform();
        return ResponseEntity.ok(eform);
    }

    @RequestMapping(value = "/list/build", method = RequestMethod.GET)
    public ResponseEntity<EntityList> listBuild() {
        EntityList entityList = service.getList();
        return ResponseEntity.ok(entityList);
    }

}
