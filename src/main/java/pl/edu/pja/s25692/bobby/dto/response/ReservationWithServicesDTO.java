package pl.edu.pja.s25692.bobby.dto.response;

import lombok.Builder;
import pl.edu.pja.s25692.bobby.model.service.Reservation;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ReservationWithServicesDTO(
        Long id,
        String number,
        LocalDate submissionDate,
        LocalDate plannedStartDate,
        Reservation.Status status,
        List<ServiceDTO> services) {
}
