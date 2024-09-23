package com.elizabeth.appConecta;

import com.elizabeth.appConecta.controlador.UsuarioController;
import com.elizabeth.appConecta.servicio.UsuarioService;
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
@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    @Disabled
    public void creacionUsuarioCorrecta() throws Exception {
//        Auto autoNuevo = new Auto(1, "PFR-1234", "asdasd", "Fabia", "POAQ121795032", "Verde", true);

//        when(autoService.registrarAuto(1, "asdasd", "Skoda", "Fabia", "POAQ121795032", "Verde", true)).thenReturn(autoNuevo);

        String usuarioJson = "{"
                + "\"nombre\":\"pruebaUser\","
                + "\"edad\":35,"
                + "\"ciudad\":\"Quito\","
                + "\"estado\":\"true\""
                + "}";

        mockMvc.perform(post("/auto")
                .contentType("application/json")
                .content(usuarioJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.marca").value("asdasd"));

        verify(usuarioService).registrarUsuario("Prueba", 28, "Quito", true);
    }

}
