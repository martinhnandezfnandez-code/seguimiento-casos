package es.instituto.orientacion.seguimiento_casos.services;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;

/**
 * Servicio para la generación de documentos PDF.
 * <p>
 * Este servicio es responsable de generar todos los anexos PDF del protocolo de
 * seguimiento de casos de alumnado. Utiliza Thymeleaf para procesar plantillas HTML
 * y OpenHTMLtoPDF para convertirlas en documentos PDF.
 * </p>
 * <p>
 * Cada método de generación carga los datos del alumno y del paso correspondiente,
 * procesa una plantilla Thymeleaf específica e incluye el logo institucional embebido
 * en formato Base64.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 */
@Service
public class PdfService {

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * Genera el PDF del Anexo 1 del protocolo de seguimiento.
     * <p>
     * Este anexo contiene la información inicial del alumno y los datos del Paso 1.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo1(Alumnado alumnado) {
        Context context = new Context();

        // Pasamos el objeto alumnado y su paso1 al template
        context.setVariable("alumnado", alumnado);
        context.setVariable("p1", alumnado.getPaso1());

        // Cargar el logo y convertirlo a Base64
        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo1_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF: " + e.getMessage(), e);
        }
    }

    /**
     * Genera el PDF del Anexo 2 (Cronograma) del protocolo de seguimiento.
     * <p>
     * Este anexo contiene el cronograma de actuaciones planificadas para el alumno.
     * Utiliza un DTO para facilitar el manejo de la lista de actividades cronogramadas.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo2(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);

        // Convertimos el Paso2 de la entidad a DTO para manejar la lista de cronograma fácilmente
        if (alumnado.getPaso2() != null) {
            Paso2DTO p2DTO = new Paso2DTO(alumnado.getPaso2());
            context.setVariable("p2", p2DTO);
        } else {
            context.setVariable("p2", new Paso2DTO());
        }

        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo2_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF Anexo 2: " + e.getMessage(), e);
        }
    }

    /**
     * Genera el PDF del Anexo 3 (Acta de Reunión con la Familia) del protocolo de seguimiento.
     * <p>
     * Este anexo documenta las reuniones mantenidas con la familia del alumno
     * y los acuerdos alcanzados.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo3(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);

        if (alumnado.getPaso4() != null) {
            context.setVariable("p4", new Paso4DTO(alumnado.getPaso4()));
        } else {
            context.setVariable("p4", new Paso4DTO());
        }

        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo3_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error en PDF Anexo 3: " + e.getMessage());
        }
    }

    /**
     * Genera el PDF del Anexo 4 (Síntesis de la Valoración) del protocolo de seguimiento.
     * <p>
     * Este anexo presenta un resumen de la valoración realizada al alumno.
     * Los datos provienen del Paso 5 del protocolo.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo4(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);

        // Obtenemos los datos del Paso 5 y su Anexo 4
        if (alumnado.getPaso5() != null) {
            context.setVariable("p5", new Paso5DTO(alumnado.getPaso5()));
        } else {
            context.setVariable("p5", new Paso5DTO());
        }

        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo4_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF Anexo 4: " + e.getMessage());
        }
    }

    /**
     * Genera el PDF del Anexo 5 (Análisis del Caso) del protocolo de seguimiento.
     * <p>
     * Este anexo contiene un análisis detallado del caso del alumno, incluyendo
     * tres listas de indicadores que permiten evaluar diferentes aspectos de su situación.
     * Los datos provienen del Paso 5 del protocolo.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo5(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);

        // El Paso 5 contiene el Anexo 5, y este a su vez las 3 listas de indicadores
        if (alumnado.getPaso5() != null) {
            context.setVariable("p5", new Paso5DTO(alumnado.getPaso5()));
        } else {
            context.setVariable("p5", new Paso5DTO()); // DTOs vacíos por seguridad
        }

        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo5_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF Anexo 5: " + e.getMessage());
        }
    }

    /**
     * Genera el PDF del Anexo 6 (Resolución) del protocolo de seguimiento.
     * <p>
     * Este anexo documenta la resolución adoptada para el caso del alumno
     * tras el análisis y valoración realizados.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo6(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);

        // Si el Paso 6 no existe, enviamos un DTO vacío para evitar errores de null
        context.setVariable("p6", alumnado.getPaso6() != null ? new Paso6DTO(alumnado.getPaso6()) : new Paso6DTO());

        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo6_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF Anexo 6: " + e.getMessage());
        }
    }

    /**
     * Genera el PDF del Anexo 7 (Plan Individualizado) del protocolo de seguimiento.
     * <p>
     * Este anexo contiene el plan de intervención individualizado diseñado
     * específicamente para atender las necesidades del alumno.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo7(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);

        // Si el Paso 7 no existe, enviamos un DTO vacío para evitar errores de null
        context.setVariable("p7", alumnado.getPaso6() != null ? new Paso7DTO(alumnado.getPaso7()) : new Paso7DTO());

        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo7_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF Anexo 7: " + e.getMessage());
        }
    }

    /**
     * Genera el PDF del Anexo 8 (Seguimiento) del protocolo de seguimiento.
     * <p>
     * Este anexo documenta el proceso de seguimiento de las actuaciones
     * y medidas implementadas con el alumno, permitiendo evaluar su efectividad
     * y realizar ajustes cuando sea necesario.
     * </p>
     *
     * @param alumnado entidad del alumno con sus datos completos
     * @return array de bytes con el contenido del PDF generado
     * @throws RuntimeException si ocurre un error durante la generación del PDF
     */
    public byte[] generarPdfAnexo8(Alumnado alumnado) {
        Context context = new Context();
        context.setVariable("alumnado", alumnado);
        context.setVariable("p8", alumnado.getPaso8() != null ? new Paso8DTO(alumnado.getPaso8()) : new Paso8DTO());

        // Cargar el logo institucional
        String logoBase64 = cargarImagenComoBase64("static/images/logo-junta.png");
        context.setVariable("logoBase64", logoBase64);

        String htmlContent = templateEngine.process("pdf/anexo8_template", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            // El segundo parámetro (baseUri) puede ser nulo si usamos Base64
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF Anexo 8: " + e.getMessage());
        }
    }

    /**
     * Carga una imagen desde el classpath y la convierte a formato Base64.
     * <p>
     * Este método permite embeber imágenes directamente en el HTML que se convertirá
     * a PDF, utilizando Data URIs. Esto evita problemas de rutas y referencias externas.
     * </p>
     *
     * @param rutaImagen ruta relativa desde el directorio resources/
     *                   (ejemplo: "static/images/logo.png")
     * @return String con el data URI completo (formato: data:image/png;base64,...)
     *         o cadena vacía si la imagen no se encuentra o hay un error
     */
    private String cargarImagenComoBase64(String rutaImagen) {
        try {
            ClassPathResource resource = new ClassPathResource(rutaImagen);

            if (!resource.exists()) {
                System.err.println("⚠️ Advertencia: No se encontró la imagen en " + rutaImagen);
                return "";
            }

            InputStream inputStream = resource.getInputStream();
            byte[] imageBytes = inputStream.readAllBytes();
            inputStream.close();

            String base64 = Base64.getEncoder().encodeToString(imageBytes);

            // Determinar el tipo MIME según la extensión
            String mimeType = obtenerMimeType(rutaImagen);

            return "data:" + mimeType + ";base64," + base64;

        } catch (Exception e) {
            System.err.println("❌ Error al cargar imagen " + rutaImagen + ": " + e.getMessage());
            return "";
        }
    }

    /**
     * Determina el tipo MIME de una imagen según su extensión de archivo.
     * <p>
     * Este método es utilizado para construir correctamente el Data URI
     * al embeber imágenes en Base64.
     * </p>
     *
     * @param rutaImagen ruta de la imagen (se extrae la extensión del nombre de archivo)
     * @return tipo MIME correspondiente (por defecto "image/png" si la extensión no es reconocida)
     */
    private String obtenerMimeType(String rutaImagen) {
        String extension = rutaImagen.substring(rutaImagen.lastIndexOf('.') + 1).toLowerCase();

        return switch (extension) {
            case "png" -> "image/png";
            case "jpg", "jpeg" -> "image/jpeg";
            case "gif" -> "image/gif";
            case "webp" -> "image/webp";
            case "svg" -> "image/svg+xml";
            default -> "image/png";
        };
    }
}