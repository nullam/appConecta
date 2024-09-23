package com.elizabeth.appConecta.controlador;

import com.elizabeth.appConecta.DTO.AutoDTO;
import com.elizabeth.appConecta.entidad.Auto;
import com.elizabeth.appConecta.servicio.AutoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 *
 * @author ElySanchez
 */
@RestController
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public ResponseEntity<List<Auto>> obtenerTodosAutos() {
        List<Auto> autos = autoService.obtenerTodosAuto();
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    @GetMapping("/{idAuto}")
    public ResponseEntity<Auto> obtenerAutoPorId(@PathVariable Integer idAuto) {
        Optional<Auto> auto = autoService.obtenerAutoPorId(idAuto);
        return auto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Auto> crearAuto(@Valid @RequestBody AutoDTO autoDTO) {
        try {
            Auto nuevoAuto = autoService.registrarAuto(autoDTO.getIdUsuario().getIdUsuario(), autoDTO.getMarca(), autoDTO.getPlaca(), autoDTO.getModelo(), autoDTO.getChasis(), autoDTO.getColor(), true);
            //return ResponseEntity.ok(nuevoAuto);
            return new ResponseEntity<>(nuevoAuto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Actualizar un auto existente
    @PutMapping("/{idAuto}")
    public ResponseEntity<Auto> actualizarAuto(@PathVariable Integer idAuto, @RequestBody AutoDTO autoActualizado) {

        try {
            Auto auto = autoService.actualizarAuto(idAuto, autoActualizado);
            return ResponseEntity.ok(auto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
