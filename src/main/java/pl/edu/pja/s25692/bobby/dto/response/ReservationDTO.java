package pl.edu.pja.s25692.bobby.dto.response;

import lombok.Builder;
import pl.edu.pja.s25692.bobby.model.service.Reservation;

import java.time.LocalDate;

@Builder
public record ReservationDTO(
        Long id,
        String number,
        LocalDate submissionDate,
        LocalDate plannedStartDate,
        Reservation.Status status) {
}
