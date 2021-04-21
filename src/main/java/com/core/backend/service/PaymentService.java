package com.core.backend.service;

import com.core.backend.entity.Payment;
import com.core.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public void save(Payment payment)
    {
        repository.save(payment);
    }

    public List<Payment> findAll()
    {
        return repository.findAll();
    }

    public Optional<Payment> findById(Integer id)
    {
        return repository.findById(id);
    }

}
