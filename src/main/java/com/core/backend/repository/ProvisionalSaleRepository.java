package com.core.backend.repository;

import com.core.backend.entity.ProvisionalSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionalSaleRepository extends JpaRepository<ProvisionalSale, Integer> {
}
