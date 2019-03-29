package es.leanmind.barbershop.integration;

import es.leanmind.barbershop.controller.Routes;
import es.leanmind.barbershop.controller.api.AppointmentController;
import es.leanmind.barbershop.controller.api.EstablishmentsController;
import es.leanmind.barbershop.domain.AppointmentDTO;
import es.leanmind.barbershop.domain.AppointmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = AppointmentController.class, secure = false)
public class ApiAppointmentControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentServiceStub;

    @Test
    public void create_appointment() throws Exception {
        String aName = "irrelevant username";
        String aDate = null;
        String aFreeDate = "irrelevant date";
        AppointmentDTO anAppointmentParams = new AppointmentDTO(aName, aDate);
        AppointmentDTO anAppointmentResult = new AppointmentDTO(aName, aFreeDate);
        given(appointmentServiceStub.create(any())).willReturn(anAppointmentResult);

        String expected = "{\"name\":"+ aName +", \"date\":\" " + aFreeDate +"\"}";;
        mockMvc.perform(post(Routes.appointment, anAppointmentParams))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

}
