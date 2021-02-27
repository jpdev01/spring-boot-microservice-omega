package com.onroad.backend.service;

import com.onroad.backend.entity.Customer;
import com.onroad.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void save(Customer customer)
    {
        repository.save(customer);
    }

    public List<Customer> findAll()
    {
        return repository.findAll();
    }

    public Optional<Customer> findById(Integer id)
    {
        return repository.findById(id);
    }

}
