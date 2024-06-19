package com.hospedagem.Hotel.services;

import com.hospedagem.Hotel.entities.Hotel;
import com.hospedagem.Hotel.entities.Reserva;
import com.hospedagem.Hotel.exceptions.ResourceNotFoundException;
import com.hospedagem.Hotel.repositories.HotelRepository;
import com.hospedagem.Hotel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Reserva> findAll() {
        return repository.findAll();
    }

    public Reserva findById(Long id) {
        Optional<Reserva> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Reserva createReserva(Reserva reserva) {
        reserva.updateDates(reserva.getCheckin(), reserva.getCheckout());
        Long hotelId = reserva.getHotel().getId();
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(hotelId));
        reserva.setHotel(hotel);
        return repository.save(reserva);
    }


}
