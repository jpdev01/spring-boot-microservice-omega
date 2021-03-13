package com.onroad.backend.service;

import com.onroad.backend.entity.User;
import com.onroad.backend.repository.UserRepository;
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
            if (user != null)
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

    public Page<User> findAll()
    {
        return (Page<User>) repository.findAll();
    }

    public Page<User> findAll(Pageable pageable)
    {
        return (Page<User>) repository.findAll(pageable);
    }

    public Optional<User> findById(Integer id)
    {
        return repository.findById(id);
    }
}
