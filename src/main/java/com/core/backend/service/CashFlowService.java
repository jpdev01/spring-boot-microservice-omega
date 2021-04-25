package com.core.backend.service;

import com.core.backend.entity.CashFlow;
import com.core.backend.repository.CashFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashFlowService {

    @Autowired
    private CashFlowRepository repository;

    public void save(CashFlow cashFlow)
    {
        repository.save(cashFlow);
    }

    public List<CashFlow> getAll()
    {
        return repository.findAll();
    }

    public Optional<CashFlow> get(Integer id)
    {
        return repository.findById(id);
    }

    public Page<CashFlow> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

}
