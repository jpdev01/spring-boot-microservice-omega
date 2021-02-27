package com.onroad.backend.controller;

import com.onroad.backend.entity.User;
import com.onroad.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll()
    {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User> findById(@PathVariable Integer id)
    {
        return service.findById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody User user)
    {
        service.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody User user, @PathVariable Integer id)
    {
        service.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Optional<User> validateLogin(@RequestBody String login, @RequestBody String password)
    {
        Optional<User> user = service.validadeLogin(login, password);
        return user;
    }

}
