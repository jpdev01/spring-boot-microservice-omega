package com.core.backend.service;

import com.core.backend.entity.Customer;
import com.core.backend.entity.User;
import com.core.backend.repository.CustomerRepository;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.ListBuilder;
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

    @Autowired
    private ListBuilder listBuilder;

    @Override
    public void save(Customer customer)
    {
        repository.save(customer);
    }

    @Override
    public List<Customer> getAll()
    {
        return repository.findAll();
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

    public EntityList getList()
    {
        try {
            return listBuilder.build(Customer.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
