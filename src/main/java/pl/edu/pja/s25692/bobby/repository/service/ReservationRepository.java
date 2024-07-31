package pl.edu.pja.s25692.bobby.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pja.s25692.bobby.model.service.Reservation;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("from Reservation r left join fetch r.reservationService rs left join fetch rs.service where r.id = :id")
    Optional<Reservation> findByIdWithServices(Long id);
}
