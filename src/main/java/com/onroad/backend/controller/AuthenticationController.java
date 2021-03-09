package com.onroad.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onroad.backend.entity.User;
import com.onroad.backend.service.AuthenticationService;
import com.onroad.backend.service.UserService;
import com.onroad.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    //    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Optional<User>> validateLogin(@RequestBody String submitLogin, HttpSession session) {
        String login = null;
        String password = null;
        if (new JsonUtils().isJSONValid(submitLogin) == true) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                User user = objectMapper.readValue(submitLogin, User.class);
                login = user.getLogin();
                password = user.getPassword();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        if (login != null && password != null) {
            Optional<User> user = service.validadeLogin(login, password);
            if (user != null) {
                session.setAttribute("user", user.get().getId());
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
