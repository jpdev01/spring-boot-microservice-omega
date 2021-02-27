package com.onroad.backend.repository;

import com.onroad.backend.entity.Provider;
import com.onroad.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
