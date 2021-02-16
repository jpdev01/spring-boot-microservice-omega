package onroad.dao;

import onroad.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProductDAO {

    public void save(Product p);
    public Product findById(Integer id);
    public List<Product> findAll();
    public void remove(Integer id);
}
