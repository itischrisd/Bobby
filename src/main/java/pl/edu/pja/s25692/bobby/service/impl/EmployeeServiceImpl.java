package pl.edu.pja.s25692.bobby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s25692.bobby.dto.response.EmployeeDTO;
import pl.edu.pja.s25692.bobby.repository.employee.EmployeeRepository;
import pl.edu.pja.s25692.bobby.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .employeeNumber(employee.getEmployeeNumber())
                        .firstName(employee.getName())
                        .lastName(employee.getSurname())
                        .position(employee.getPosition().getName())
                        .build())
                .toList();
    }
}