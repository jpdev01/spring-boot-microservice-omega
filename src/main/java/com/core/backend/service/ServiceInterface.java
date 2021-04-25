package com.core.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {
    public Page<T> getAll(Pageable pageable);
    public Optional<T> get(Integer id);
    public void save(T object);
    public List<T> getAll();
}
