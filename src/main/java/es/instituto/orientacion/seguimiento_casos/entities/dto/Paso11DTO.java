package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso11;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Paso 11 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 11 - Cierre del Caso y
 * Seguimiento Institucional, que constituye la etapa final del protocolo de seguimiento.
 * Este paso documenta el cierre formal del caso y los seguimientos posteriores realizados
 * por los diferentes agentes educativos (inspección educativa, familia y profesorado)
 * para verificar que la situación se ha estabilizado y que el alumno mantiene su bienestar.
 * </p>
 * <p>
 * El Paso 11 es fundamental porque:
 * </p>
 * <ul>
 *   <li>Formaliza la conclusión del protocolo intensivo de seguimiento</li>
 *   <li>Documenta los criterios que justifican el cierre del caso</li>
 *   <li>Establece un sistema de seguimiento post-cierre para prevenir recaídas</li>
 *   <li>Garantiza que diferentes agentes educativos verifican la estabilidad del alumno</li>
 *   <li>Proporciona trazabilidad completa del caso desde su apertura hasta su cierre</li>
 *   <li>Permite reabrir el caso de forma ágil si reaparecen señales de alarma</li>
 * </ul>
 * <p>
 * Este paso registra tres tipos de seguimiento diferenciados:
 * </p>
 * <ul>
 *   <li><strong>Seguimiento por Inspección Educativa:</strong> Verificación institucional
 *       del cumplimiento del protocolo y de la adecuación de las medidas adoptadas</li>
 *   <li><strong>Seguimiento por la Familia:</strong> Confirmación de que la familia observa
 *       mejora y estabilidad en el alumno desde el contexto familiar</li>
 *   <li><strong>Seguimiento por el Profesorado:</strong> Valoración del equipo docente
 *       sobre la evolución del alumno en el ámbito escolar</li>
 * </ul>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso11}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso11
 */
@Data
public class Paso11DTO {

    /**
     * Fecha de cierre formal del caso.
     * <p>
     * Marca temporal que registra cuándo se decidió cerrar formalmente el caso
     * de seguimiento intensivo del alumno. Esta fecha es crucial porque:
     * </p>
     * <ul>
     *   <li>Establece el momento en que se considera que la situación de riesgo
     *       ha sido gestionada adecuadamente</li>
     *   <li>Marca el fin del seguimiento intensivo establecido en el protocolo</li>
     *   <li>Sirve como referencia temporal para evaluar la duración total del caso</li>
     *   <li>Permite calcular los plazos de seguimiento post-cierre</li>
     *   <li>Facilita estudios estadísticos sobre la duración media de los casos</li>
     * </ul>
     * <p>
     * <strong>Criterios habituales para el cierre:</strong>
     * </p>
     * <ul>
     *   <li>Desaparición o reducción significativa de señales de alarma</li>
     *   <li>Estabilización del estado emocional del alumno</li>
     *   <li>Mejora observable en el funcionamiento académico y social</li>
     *   <li>Fortalecimiento de factores de protección</li>
     *   <li>Establecimiento de red de apoyo efectiva y estable</li>
     *   <li>Familia implicada y con recursos para el seguimiento</li>
     * </ul>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecchacierre;

    /**
     * Observaciones sobre el cierre del caso.
     * <p>
     * Campo de texto extenso que documenta la fundamentación del cierre del caso,
     * los criterios específicos que se han cumplido para justificar esta decisión,
     * la evolución observada desde la apertura y cualquier recomendación para
     * el seguimiento posterior.
     * </p>
     * <p>
     * Este campo debe incluir:
     * </p>
     * <ul>
     *   <li><strong>Justificación del cierre:</strong> Motivos concretos que fundamentan
     *       la decisión de cerrar el caso (mejora significativa, objetivos conseguidos,
     *       estabilización del alumno)</li>
     *   <li><strong>Evolución observada:</strong> Descripción de cómo ha evolucionado
     *       el alumno desde la apertura del caso hasta su cierre</li>
     *   <li><strong>Logros alcanzados:</strong> Objetivos del plan individualizado
     *       que se han conseguido</li>
     *   <li><strong>Factores de protección consolidados:</strong> Fortalezas y recursos
     *       que se han desarrollado o reforzado durante la intervención</li>
     *   <li><strong>Recomendaciones post-cierre:</strong> Sugerencias para mantener
     *       el bienestar del alumno (seguimiento ordinario, vigilancia de señales,
     *       mantenimiento de apoyos específicos)</li>
     *   <li><strong>Alertas a considerar:</strong> Situaciones o circunstancias que,
     *       si aparecieran, podrían requerir reabrir el caso</li>
     * </ul>
     */
    private String observacionesFechaCierre;

    /**
     * Fecha del seguimiento realizado por la inspección educativa.
     * <p>
     * Registra cuándo el servicio de inspección educativa realizó su seguimiento
     * post-cierre para verificar la adecuación del proceso seguido y la situación
     * actual del alumno desde una perspectiva institucional y de supervisión.
     * </p>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaInspeccion;

    /**
     * Valoración y observaciones del seguimiento por inspección educativa.
     * <p>
     * Campo de texto que documenta la valoración realizada por el servicio de
     * inspección educativa tras revisar el caso y verificar su cierre.
     * <p>
     * Puede incluir: conformidad con el proceso seguido, observaciones sobre
     * aspectos a mejorar, valoración de la coordinación realizada, recomendaciones
     * para casos futuros.
     * </p>
     */
    private String inspeccion;

    /**
     * Fecha del seguimiento realizado con la familia.
     * <p>
     * Registra cuándo se realizó el seguimiento post-cierre con la familia del alumno
     * para conocer su valoración de la evolución y verificar que la mejora se mantiene
     * también en el contexto familiar.
     * </p>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecchafamilia;

    /**
     * Valoración y observaciones del seguimiento con la familia.
     * <p>
     * Campo de texto que documenta la información recogida en el seguimiento
     * con la familia tras el cierre del caso.
     * <p>
     * Puede incluir: percepción familiar de la evolución del alumno, cambios observados
     * en casa, nivel de satisfacción con el proceso, compromisos de seguimiento,
     * necesidades adicionales detectadas.
     * </p>
     */
    private String familia;

    /**
     * Fecha del seguimiento realizado por el profesorado.
     * <p>
     * Registra cuándo el equipo docente realizó su seguimiento post-cierre para
     * valorar la evolución del alumno en el ámbito académico, relacional y emocional
     * dentro del contexto escolar.
     * </p>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaProfesorado;

    /**
     * Valoración y observaciones del seguimiento por el profesorado.
     * <p>
     * Campo de texto que documenta la valoración conjunta del equipo docente
     * sobre la evolución del alumno tras el cierre del caso.
     * <p>
     * Puede incluir: valoración del rendimiento académico, observaciones sobre
     * participación en clase, calidad de las relaciones con compañeros y profesorado,
     * estado emocional observable, necesidad de mantener adaptaciones o apoyos específicos.
     * </p>
     */
    private String profesorado;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al comenzar a cumplimentar el paso de cierre
     * y seguimiento del caso.
     * </p>
     */
    public Paso11DTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Paso11.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos relacionados con el cierre del caso
     * y los tres seguimientos posteriores (inspección, familia y profesorado),
     * incluyendo tanto las fechas como las valoraciones de cada seguimiento.
     * </p>
     *
     * @param paso11 entidad Paso11 de la que se copiarán los datos.
     *               Si es null, se creará un DTO vacío (comportamiento por defecto
     *               si no se valida previamente).
     */
    public Paso11DTO(Paso11 paso11) {
        this.fecchacierre = paso11.getFecchacierre();
        this.observacionesFechaCierre = paso11.getObservacionesFechaCierre();
        this.fechaInspeccion = paso11.getFechaInspeccion();
        this.inspeccion = paso11.getInspeccion();
        this.fecchafamilia = paso11.getFecchafamilia();
        this.familia = paso11.getFamilia();
        this.fechaProfesorado = paso11.getFechaProfesorado();
        this.profesorado = paso11.getProfesorado();
    }
}