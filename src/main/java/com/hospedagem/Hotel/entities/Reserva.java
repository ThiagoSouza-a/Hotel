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
import java.time.LocalDate;


@Entity
@Data
@Table(name = "tb_reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkin;

    private LocalDate checkout;


    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    public Reserva() {

    }

    public Reserva(Long id, LocalDate checkin, LocalDate checkout, Hotel hotel) {
        validateDates(checkin, checkout);
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.hotel = hotel;
    }

    public void updateDates(LocalDate checkin, LocalDate checkout) {
        validateDates(checkin, checkout);
        this.checkin = checkin;
        this.checkout = checkout;
    }

    private void validateDates(LocalDate checkin, LocalDate checkout) {
        LocalDate now = LocalDate.now();
        if (checkin.isBefore(now) || checkout.isBefore(now)) {
            throw new IllegalArgumentException("Para que possa atualizar a reserva, informe uma data futura");
        }
        if (!checkout.isAfter(checkin)) {
            throw new IllegalArgumentException("A data de checkout deve ser posterior a data de checkin");
        }
    }



}
