package com.onroad.backend.service;

import com.onroad.backend.entity.Product;
import com.onroad.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(Product product)
    {
        if (product != null) {
            try
            {
                productRepository.save(product);
            }
            catch (Exception e)
            {
                System.err.println("erro ao salvar novo produto!");
            }
        }
    }

    public Optional<Product> findById(Integer id)
    {
        return productRepository.findById(id);
    }

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Integer id) { return productRepository.findById(id); }

}
