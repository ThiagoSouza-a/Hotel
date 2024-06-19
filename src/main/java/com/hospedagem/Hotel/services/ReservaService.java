package com.hospedagem.Hotel.services;

import com.hospedagem.Hotel.entities.Reserva;
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

    public List<Reserva> findAll() {
        return repository.findAll();
    }

    public Reserva findById(Long id) {
        Optional<Reserva> obj = repository.findById(id);
        return obj.get();
    }

    public Reserva updateDates(Long id, LocalDate checkin, LocalDate checkout) {
        Reserva obj = findById(id);
        obj.updateDates(checkin, checkout);
        return repository.save(obj);
    }


    public Reserva createReserva(Reserva reserva) {
        reserva.updateDates(reserva.getCheckin(), reserva.getCheckout());
        return repository.save(reserva);
    }

}
