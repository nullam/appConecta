package com.elizabeth.appConecta;

import com.elizabeth.appConecta.servicio.PicoPlacaService;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class AppConectaApplicationTests {
    
    @Autowired
    private PicoPlacaService picoPlacaService;

    @Test
    void contextLoads() {
    }
    
    //Verificacion de circulacion fuera del horario de pico y placa
    @Test
    public void testAutoPuedeCircularFueraDePicoPlaca() {
        // Lunes, 5:00am (fuera de horario de restricción)
        LocalDateTime fechaHora = LocalDateTime.of(2024, 9, 23, 5, 0); 
        String placa = "ABC-1231"; // Placa termina en 1

        boolean puedeCircular = picoPlacaService.puedeCircular(placa, fechaHora);
        assertTrue(puedeCircular, "El vehículo debería poder circular fuera del horario de restricción");
    }

    //Verificacion no puede circular pico y placa en la mañana
    @Test
    public void testAutoTienePicoPlacaEnLaMañana() {
        // Lunes, 7:30am (dentro de horario de restricción)
        LocalDateTime fechaHora = LocalDateTime.of(2024, 9, 23, 7, 30); 
        String placa = "ABC-1231"; // Placa termina en 1

        boolean puedeCircular = picoPlacaService.puedeCircular(placa, fechaHora);
        assertFalse(puedeCircular, "El vehículo no debería poder circular en horario de restricción");
    }

    //Verifica la libre circulacion en fin de semana
    @Test
    public void testAutoPuedeCircularFinSemana() {
        // Sábado, 10:00am (sin restricción en fin de semana)
        LocalDateTime fechaHora = LocalDateTime.of(2024, 9, 21, 10, 0); 
        String placa = "ABC-1231"; // Placa termina en 1

        boolean puedeCircular = picoPlacaService.puedeCircular(placa, fechaHora);
        assertTrue(puedeCircular, "El vehículo debería poder circular en fines de semana");
    }

    //Verifica la restriccion de pico y placa en la tarde
    @Test
    public void testAutoTienePicoPlacaEnLaTarde() {
        // Lunes, 16:30pm (dentro de horario de restricción)
        LocalDateTime fechaHora = LocalDateTime.of(2024, 9, 23, 16, 30); 
        String placa = "ABC-1232"; // Placa termina en 2

        boolean puedeCircular = picoPlacaService.puedeCircular(placa, fechaHora);
        assertFalse(puedeCircular, "El vehículo no debería poder circular en horario de restricción de la tarde");
    }

}
