package com.core.backend.service;

import com.core.backend.service.list.EntityList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {
    public List<T> getAll();
    public Page<T> getAll(Pageable pageable);
    public Optional<T> get(Integer id);
    public void save(T entity);
    public EntityList getList();
}
