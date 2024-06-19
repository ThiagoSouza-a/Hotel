package com.hospedagem.Hotel.controller;

import com.hospedagem.Hotel.entities.Reserva;
import com.hospedagem.Hotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() {
        List<Reserva> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id) {
        Reserva obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping(value = "/solicitar")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva novaReserva) {
        Reserva obj = service.createReserva(novaReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }



}
