package com.onroad.backend.repository;

import com.onroad.backend.entity.CashFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashFlowRepository extends JpaRepository<CashFlow, Integer> {
}
