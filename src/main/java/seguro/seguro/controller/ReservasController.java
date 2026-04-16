package seguro.seguro.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seguro.seguro.model.Reservas;
import seguro.seguro.service.ReservasService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {

    private final ReservasService reservasService;

    public ReservasController(ReservasService reservaService) {
        this.reservasService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<Reservas>> getAll() {
        return ResponseEntity.ok(reservasService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservas> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(reservasService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Reservas> create(@Valid @RequestBody Reservas reserva) {
        Reservas nuevaReserva = reservasService.create(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservas> update(@PathVariable Integer id, @Valid @RequestBody Reservas reserva) {
        Reservas reservaActualizada = reservasService.update(id, reserva);
        return ResponseEntity.ok(reservaActualizada);
    }
}