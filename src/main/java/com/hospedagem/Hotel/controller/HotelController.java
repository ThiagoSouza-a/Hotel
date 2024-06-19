package com.hospedagem.Hotel.controller;

import com.hospedagem.Hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospedagem.Hotel.entities.Hotel;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

	@GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        List<Hotel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
