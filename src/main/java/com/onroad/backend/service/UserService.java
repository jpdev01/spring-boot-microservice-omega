package com.onroad.backend.service;

import com.onroad.backend.entity.User;
import com.onroad.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void save(User user)
    {
        try
        {
            if (user != null)
            {
                if (repository.existsById(user.getId()))
                {
                    // FIXME Fazer validação de usuário já existe
                }
                repository.save(user);
            }
        }
        catch (Exception e)
        {
            System.out.println("erro ao salvar usuário " + e);
        }
    }

    public List<User> findAll()
    {
        return repository.findAll();
    }

    public Optional<User> findById(Integer id)
    {
        return repository.findById(id);
    }

    public Optional<User> validadeLogin(String paramLogin, String paramPassword)
    {
        Integer id = repository.validate(paramLogin, paramPassword);
        if (id != null)
        {
            Optional<User> user = findById(id);
            return user;
        }
        return null;
        // FIXME retornar para a tela de acesso negado!
    }
}
