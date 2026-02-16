package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo4;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Anexo 4 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Anexo 4 - Síntesis de la Valoración,
 * que documenta las entrevistas y valoraciones realizadas tanto con la familia como con
 * el alumno. Contiene información sobre las síntesis de las entrevistas, los participantes
 * y las fechas en que se realizaron.
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Anexo4}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Anexo4
 */
@Data
public class Anexo4DTO {

    /**
     * Síntesis de la entrevista realizada con la familia.
     * <p>
     * Resumen de la información recogida durante la entrevista familiar,
     * incluyendo percepción del problema, dinámica familiar y colaboración.
     * </p>
     */
    private String sintesisfamilia;

    /**
     * Integrantes de la familia que participaron en la entrevista.
     * <p>
     * Listado de las personas que estuvieron presentes en la entrevista
     * familiar (padres, tutores legales, hermanos, etc.).
     * </p>
     */
    private String integrantesfamilia;

    /**
     * Fecha en que se realizó la entrevista con la familia.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechafamilia;

    /**
     * Síntesis de la entrevista realizada con el alumno.
     * <p>
     * Resumen de la información recogida durante la entrevista con el alumno,
     * incluyendo su percepción de la situación, estado emocional y necesidades
     * expresadas.
     * </p>
     */
    private String sintesisalumno;

    /**
     * Integrantes o profesionales que participaron en la entrevista con el alumno.
     * <p>
     * Listado de las personas presentes durante la entrevista (orientador,
     * tutor, trabajador social, etc.).
     * </p>
     */
    private String integrantesalumno;

    /**
     * Fecha en que se realizó la entrevista con el alumno.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaalumno;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO, utilizado principalmente en formularios
     * nuevos donde aún no existe información.
     * </p>
     */
    public Anexo4DTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Anexo4.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos relevantes si la entidad no es nula.
     * </p>
     *
     * @param anexo4 entidad Anexo4 de la que se copiarán los datos.
     *               Si es null, los campos del DTO permanecerán sin inicializar.
     */
    public Anexo4DTO(Anexo4 anexo4) {
        if (anexo4 != null) {
            this.sintesisalumno = anexo4.getSintesisalumno();
            this.fechaalumno = anexo4.getFechaalumno();
            this.integrantesalumno = anexo4.getIntegrantesalumno();
            this.sintesisfamilia = anexo4.getSintesisfamilia();
            this.fechafamilia = anexo4.getFechafamilia();
            this.integrantesfamilia = anexo4.getIntegrantesfamilia();
        }
    }
}