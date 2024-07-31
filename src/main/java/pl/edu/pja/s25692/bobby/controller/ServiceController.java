package pl.edu.pja.s25692.bobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.pja.s25692.bobby.dto.response.ServiceDTO;
import pl.edu.pja.s25692.bobby.dto.response.ServiceWithReservationsDTO;
import pl.edu.pja.s25692.bobby.service.ServiceService;

import java.util.List;

@Controller
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/services")
    public String services(Model model) {
        List<ServiceDTO> services = serviceService.findAll();
        model.addAttribute("services", services);
        return "services";
    }

    @GetMapping("/services/{id}")
    public String service(Model model, @PathVariable Long id) {
        ServiceDTO service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "service-details";
    }

    @GetMapping("/services/{id}/reservations")
    public String serviceReservations(Model model, @PathVariable Long id) {
        ServiceWithReservationsDTO service = serviceService.findByIdWithReservations(id);
        model.addAttribute("service", service);
        return "service-reservations";
    }
}
