package onroad.backend.service;

import onroad.backend.entity.Category;
import onroad.backend.entity.Product;
import onroad.backend.repository.CategoryRepository;
import onroad.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(){}

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
}
