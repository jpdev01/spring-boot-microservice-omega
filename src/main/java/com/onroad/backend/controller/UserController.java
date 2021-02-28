package com.onroad.backend.controller;

import com.onroad.backend.entity.Category;
import com.onroad.backend.entity.User;
import com.onroad.backend.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll()
    {
        List<User> users = service.findAll();
        if (users == null || users.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id)
    {
        Optional<User> user = service.findById(id);
        if (user == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody User user)
    {
            service.save(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).build();
            //ResponseEntity.status(HttpStatus.FORBIDDEN).body("not authorized")


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody User user, @PathVariable Integer id)
    {
        if (service.findById(id) == null)
        {
            // user not found
            return ResponseEntity.notFound().build();
        }
        service.save(user);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Optional<User>> validateLogin(@Valid @RequestBody String login, @Valid @RequestBody String password)
    {
        Optional<User> user = service.validadeLogin(login, password);
        return ResponseEntity.ok(user);
    }

}
