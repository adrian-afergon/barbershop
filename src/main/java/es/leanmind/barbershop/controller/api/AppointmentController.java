package es.leanmind.barbershop.controller.api;

import es.leanmind.barbershop.controller.Routes;
import es.leanmind.barbershop.domain.AppointmentDTO;
import es.leanmind.barbershop.domain.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping (path = Routes.appointment)
    public AppointmentDTO createAppointment(AppointmentDTO appointment) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            String username = (String) authentication.getPrincipal();
            return appointmentService.create(appointment);
//        }
//        return null;
    }

}
