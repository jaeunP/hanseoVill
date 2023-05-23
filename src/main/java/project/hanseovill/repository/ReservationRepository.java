package project.hanseovill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hanseovill.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
