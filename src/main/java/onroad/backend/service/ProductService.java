package onroad.backend.service;

import onroad.backend.entity.Product;
import onroad.backend.repository.ProductRepository;

public class ProductService {

    ProductRepository productRepository;
    public ProductService(){}

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
}
