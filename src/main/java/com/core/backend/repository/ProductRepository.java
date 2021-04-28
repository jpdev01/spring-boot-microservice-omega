package com.core.backend.repository;

import com.core.backend.entity.Category;
import com.core.backend.entity.Product;
import com.core.backend.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByCode(String code);

    Optional<List<Product>> findProductsByCategoriesIn(List<Category> categoryList);

    Optional<List<Product>> findProductsByProvider(Provider provider);
}
