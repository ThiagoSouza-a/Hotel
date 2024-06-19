package com.hospedagem.Hotel.config;


import com.hospedagem.Hotel.entities.Hotel;
import com.hospedagem.Hotel.entities.Reserva;
import com.hospedagem.Hotel.repositories.HotelRepository;
import com.hospedagem.Hotel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservaRepository reservaRepository;


    @Override
    public void run(String... args) throws Exception {

        Hotel h1 = new Hotel(null, "Hotel A", "Blumenau - SC", 4);
        Hotel h2 = new Hotel(null, "Hotel B", "Gaspar - SC", 6);

        Reserva r1 = new Reserva(null, Instant.parse("2024-06-20T00:00:00Z"),Instant.parse("2024-06-24T00:00:00Z"), h1);
        Reserva r2 = new Reserva(null, Instant.parse("2024-07-21T00:00:00Z"),Instant.parse("2024-07-23T00:00:00Z"), h2);
        Reserva r3 = new Reserva(null, Instant.parse("2024-07-22T00:00:00Z"), Instant.parse("2024-07-24T00:00:00Z"), h1);

        hotelRepository.saveAll(Arrays.asList(h1, h2));

        reservaRepository.saveAll(Arrays.asList(r1, r2, r3));

    }
}
