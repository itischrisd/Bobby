package pl.edu.pja.s25692.bobby.dto.response;

import lombok.Builder;

@Builder
public record EmployeeDTO(
        Long id,
        String employeeNumber,
        String firstName,
        String lastName,
        String position) {
}
