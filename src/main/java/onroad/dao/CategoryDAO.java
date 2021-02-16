package onroad.dao;

import onroad.entity.Category;

import java.util.List;

public interface CategoryDAO {

    public void save(Category c);
    public Category findById(Integer id);
    public List<Category> findAll();
    public void remove(Integer id);
}
