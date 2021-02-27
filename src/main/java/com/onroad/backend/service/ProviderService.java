package com.onroad.backend.service;

import com.onroad.backend.entity.Provider;
import com.onroad.backend.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repository;

    public void save(Provider provider)
    {
        if (provider != null) {
            try
            {
                repository.save(provider);
            }
            catch (Exception e)
            {
                System.err.println("erro ao salvar novo produto!");
            }
        }
    }

    public List<Provider> findAll()
    {
        return repository.findAll();
    }

    public Optional<Provider> findById(Integer id)
    {
        return repository.findById(id);
    }
}
