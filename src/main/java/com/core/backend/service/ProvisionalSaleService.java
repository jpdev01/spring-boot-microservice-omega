package com.core.backend.service;

import com.core.backend.entity.ProvisionalSale;
import com.core.backend.entity.User;
import com.core.backend.repository.ProvisionalSaleRepository;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.ListBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvisionalSaleService implements ServiceInterface<ProvisionalSale> {

    @Autowired
    private ProvisionalSaleRepository repo;

    @Autowired
    private ListBuilder listBuilder;

    @Override
    public void save(ProvisionalSale provisionalSale) {
        repo.save(provisionalSale);
    }

    @Override
    public Optional<ProvisionalSale> get(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Page<ProvisionalSale> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<ProvisionalSale> getAll() {
        return repo.findAll();
    }

    public EntityList getList() {
        return listBuilder.build(ProvisionalSale.class);
    }


}
