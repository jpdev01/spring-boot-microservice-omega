package com.onroad.backend.repository;

import com.onroad.backend.entity.ProvisionalSale;
import com.onroad.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionalSaleRepository extends JpaRepository<ProvisionalSale, Integer> {
}
