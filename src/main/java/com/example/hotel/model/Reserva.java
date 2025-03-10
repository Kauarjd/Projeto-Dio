package com.example.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do hóspede é obrigatório")
    private String nomeHospede;

    @NotNull(message = "O número do quarto é obrigatório")
    @Min(value = 1, message = "O número do quarto deve ser maior que 0")
    private Integer numeroQuarto;

    @NotNull(message = "A data de check-in é obrigatória")
    private LocalDate dataCheckIn;

    @NotNull(message = "A data de check-out é obrigatória")
    private LocalDate dataCheckOut;

    @AssertTrue(message = "A data de check-out deve ser posterior à data de check-in")
    private boolean isDataCheckOutValida() {
        return dataCheckOut == null || dataCheckIn == null || dataCheckOut.isAfter(dataCheckIn);
    }
}