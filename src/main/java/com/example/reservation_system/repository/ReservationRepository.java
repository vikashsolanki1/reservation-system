package com.example.reservation_system.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation_system.Model11.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
}
