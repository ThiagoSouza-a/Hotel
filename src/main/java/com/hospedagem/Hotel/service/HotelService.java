package com.hospedagem.Hotel.service;

import com.hospedagem.Hotel.entities.Hotel;
import com.hospedagem.Hotel.entities.Reserva;
import com.hospedagem.Hotel.repository.HotelRepository;
import com.hospedagem.Hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public Hotel createHotel(String nome, String localizacao, Integer quartos) {
        Hotel hotel = new Hotel();
        hotel.setNome(nome);
        hotel.setLocalizacao(localizacao);
        hotel.setQuartos(quartos);
        return hotelRepository.save(hotel);
    }

    public Reserva createReserva(String viajante, LocalDateTime checkin, LocalDateTime checkout, Integer hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));
        Reserva reserva = new Reserva();
        reserva.setViajante(viajante);
        reserva.setCheckin(checkin);
        reserva.setCheckout(checkout);
        reserva.setHotel(hotel);
        return reservaRepository.save(reserva);
    }

}
