package com.elizabeth.appConecta;

import com.elizabeth.appConecta.DTO.AutoDTO;
import com.elizabeth.appConecta.entidad.Auto;
import com.elizabeth.appConecta.entidad.Usuario;
import com.elizabeth.appConecta.servicio.AutoService;
import com.elizabeth.appConecta.servicio.UsuarioService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author ElySanchez
 */
@SpringBootTest
@ActiveProfiles("test")
public class AutoServicioTest {

    @Autowired
    private AutoService autoService;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void registrarAutoCorrectamente() {
        List<Usuario> usuariosActivos = usuarioService.obtenerTodosUsuariosActivos();
        if (!usuariosActivos.isEmpty()) {
            Auto guardado = autoService.registrarAuto(usuariosActivos.get(0).getIdUsuario(), "Cherry", "ADF-1234", "Tyggo 7 pro", "AD12762GF43785", "Rojo", true);
            Optional<Auto> encontrado = autoService.obtenerAutoPorId(guardado.getIdAuto());

            assertTrue(encontrado.isPresent());
            assertEquals("ADF-1234", encontrado.get().getPlaca());
        }
    }

    @Test
    public void actualizarRegistroAutoCorrectamente() {
        AutoDTO autoDTO = new AutoDTO("", "Renault", null, "", null, true);

        Auto autoActualizado = autoService.actualizarAuto(1, autoDTO);

        Optional<Auto> encontrado = autoService.obtenerAutoPorId(autoActualizado.getIdAuto());

        assertTrue(encontrado.isPresent());
        assertEquals("Renault", encontrado.get().getMarca());
    }

}
