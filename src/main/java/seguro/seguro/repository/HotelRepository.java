package com.example.hotelreservas.repository;

import com.example.hotelreservas.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
