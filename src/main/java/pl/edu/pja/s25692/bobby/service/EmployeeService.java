package pl.edu.pja.s25692.bobby.service;

import pl.edu.pja.s25692.bobby.dto.response.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
}
