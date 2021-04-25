package com.core.backend.service;

import com.core.backend.entity.Category;
import com.core.backend.entity.Payment;
import com.core.backend.repository.PaymentRepository;
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

    @Override
    public void save(Payment payment)
    {
        repository.save(payment);
    }

    @Override
    public Page<Payment> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Payment> get(Integer id)
    {
        return repository.findById(id);
    }

    @Override
    public List<Payment> getAll()
    {
        return repository.findAll();
    }

}
