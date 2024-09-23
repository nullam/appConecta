package com.elizabeth.appConecta.servicio;

import com.elizabeth.appConecta.DTO.AutoDTO;
import com.elizabeth.appConecta.entidad.Auto;
import com.elizabeth.appConecta.entidad.Usuario;
import com.elizabeth.appConecta.repositorio.AutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ElySanchez
 */
@Service
public class AutoService {

    private final AutoRepository autoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    /**
     *
     * @param idUsuario
     * @param marca
     * @param placa
     * @param modelo
     * @param chasis
     * @param color
     * @param estado
     * @return
     */
    @Transactional
    public Auto registrarAuto(Integer idUsuario, String marca, String placa, String modelo, String chasis, String color, boolean estado) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario).get();

        Auto auto = new Auto(placa, marca, modelo, chasis, color, estado);
        auto.setIdUsuario(usuario);
        return autoRepository.save(auto);
    }

    /**
     * Actualiza el registro de un auto
     *
     * @param idAuto
     * @param autoDTO
     * @return Auto
     */
    @Transactional
    public Auto actualizarAuto(Integer idAuto, AutoDTO autoDTO) {
        Auto autoExistente = autoRepository.findById(idAuto).orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        if (autoDTO.getChasis() != null && !autoDTO.getChasis().isBlank() && !autoDTO.getChasis().isEmpty()) {
            autoExistente.setChasis(autoDTO.getChasis());
        }

        if (autoDTO.getColor() != null && !autoDTO.getColor().isBlank() && !autoDTO.getColor().isEmpty()) {
            autoExistente.setColor(autoDTO.getColor());
        }

        if (autoDTO.getMarca() != null && !autoDTO.getMarca().isBlank() && !autoDTO.getMarca().isEmpty()) {
            autoExistente.setMarca(autoDTO.getMarca());
        }

        if (autoDTO.getPlaca() != null && !autoDTO.getPlaca().isBlank() && !autoDTO.getPlaca().isEmpty()) {
            autoExistente.setPlaca(autoDTO.getPlaca());
        }

        if (autoDTO.getModelo() != null && !autoDTO.getModelo().isBlank() && !autoDTO.getModelo().isEmpty()) {
            autoExistente.setModelo(autoDTO.getModelo());
        }

        return autoRepository.save(autoExistente);
    }

    /**
     * Lista todos los autos registrados
     *
     * @return List
     */
    public List<Auto> obtenerTodosAuto() {
        return autoRepository.findAll();
    }

    /**
     * Obtener un auto por identificador
     *
     * @param idAuto
     * @return Optional
     */
    public Optional<Auto> obtenerAutoPorId(Integer idAuto) {
        return autoRepository.findById(idAuto);
    }
}
