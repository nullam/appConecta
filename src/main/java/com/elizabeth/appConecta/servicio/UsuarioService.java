package com.elizabeth.appConecta.servicio;

import com.elizabeth.appConecta.DTO.UsuarioDTO;
import com.elizabeth.appConecta.entidad.Usuario;
import com.elizabeth.appConecta.repositorio.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ElySanchez
 * @
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Registra un nuevo usuario en el sistema
     *
     * @param nombre
     * @param edad
     * @param ciudad
     * @param estado
     * @return
     */
    @Transactional
    public Usuario registrarUsuario(String nombre, Integer edad, String ciudad, boolean estado) {
        Usuario usuario = new Usuario(nombre, estado, edad, ciudad);
        return usuarioRepository.save(usuario);
    }

    /**
     * Actualiza el registro de un usuario
     *
     * @param idUsuario
     * @param usuarioDTO
     * @return
     */
    @Transactional
    public Usuario actualizarUsuario(Integer idUsuario, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        //TODO:validar que los valores ingresados no sean valores en blanco
        if (usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isBlank() && !usuarioDTO.getNombre().isEmpty()) {
            usuarioExistente.setNombre(usuarioDTO.getNombre());
        }

        if (usuarioDTO.getEdad() != null) {
            usuarioExistente.setEdad(usuarioDTO.getEdad());
        }

        if (usuarioDTO.getCiudad() != null && !usuarioDTO.getCiudad().isBlank() && !usuarioDTO.getCiudad().isEmpty()) {
            usuarioExistente.setCiudad(usuarioDTO.getCiudad());
        }
        return usuarioRepository.save(usuarioExistente);
    }

    /**
     * Obtiene el registro de un usuario por su identificador
     *
     * @param idUsuario
     * @return
     */
    public Optional<Usuario> obtenerUsuarioPorId(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    /**
     * Desactiva el usuario dentro del sistema
     *
     * @param idUsuario
     * @return
     */
    @Transactional
    public boolean borrarUsuario(Integer idUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setEstado(false);

        usuarioRepository.save(usuarioExistente);
        return true;
    }

    /**
     * Lista todos los usuarios registrados en el sistema
     *
     * @return
     */
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Listar usuarios activos
     *
     * @return
     */
    public List<Usuario> obtenerTodosUsuariosActivos() {
        return usuarioRepository.findByEstadoTrue();
    }

}
