package com.core.backend.service;

import com.core.backend.entity.User;
import com.core.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> validadeLogin(String paramLogin, String paramPassword)
    {
        Integer id = userRepository.validate(paramLogin, paramPassword);
        if (id != null)
        {
            Optional<User> user = userRepository.findById(id);
            return user;
        }
        return null;
        // FIXME retornar para a tela de acesso negado!
    }
}
