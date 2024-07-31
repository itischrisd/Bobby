package pl.edu.pja.s25692.bobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pja.s25692.bobby.dto.response.EmployeeDTO;
import pl.edu.pja.s25692.bobby.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/for-reservation")
    public String listEmployeesForReservation(@RequestParam Long reservationId, Model model) {
        List<EmployeeDTO> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("reservationId", reservationId);
        return "employees-for-reservation";
    }
}