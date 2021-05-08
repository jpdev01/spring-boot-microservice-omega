package com.core.backend.controller;

import com.core.backend.service.list.EntityList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.core.backend.entity.User;
import com.core.backend.service.AuthenticationService;
import com.core.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth2")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
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
            Optional<User> user = null;
            try{
               user = service.validadeLogin(login, password);
            }
            catch (IncorrectResultSizeDataAccessException e)
            {
                System.out.println("Mais de um usuário encontrado com esses dados!");
            }
            catch (Exception e)
            {

            }

            if (user != null) {
                session.setAttribute("user", user.get().getId());
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
