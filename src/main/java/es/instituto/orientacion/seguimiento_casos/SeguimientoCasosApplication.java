package es.instituto.orientacion.seguimiento_casos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.net.URI;

/**
 * Punto de entrada principal de la aplicación de Seguimiento de Casos.
 * <p>
 * Esta clase inicializa el contexto de Spring Boot, configura el autowiring
 * y arranca el servidor embebido. Además, incluye un escuchador de eventos
 * para facilitar el acceso al usuario abriendo automáticamente el navegador
 * una vez que el sistema está listo.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 */
@SpringBootApplication
public class SeguimientoCasosApplication {

    /**
     * Método de inicio que lanza la aplicación Spring Boot.
     * * @param args Argumentos de línea de comandos (opcionales).
     */
    public static void main(String[] args) {
        SpringApplication.run(SeguimientoCasosApplication.class, args);
    }

    /**
     * Escucha el evento {@link ApplicationReadyEvent} para abrir el navegador automáticamente.
     * <p>
     * Una vez que el servidor Tomcat está levantado y la aplicación está lista para recibir peticiones,
     * este método intenta abrir la URL local {@code http://localhost:8080}.
     * El método es compatible con:
     * </p>
     * <ul>
     * <li>Sistemas con soporte nativo de la clase {@link Desktop}.</li>
     * <li>Windows (vía rundll32).</li>
     * <li>macOS (vía comando open).</li>
     * <li>Linux/Unix (vía xdg-open).</li>
     * </ul>
     * * @see ApplicationReadyEvent
     */
    @EventListener(ApplicationReadyEvent.class)
    public void openBrowser() {
        try {
            String url = "http://localhost:8080";

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
                System.out.println("Abriendo navegador en: " + url);
            } else {
                String os = System.getProperty("os.name").toLowerCase();
                Runtime runtime = Runtime.getRuntime();

                if (os.contains("win")) {
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    runtime.exec("open " + url);
                } else if (os.contains("nix") || os.contains("nux")) {
                    runtime.exec("xdg-open " + url);
                }
            }
        } catch (Exception e) {
            System.err.println("No se pudo abrir el navegador: " + e.getMessage());
        }
    }
}