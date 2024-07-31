package pl.edu.pja.s25692.bobby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pja.s25692.bobby.dto.response.ReservationDTO;
import pl.edu.pja.s25692.bobby.dto.response.ServiceDTO;
import pl.edu.pja.s25692.bobby.dto.response.ServiceWithReservationsDTO;
import pl.edu.pja.s25692.bobby.exception.DomainException;
import pl.edu.pja.s25692.bobby.model.service.ReservationService;
import pl.edu.pja.s25692.bobby.model.service.Service;
import pl.edu.pja.s25692.bobby.repository.service.ServiceRepository;
import pl.edu.pja.s25692.bobby.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceDTO> findAll() {
        List<Service> services = serviceRepository.findAll();

        if (services.isEmpty()) {
            throw new DomainException(
                    "Brak Usług",
                    "W systemie nie znajdują się żadne usługi.",
                    "Dodaj usługę",
                    "/"
            );
        }

        return services.stream()
                .map(service -> ServiceDTO.builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .expectedTime(service.getExpectedTime())
                        .isDoneOffsite(service.isDoneOffsite())
                        .build()).toList();
    }

    @Override
    public ServiceDTO findById(Long id) {
        Service service = serviceRepository.findById(id).orElseThrow(() -> new DomainException("Brak Usługi", "Nie znaleziono usługi o id: " + id));
        return ServiceDTO.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .expectedTime(service.getExpectedTime())
                .isDoneOffsite(service.isDoneOffsite())
                .build();
    }

    @Override
    public ServiceWithReservationsDTO findByIdWithReservations(Long id) {
        Service service = serviceRepository.findByIdWithReservations(id).orElseThrow(() -> new DomainException("Brak Usługi", "Nie znaleziono usługi o id: " + id));

        if (service.getReservationService().isEmpty()) {
            throw new DomainException(
                    "Brak Rezerwacji",
                    "W systemie nie znajdują się rezerwacje zawierające daną usługę.",
                    "Powrót do listy usług",
                    "/services"
            );
        }

        return ServiceWithReservationsDTO.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .expectedTime(service.getExpectedTime())
                .isDoneOffsite(service.isDoneOffsite())
                .reservations(service.getReservationService().stream()
                        .map(ReservationService::getReservation)
                        .map(reservation -> ReservationDTO.builder()
                                .id(reservation.getId())
                                .number(reservation.getNumber())
                                .submissionDate(reservation.getSubmissionDate())
                                .plannedStartDate(reservation.getPlannedStartDate())
                                .status(reservation.getStatus())
                                .build())
                        .toList())
                .build();
    }
}
