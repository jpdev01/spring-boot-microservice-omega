package com.core.backend.service;

import com.core.backend.entity.Category;
import com.core.backend.entity.Customer;
import com.core.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ServiceInterface<Customer>{

    @Autowired
    private CustomerRepository repository;

    @Override
    public void save(Customer customer)
    {
        repository.save(customer);
    }

    @Override
    public Page<Customer> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Customer> get(Integer id)
    {
        return repository.findById(id);
    }

    @Override
    public List<Customer> getAll()
    {
        return repository.findAll();
    }

}
