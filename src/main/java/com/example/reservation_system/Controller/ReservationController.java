package com.example.reservation_system.Controller;
import com.example.reservation_system.Model11.Reservation;
import com.example.reservation_system.Model11.User;
import com.example.reservation_system.services.ReservationService;
import com.example.reservation_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
    @Autowired    
    private ReservationService reservationService;

    @Autowired
    private UserService userService;
    @PostMapping("/book")
    public Reservation bookReservation(@RequestParam Long userId, @RequestBody Reservation reservation) {
        User user = userService.findById(userId);
        return reservationService.bookReservation(user, reservation);
    }
    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.findByUserId(userId);
    }

    @PutMapping("/cancel/{reservationId}")
    public Reservation cancelReservation(@PathVariable Long reservationId) {
        return reservationService.cancelReservation(reservationId);
    }
}
