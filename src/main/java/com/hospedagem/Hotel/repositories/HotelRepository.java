package com.hospedagem.Hotel.repositories;

import com.hospedagem.Hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
