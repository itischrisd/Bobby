package pl.edu.pja.s25692.bobby.dto.response;

import lombok.Builder;

@Builder
public record ServiceDTO(
        Long id,
        String name,
        String description,
        int expectedTime,
        boolean isDoneOffsite) {
}
