package com.core.backend.service;

import com.core.backend.entity.Provider;
import com.core.backend.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService implements ServiceInterface<Provider>{
    @Autowired
    private ProviderRepository repository;

    @Override
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

    @Override
    public List<Provider> getAll()
    {
        return repository.findAll();
    }

    @Override
    public Page<Provider> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Provider> get(Integer id)
    {
        return repository.findById(id);
    }
}
