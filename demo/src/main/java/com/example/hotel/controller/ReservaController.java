// src/main/java/com/exemplo/hotel/controller/ReservaController.java
package com.example.hotel.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.hotel.model.Reserva;
import com.example.hotel.service.ReservaService;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public Reserva criarReserva(@RequestBody Reserva reserva) {
        return reservaService.salvar(reserva);
    }

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Reserva buscarReserva(@PathVariable Long id) {
        return reservaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o id " + id));
    }

    @PutMapping("/{id}")
    public Reserva atualizarReserva(@PathVariable Long id, @RequestBody Reserva reservaAtualizada) {
        Reserva reserva = reservaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o id " + id));

        reserva.setNomeHospede(reservaAtualizada.getNomeHospede());
        reserva.setNumeroQuarto(reservaAtualizada.getNumeroQuarto());
        reserva.setDataCheckIn(reservaAtualizada.getDataCheckIn());
        reserva.setDataCheckOut(reservaAtualizada.getDataCheckOut());

        return reservaService.salvar(reserva);
    }

    @DeleteMapping("/{id}")
    public void deletarReserva(@PathVariable Long id) {
        reservaService.deletar(id);
    }
}
