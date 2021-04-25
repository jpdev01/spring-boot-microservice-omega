package com.core.backend.service;

import com.core.backend.entity.Category;
import com.core.backend.entity.Product;
import com.core.backend.entity.Provider;
import com.core.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ServiceInterface<Product>{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProviderService providerService;

    @Override
    public void save(Product product)
    {
        List<Category> categories = product.getCategories();
        List<Category> newCategories = new ArrayList<>();
        if (categories != null && !categories.isEmpty())
        {
            for (int i = 0; i < categories.size(); i++)
            {
                Optional<Category> category = categoryService.get(categories.get(i).getId());
                Category oCategory = category.get();
                if (oCategory != null)
                {
                    newCategories.add(oCategory);
                }
            }
        }
        product.setCategories(newCategories);
        Provider provider = product.getProvider();
        if (provider == null || provider.getId() == null)
        {
            product.setProvider(null);
        }
        else
        {
            product.setProvider(providerService.get(provider.getId()).get());
        }
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

    @Override
    public Optional<Product> get(Integer id)
    {
        return productRepository.findById(id);
    }

    public Optional<Product> findByCode(String code)
    {
        return productRepository.findByCode(code);
    }

    @Override
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAll(Pageable pageable)
    {
        return productRepository.findAll(pageable);
    }

    public Optional<List<Product>> getAllFromCategory(Integer categoryId){
        Category category = categoryService.get(categoryId).get();
        if (category != null){
            List<Category> categoryList = new ArrayList<>();
            categoryList.add(category);
            return productRepository.findProductsByCategoriesIn(categoryList);
        }
        return null;
    }

}
