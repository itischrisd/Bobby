package pl.edu.pja.s25692.bobby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s25692.bobby.dto.response.ReservationDTO;
import pl.edu.pja.s25692.bobby.dto.response.ReservationWithServicesDTO;
import pl.edu.pja.s25692.bobby.dto.response.ServiceDTO;
import pl.edu.pja.s25692.bobby.exception.DomainException;
import pl.edu.pja.s25692.bobby.model.employee.Employee;
import pl.edu.pja.s25692.bobby.model.service.Reservation;
import pl.edu.pja.s25692.bobby.repository.employee.EmployeeRepository;
import pl.edu.pja.s25692.bobby.repository.service.ReservationRepository;
import pl.edu.pja.s25692.bobby.service.ReservationService;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, EmployeeRepository employeeRepository) {
        this.reservationRepository = reservationRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public ReservationDTO findById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new DomainException(
                "Brak Rezerwacji",
                "Nie znaleziono rezerwacji o id: " + id));

        return ReservationDTO.builder()
                .id(reservation.getId())
                .number(reservation.getNumber())
                .submissionDate(reservation.getSubmissionDate())
                .plannedStartDate(reservation.getPlannedStartDate())
                .status(reservation.getStatus())
                .build();
    }

    @Override
    public ReservationWithServicesDTO findByIdWithServices(Long id) {
        Reservation reservation = reservationRepository.findByIdWithServices(id).orElseThrow(() -> new DomainException(
                "Brak Rezerwacji",
                "Nie znaleziono rezerwacji o id: " + id));

        return ReservationWithServicesDTO.builder()
                .id(reservation.getId())
                .number(reservation.getNumber())
                .submissionDate(reservation.getSubmissionDate())
                .plannedStartDate(reservation.getPlannedStartDate())
                .status(reservation.getStatus())
                .services(reservation.getReservationService().stream()
                        .map(pl.edu.pja.s25692.bobby.model.service.ReservationService::getService)
                        .map(service -> ServiceDTO.builder()
                                .id(service.getId())
                                .name(service.getName())
                                .description(service.getDescription())
                                .expectedTime(service.getExpectedTime())
                                .isDoneOffsite(service.isDoneOffsite())
                                .build())
                        .toList())
                .build();
    }

    @Override
    public void assignEmployeeToReservation(Long reservationId, Long employeeId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new DomainException(
                "Brak Rezerwacji",
                "Wybrana rezerwacja nie istnieje"));

        Employee employee = employeeRepository.findByIdWithReservations(employeeId).orElseThrow(() -> new DomainException(
                "Brak Pracownika",
                "Wybrany pracownik nie istnieje"));

        if (employee.getReservations().stream().anyMatch(r -> r.getPlannedStartDate().equals(reservation.getPlannedStartDate()))) {
            throw new DomainException(
                    "Brak Dostępności Pracownika",
                    "Pracownik nie jest dostępny w planowanym terminie.",
                    "Wybierz innego pracownika",
                    "/employees/for-reservation?reservationId=" + reservationId);
        }

        if (!reservation.getStatus().equals(Reservation.Status.SUBMITTED)) {
            throw new DomainException(
                    "Rezerwacja nie oczekuje na przypisanie pracownika",
                    "Nie można przypisać pracownika do rezerwacji, która nie oczekuje na przypisanie pracownika",
                    "Powrót do strony rezerwacji",
                    "/reservations");
        }

        reservation.assignEmployee(employee);
        reservationRepository.save(reservation);
    }

    @Override
    public List<ReservationDTO> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();

        if (reservations.isEmpty()) {
            throw new DomainException(
                    "Brak Rezerwacji",
                    "Nie znaleziono żadnych rezerwacji",
                    "Dodaj nową rezerwację",
                    "/reservations/add");
        }

        return reservations.stream()
                .map(reservation -> ReservationDTO.builder()
                        .id(reservation.getId())
                        .number(reservation.getNumber())
                        .submissionDate(reservation.getSubmissionDate())
                        .plannedStartDate(reservation.getPlannedStartDate())
                        .status(reservation.getStatus())
                        .build())
                .toList();
    }
}
