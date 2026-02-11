package es.instituto.orientacion.seguimiento_casos.services;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;

@Service
public class PdfService {

    @Autowired
    private TemplateEngine templateEngine;

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
     * Carga una imagen desde el classpath y la convierte a Base64
     * @param rutaImagen Ruta relativa desde resources/ (ejemplo: "static/images/logo.png")
     * @return String con el data URI completo (data:image/png;base64,...)
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
     * Determina el tipo MIME de la imagen según su extensión
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