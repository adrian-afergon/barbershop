package es.leanmind.barbershop.integration;

import es.leanmind.barbershop.Configuration;
import es.leanmind.barbershop.domain.AppointmentDTO;
import es.leanmind.barbershop.domain.AppointmentService;
import es.leanmind.barbershop.domain.EstablishmentService;
import es.leanmind.barbershop.helpers.IntegrationTests;
import es.leanmind.barbershop.helpers.TestFactory;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ApiAppointmentServiceShould extends IntegrationTests {



    @Test
    public void make_the_first_appointment () {

        AppointmentService appointmentService = TestFactory.establishmentService(Configuration.connectionTestDatabase);

        String aName = "irrelevant name";
        String aDate = "irrelevant date";
        AppointmentDTO anAppointment = new AppointmentDTO(aName, null);
        AppointmentDTO newAppointment = appointmentService.create(anAppointment);
        AppointmentDTO expectedAppointment = new AppointmentDTO(aName, aDate);

        assertThat(newAppointment).isEqualTo(expectedAppointment);
    }

    @Test
    public void make_the_next_appointment_available () {

    }

}
