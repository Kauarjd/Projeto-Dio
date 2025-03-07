package com.example.hotel.controller;

import com.example.hotel.model.Reserva;
import com.example.hotel.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // Corrigido para jakarta.validation
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Operation(summary = "Criar uma nova reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva criarReserva(@Valid @RequestBody Reserva reserva) {
        return reservaService.salvar(reserva);
    }

    @Operation(summary = "Listar todas as reservas")
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarTodos();
    }

    @Operation(summary = "Buscar uma reserva por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    @GetMapping("/{id}")
    public Reserva buscarReserva(@PathVariable Long id) {
        return reservaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o id " + id));
    }

    @Operation(summary = "Atualizar uma reserva existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    @PutMapping("/{id}")
    public Reserva atualizarReserva(@PathVariable Long id, @Valid @RequestBody Reserva reservaAtualizada) {
        Reserva reserva = reservaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o id " + id));

        reserva.setNomeHospede(reservaAtualizada.getNomeHospede());
        reserva.setNumeroQuarto(reservaAtualizada.getNumeroQuarto());
        reserva.setDataCheckIn(reservaAtualizada.getDataCheckIn());
        reserva.setDataCheckOut(reservaAtualizada.getDataCheckOut());

        return reservaService.salvar(reserva);
    }

    @Operation(summary = "Deletar uma reserva por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarReserva(@PathVariable Long id) {
        reservaService.deletar(id);
    }
}