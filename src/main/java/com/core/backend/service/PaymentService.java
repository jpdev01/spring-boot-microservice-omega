package com.core.backend.service;

import com.core.backend.entity.Payment;
import com.core.backend.entity.Sale;
import com.core.backend.repository.PaymentRepository;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.ListBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements ServiceInterface<Payment>{

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ListBuilder listBuilder;

    @Override
    public void save(Payment payment)
    {
        repository.save(payment);
    }

    @Override
    public List<Payment> getAll()
    {
        return repository.findAll();
    }

    @Override
    public Optional<Payment> get(Integer id)
    {
        return repository.findById(id);
    }

    public Page<Payment> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    public EntityList getList()
    {
        try {
            return listBuilder.build(Sale.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
