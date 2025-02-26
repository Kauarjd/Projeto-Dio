// src/main/java/com/exemplo/hotel/service/ReservaService.java
package com.example.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotel.repository.ReservaRepository;
import com.example.hotel.model.Reserva;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva salvar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public void deletar(Long id) {
        reservaRepository.deleteById(id);
    }
}
