package com.hospedagem.Hotel.config;


import com.hospedagem.Hotel.entities.Hotel;
import com.hospedagem.Hotel.entities.Reserva;
import com.hospedagem.Hotel.repositories.HotelRepository;
import com.hospedagem.Hotel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservaRepository reservaRepository;


    @Override
    public void run(String... args) throws Exception {

        Hotel h1 = new Hotel(null, "Hotel A", "Blumenau - SC", 4);
        Hotel h2 = new Hotel(null, "Hotel B", "Gaspar - SC", 6);

        Reserva r1 = new Reserva(null, LocalDate.parse("2024-06-20"),LocalDate.parse("2024-06-22"), h1);
        Reserva r2 = new Reserva(null, LocalDate.parse("2024-04-10"),LocalDate.parse("2024-04-15"), h2);
        Reserva r3 = new Reserva(null, LocalDate.parse("2024-04-16"),LocalDate.parse("2024-04-18"), h1);

        hotelRepository.saveAll(Arrays.asList(h1, h2));

        reservaRepository.saveAll(Arrays.asList(r1, r2, r3));

    }
}
