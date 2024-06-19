package com.hospedagem.Hotel.services;

import com.hospedagem.Hotel.entities.Hotel;
import com.hospedagem.Hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;

    public List<Hotel> findAll() {
        return repository.findAll();
    }


}
