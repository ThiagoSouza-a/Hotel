package com.hospedagem.Hotel.config;


import com.hospedagem.Hotel.entities.Hotel;
import com.hospedagem.Hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public void run(String... args) throws Exception {

        Hotel h1 = new Hotel(null, "Hotel A", "Blumenau - SC", 4);
        Hotel h2 = new Hotel(null, "Hotel B", "Gaspar - SC", 6);

        hotelRepository.saveAll(Arrays.asList(h1, h2));

    }
}
