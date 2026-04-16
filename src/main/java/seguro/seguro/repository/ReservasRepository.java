package seguro.seguro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seguro.seguro.model.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {
}
