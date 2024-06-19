package com.hospedagem.Hotel.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@Table(name = "tb_reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant checkin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant checkout;


    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    public Reserva() {

    }

    public Reserva(Long id, Instant checkin, Instant checkout, Hotel hotel) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.hotel = hotel;
    }

}
