package pl.edu.pja.s25692.bobby.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pja.s25692.bobby.model.service.Service;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("from Service s left join fetch s.reservationService rs left join fetch rs.reservation where s.id = :id")
    Optional<Service> findByIdWithReservations(Long id);
}
