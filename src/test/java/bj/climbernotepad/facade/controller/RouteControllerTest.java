package bj.climbernotepad.facade.controller;

import bj.climbernotepad.business.Route;
import bj.climbernotepad.business.RouteService;
import bj.climbernotepad.facade.RouteDTO;
import bj.climbernotepad.facade.converter.RouteConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteController.class)
public class RouteControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RouteService routeService;

    @Test
    @Ignore("Deserialication of finished field in RouteDto fails due to LocalDate type")
    public void shouldAddRoute() throws Exception {

        RouteDTO routeDTO = new RouteDTO("Znikajacy punkt", "7a+/7b", "Sokoliki", "Sukiennice", LocalDate.now());
        Route route = RouteConverter.INSTANCE.fromDto(routeDTO);

        mockMvc.perform(
                post("/routes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(routeDTO)))
                .andExpect(status().isOk());

        verify(routeService).save(route);
    }
}