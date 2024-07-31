package pl.edu.pja.s25692.bobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pja.s25692.bobby.dto.response.ReservationWithServicesDTO;
import pl.edu.pja.s25692.bobby.service.ReservationService;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationService.findAll());
        return "reservations";
    }

    @GetMapping("/reservations/{id}")
    public String reservation(Model model, @PathVariable Long id) {
        ReservationWithServicesDTO reservation = reservationService.findByIdWithServices(id);
        model.addAttribute("reservation", reservation);
        return "reservation-details";
    }

    @PostMapping("/reservations/assign-employee")
    public String assignEmployeeToReservation(@RequestParam Long reservationId, @RequestParam Long employeeId) {
        reservationService.assignEmployeeToReservation(reservationId, employeeId);
        return "assign-employee-success";
    }
}
