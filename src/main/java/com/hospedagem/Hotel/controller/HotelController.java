package com.hospedagem.Hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospedagem.Hotel.entities.Hotel;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

//    @GetMapping("/all")
//    public ResponseEntity<List<Hotel>> findAll() {
//        List<Hotel> hotels = new ArrayList<>();
//        hotels.add(new Hotel(1L, "Hotel A", "Rua A", 4));
//        hotels.add(new Hotel(2L, "Hotel B", "Rua B", 5));
//        return ResponseEntity.ok().body(hotels);
//    }
	
	@GetMapping("/all")
    public ResponseEntity<Hotel> findAll() {
        Hotel h = new Hotel(1L, "Hotel A", "Rua A", 4);
        return ResponseEntity.ok().body(h);
    }
}
