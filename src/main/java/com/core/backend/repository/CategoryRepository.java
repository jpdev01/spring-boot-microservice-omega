package com.core.backend.repository;

import com.core.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
