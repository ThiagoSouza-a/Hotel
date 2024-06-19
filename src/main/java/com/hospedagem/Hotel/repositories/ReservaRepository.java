package com.hospedagem.Hotel.repositories;

import com.hospedagem.Hotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
