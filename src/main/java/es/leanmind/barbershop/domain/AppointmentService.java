package es.leanmind.barbershop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    public AppointmentService() {
    }

    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        throw new Error("Not implemented");
    }

}
