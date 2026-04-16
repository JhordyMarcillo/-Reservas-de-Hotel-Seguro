package seguro.seguro.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import seguro.seguro.model.Cliente;
import seguro.seguro.model.Hotel;
import seguro.seguro.model.Reservas;
import seguro.seguro.repository.HotelRepository;
import seguro.seguro.repository.ReservasRepository;

import java.util.List;

@Service
public class ReservasService {
    private final ReservasRepository reservaRepository;
    private final HotelService hotelService;
    private final ClienteService clienteService;

    public ReservasService(ReservasRepository reservaRepository, HotelService hotelService, ClienteService clienteService) {
        this.reservaRepository = reservaRepository;
        this.hotelService = hotelService;
        this.clienteService = clienteService;
    }

    public List<Reservas> getAll() {
        return reservaRepository.findAll();
    }

    public Reservas getById(Integer id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
    }

    public Reservas create(Reservas reserva) {
        Hotel hotelCompleto = hotelService.getById(reserva.getHotel().getId());
        Cliente clienteCompleto = clienteService.getById(reserva.getCliente().getId());
        reserva.setHotel(hotelCompleto);
        reserva.setCliente(clienteCompleto);
        return reservaRepository.save(reserva);
    }

    public Reservas update(Integer id, Reservas request) {
        Reservas reserva = getById(id);

        Hotel hotelCompleto = hotelService.getById(request.getHotel().getId());
        Cliente clienteCompleto = clienteService.getById(request.getCliente().getId());

        reserva.setFechaEntrada(request.getFechaEntrada());
        reserva.setFechaSalida(request.getFechaSalida());
        reserva.setNumHuespedes(request.getNumHuespedes());
        reserva.setHotel(hotelCompleto);
        reserva.setCliente(clienteCompleto);

        return reservaRepository.save(reserva);
    }
}
