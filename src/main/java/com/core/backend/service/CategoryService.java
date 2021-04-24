package com.core.backend.service;

import com.core.backend.entity.Category;
import com.core.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ServiceInterface<Category> {
    @Autowired
    public CategoryRepository repository;

    @Override
    public Page<Category> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Category> get(Integer id) {
       return repository.findById(id);
    }

    @Override
    public void save(Category category)
    {
        repository.save(category);
    }

}
