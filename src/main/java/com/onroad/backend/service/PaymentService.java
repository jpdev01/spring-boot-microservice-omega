package com.onroad.backend.service;

import com.onroad.backend.entity.Payment;
import com.onroad.backend.repository.PaymentRepository;
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
