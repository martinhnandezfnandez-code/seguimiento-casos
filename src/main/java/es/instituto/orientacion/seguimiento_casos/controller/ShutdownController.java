package es.instituto.orientacion.seguimiento_casos.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Controlador para el cierre controlado de la aplicación.
 * Expone el endpoint POST /shutdown que detiene el servidor Spring Boot.
 */
@RestController
public class ShutdownController {

    @PostMapping("/shutdown")
    public String shutdown() {
        // Hilo separado para que la respuesta llegue al navegador antes del cierre
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
            System.exit(0);
        }).start();

        return "Cerrando aplicación...";
    }
}