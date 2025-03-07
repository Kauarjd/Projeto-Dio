package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotel.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}