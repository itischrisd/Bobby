package pl.edu.pja.s25692.bobby.service;

import pl.edu.pja.s25692.bobby.dto.response.ReservationDTO;
import pl.edu.pja.s25692.bobby.dto.response.ReservationWithServicesDTO;

import java.util.List;

public interface ReservationService {

    ReservationDTO findById(Long id);

    ReservationWithServicesDTO findByIdWithServices(Long id);

    void assignEmployeeToReservation(Long reservationId, Long employeeId);

    List<ReservationDTO> findAll();
}
