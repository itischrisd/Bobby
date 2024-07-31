package pl.edu.pja.s25692.bobby.service;

import pl.edu.pja.s25692.bobby.dto.response.ServiceDTO;
import pl.edu.pja.s25692.bobby.dto.response.ServiceWithReservationsDTO;

import java.util.List;

public interface ServiceService {

    List<ServiceDTO> findAll();

    ServiceDTO findById(Long id);

    ServiceWithReservationsDTO findByIdWithReservations(Long id);
}
