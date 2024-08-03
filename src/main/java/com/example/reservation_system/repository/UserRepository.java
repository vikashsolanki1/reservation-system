package com.example.reservation_system.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation_system.Model11.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

