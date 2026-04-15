package seguro.seguro.service;


import seguro.seguro.model.Hotel;
import seguro.seguro.repository.HotelRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel getById(Integer id) {
        return hotelRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Hotel con id " + id + " no existe"));
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel update(Integer id, Hotel request) {
        Hotel hotel = getById(id);
        hotel.setNombre(request.getNombre());
        hotel.setDireccion(request.getDireccion());
        hotel.setEstrellas(request.getEstrellas());
        hotel.setTelefono(request.getTelefono());
        return hotelRepository.save(hotel);
    }
}
