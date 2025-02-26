// src/main/java/com/exemplo/hotel/model/Reserva.java
package com.example.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeHospede;
    private Integer numeroQuarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public Reserva() {
    }

    public Reserva(String nomeHospede, Integer numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.nomeHospede = nomeHospede;
        this.numeroQuarto = numeroQuarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeHospede() {
        return nomeHospede;
    }
    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }
    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }
    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }
    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }
    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}
