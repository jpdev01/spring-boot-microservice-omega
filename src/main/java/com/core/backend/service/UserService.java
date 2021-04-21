package com.core.backend.service;

import com.core.backend.entity.User;
import com.core.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            if (isValidUser(user))
            {
                Integer id = user.getId();
                if (id != null)
                {
                    if (repository.existsById(id))
                    {
                        // FIXME Fazer validação de usuário já existe
                    }
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

    // FIXME = FINDALL WITH PAGEABLE
    public Page<User> findAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    public Optional<User> findById(Integer id)
    {
        return repository.findById(id);
    }

    private boolean isValidUser(User user) {
        return user != null && user.getLogin() != null && user.getPassword() != null;
    }

    public Integer validateLogin(String login, String password)
    {
        return repository.validate(login, password);
    }

    public User getUserByLogin(String login)
    {
        return repository.findByLogin(login);
    }
}
