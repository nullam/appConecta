package com.elizabeth.appConecta.repositorio;

import com.elizabeth.appConecta.entidad.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ElySanchez
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Lista los usuarios ACTIVOS del sistema
    List<Usuario> findByEstadoTrue();
}
