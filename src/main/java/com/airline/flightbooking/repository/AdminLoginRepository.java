package com.airline.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.flightbooking.model.Login;

public interface AdminLoginRepository extends JpaRepository<Login, String> {

}
