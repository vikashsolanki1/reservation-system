


package com.example.reservation_system.services;

import com.example.reservation_system.Model11.Reservation;
import com.example.reservation_system.Model11.User;
import com.example.reservation_system.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation bookReservation(User user, Reservation reservation) {
        reservation.setUser(user);
        reservation.setStatus("Booked");
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public Reservation cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null) {
            reservation.setStatus("Cancelled");
            reservationRepository.save(reservation);
        }
        return reservation;
    }
}
