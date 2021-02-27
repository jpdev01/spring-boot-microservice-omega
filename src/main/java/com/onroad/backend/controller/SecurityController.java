package com.onroad.backend.controller;

import com.onroad.backend.entity.User;
import com.onroad.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/sec")
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Optional<User> validateLogin(@RequestBody String login, @RequestBody String password)
    {
        Optional<User> user = userService.validadeLogin(login, password);
        return user;
    }
}
