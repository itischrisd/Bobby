package pl.edu.pja.s25692.bobby.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ServiceWithReservationsDTO(
        Long id,
        String name,
        String description,
        int expectedTime,
        boolean isDoneOffsite,
        List<ReservationDTO> reservations) {
}
