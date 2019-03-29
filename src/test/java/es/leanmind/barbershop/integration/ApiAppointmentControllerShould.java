package es.leanmind.barbershop.integration;

import es.leanmind.barbershop.controller.api.EstablishmentsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = EstablishmentsController.class, secure = false)
public class ApiAppointmentControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create_appointment() throws Exception {
        Object anAppointmentParams = null;
        mockMvc.perform(post("/api/appointment", anAppointmentParams))
                .andExpect(status().isOk());

    }

}
