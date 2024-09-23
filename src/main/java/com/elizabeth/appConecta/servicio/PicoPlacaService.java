package com.elizabeth.appConecta.servicio;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author ElySanchez
 */
@Service
public class PicoPlacaService {

    // Mapa de restricciones por día de la semana
    private final Map<Integer, int[]> restriccionesPorDia = new HashMap<>();

    // Horarios de restricción (mañana y tarde)
    private final LocalTime horaInicioManana = LocalTime.of(6, 0);
    private final LocalTime horaFinManana = LocalTime.of(9, 30);
    private final LocalTime horaInicioTarde = LocalTime.of(16, 0);
    private final LocalTime horaFinTarde = LocalTime.of(21, 0);

    public PicoPlacaService() {
        // Inicializar las restricciones por día de la semana
        restriccionesPorDia.put(1, new int[]{1, 2}); // Lunes: 1 y 2
        restriccionesPorDia.put(2, new int[]{3, 4}); // Martes: 3 y 4
        restriccionesPorDia.put(3, new int[]{5, 6}); // Miércoles: 5 y 6
        restriccionesPorDia.put(4, new int[]{7, 8}); // Jueves: 7 y 8
        restriccionesPorDia.put(5, new int[]{9, 0}); // Viernes: 9 y 0
        // Fines de semana no tienen restricciones
    }

    /**
     * Verifica si el vehículo puede circular según la placa y la fecha/hora
     * ingresada.
     *
     * @param placa - Placa del vehículo.
     * @param fechaHora - Fecha y hora de la consulta.
     * @return true si el vehículo puede circular, false si tiene restricción.
     */
    public boolean puedeCircular(String placa, LocalDateTime fechaHora) {
        // Obtener el último dígito de la placa
        int ultimoDigito = obtenerUltimoDigito(placa);

        // Obtener el día de la semana (1: Lunes, 7: Domingo)
        int diaSemana = fechaHora.getDayOfWeek().getValue();

        // Si es sábado o domingo, no hay restricciones
        if (diaSemana == 6 || diaSemana == 7) {
            return true;
        }

        // Verificar si el vehículo tiene restricción para ese día
        if (vehiculoTieneRestriccion(diaSemana, ultimoDigito)) {
            // Verificar si la hora está en los rangos de restricción
            LocalTime hora = fechaHora.toLocalTime();
            if (hora.isAfter(horaInicioManana) && hora.isBefore(horaFinManana)
                    || hora.isAfter(horaInicioTarde) && hora.isBefore(horaFinTarde)) {
                return false; // Tiene restricción
            }
        }

        return true; // Puede circular
    }

    // Método para obtener el último dígito de la placa
    private int obtenerUltimoDigito(String placa) {
        char ultimoCaracter = placa.charAt(placa.length() - 1);
        return Character.getNumericValue(ultimoCaracter);
    }

    // Verificar si el vehículo tiene restricción según el día y el último dígito de la placa
    private boolean vehiculoTieneRestriccion(int diaSemana, int ultimoDigito) {
        if (restriccionesPorDia.containsKey(diaSemana)) {
            int[] restricciones = restriccionesPorDia.get(diaSemana);
            for (int restriccion : restricciones) {
                if (restriccion == ultimoDigito) {
                    return true;
                }
            }
        }
        return false;
    }
}
