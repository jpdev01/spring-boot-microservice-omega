package com.onroad.backend.repository;

import com.onroad.backend.entity.Category;
import com.onroad.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByCode(String code);

    Optional<List<Product>> findProductsByCategoriesIn(List<Category> categoryList);
}
