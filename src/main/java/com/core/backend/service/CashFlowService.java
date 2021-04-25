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
public class CashFlowService implements ServiceInterface<CashFlow>{

    @Autowired
    private CashFlowRepository repository;

    @Override
    public void save(CashFlow cashFlow)
    {
        repository.save(cashFlow);
    }

    @Override
    public List<CashFlow> getAll()
    {
        return repository.findAll();
    }

    @Override
    public Page<CashFlow> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<CashFlow> get(Integer id)
    {
        return repository.findById(id);
    }

}
