package com.core.backend.service;

import com.core.backend.entity.Category;
import com.core.backend.entity.User;
import com.core.backend.repository.CategoryRepository;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.ListBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ServiceInterface<Category>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ListBuilder listBuilder;

    @Override
    public Page<Category> getAll(Pageable pageable)
    {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void save(Category category)
    {
        if (category != null) {
            try
            {
                categoryRepository.save(category);
            }
            catch (Exception e)
            {
                System.err.println("erro ao salvar novo produto!");
            }
        }
    }

    @Override
    public Optional<Category> get(Integer id)
    {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAll()
    {
        return categoryRepository.findAll();
    }

    public EntityList getList()
    {
        return listBuilder.build(Category.class);
    }
}
