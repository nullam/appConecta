package com.elizabeth.appConecta;

import com.elizabeth.appConecta.controlador.AutoController;
import com.elizabeth.appConecta.entidad.Auto;
import com.elizabeth.appConecta.servicio.AutoService;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 * @author ElySanchez
 */
@WebMvcTest(AutoController.class)
public class AutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutoService autoService;

    @Test
    public void testObtenerAutoId() throws Exception {
        Auto mockAuto = new Auto(1, "PFR-7376", "Chevrolet", "Spark", "HAQ17395032LF", "Azul", true);
        when(autoService.obtenerAutoPorId(1)).thenReturn(Optional.of(mockAuto));

        mockMvc.perform(get("/auto/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Chevrolet"));

        verify(autoService).obtenerAutoPorId(1);
    }

    @Test
    @Disabled
    public void creacionAutoCorrecta() throws Exception {
        Auto autoNuevo = new Auto(1, "PFR-1234", "asdasd", "Fabia", "POAQ121795032", "Verde", true);

        when(autoService.registrarAuto(1, "asdasd", "Skoda", "Fabia", "POAQ121795032", "Verde", true)).thenReturn(autoNuevo);

        String autoJson = "{"
                + "\"placa\":\"ABS-4321\","
                + "\"marca\":\"asdasd\","
                + "\"modelo\":\"asdad\","
                + "\"chasis\":\"asdad\","
                + "\"color\":\"asdad\","
                + "\"estado\":\"true\","
                + "\"idUsuario\":1"
                + "}";

        mockMvc.perform(post("/auto")
                .contentType("application/json")
                .content(autoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.marca").value("asdasd"));

        verify(autoService).registrarAuto(1, "asdasd", "Skoda", "Fabia", "POAQ121795032", "Verde", true);
    }

}
