package com.elizabeth.appConecta;

import com.elizabeth.appConecta.DTO.UsuarioDTO;
import com.elizabeth.appConecta.entidad.Usuario;
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
public class UsuarioServicioTest {

    @Autowired
    private UsuarioService usuarioServicio;

    @Test
    public void registrarUsuarioCorrectamente() {
        Usuario guardado = usuarioServicio.registrarUsuario("Ely Sanchez", 35, "Quito", true);
        Optional<Usuario> encontrado = usuarioServicio.obtenerUsuarioPorId(guardado.getIdUsuario());

        assertTrue(encontrado.isPresent());
        assertEquals("Ely Sanchez", encontrado.get().getNombre());
    }

    @Test
    public void actualizarRegistroUsuarioCorrectamente() {
        UsuarioDTO usuarioDTO = new UsuarioDTO("Ely Sanchez", null, 35, "Quito");

        Usuario usuarioActualizado = usuarioServicio.actualizarUsuario(1, usuarioDTO);

        Optional<Usuario> encontrado = usuarioServicio.obtenerUsuarioPorId(usuarioActualizado.getIdUsuario());

        assertEquals("Quito", encontrado.get().getCiudad());
    }

    @Test
    public void borrarUsuarioCorrectamente() {
        boolean usuarioBorrado = usuarioServicio.borrarUsuario(1);
        assertTrue(usuarioBorrado);
    }

    @Test
    public void listarUsuariosActivos() {
        List<Usuario> listaUsuariosActivos = usuarioServicio.obtenerTodosUsuariosActivos();

        listaUsuariosActivos.stream()
                .forEach(usuario -> System.out.println(usuario.getNombre()));
    }

}
