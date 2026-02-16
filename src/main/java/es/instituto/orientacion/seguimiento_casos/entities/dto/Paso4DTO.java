package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso4;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Paso 4 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 4 - Acta de Reunión con la Familia,
 * que documenta los encuentros mantenidos con las familias o tutores legales del alumno
 * dentro del protocolo de seguimiento. Estas reuniones son fundamentales para establecer
 * una comunicación efectiva, recoger información del contexto familiar, informar sobre
 * la situación y acordar estrategias coordinadas de intervención.
 * </p>
 * <p>
 * El Paso 4 constituye un elemento clave en el protocolo, ya que la colaboración
 * y participación activa de la familia es esencial para el éxito de cualquier plan
 * de intervención con el alumno. Este acta formaliza los compromisos y acuerdos
 * alcanzados entre el centro educativo y la familia.
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso4}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso4
 */
@Data
public class Paso4DTO {

    /**
     * Listado de personas asistentes a la reunión.
     * <p>
     * Campo de texto que registra los nombres y, opcionalmente, los roles o relación
     * de todas las personas que participaron en la reunión con la familia.
     * Es importante incluir tanto a los miembros de la familia como a los profesionales
     * del centro educativo presentes.
     * </p>
     * <p>
     * Ejemplos de formato:
     * </p>
     * <ul>
     *   <li><strong>Familia:</strong> María García Pérez (madre), Juan López Martín (padre)</li>
     *   <li><strong>Centro educativo:</strong> Ana Rodríguez (orientadora), Carlos Sánchez (tutor),
     *       Elena Fernández (jefa de estudios)</li>
     * </ul>
     * <p>
     * Este registro es importante para:
     * </p>
     * <ul>
     *   <li>Documentar quién estuvo presente y puede dar fe de los acuerdos</li>
     *   <li>Identificar los roles de los participantes</li>
     *   <li>Facilitar el seguimiento de compromisos por parte de cada asistente</li>
     *   <li>Tener constancia formal de la participación de la familia</li>
     * </ul>
     */
    private String asistentes;

    /**
     * Contenido desarrollado durante la reunión.
     * <p>
     * Campo de texto extenso que documenta los temas tratados, la información
     * compartida y el desarrollo general de la reunión. Debe recoger de manera
     * objetiva y completa todo lo que se comunicó y discutió durante el encuentro.
     * </p>
     * <p>
     * Aspectos a incluir en el contenido:
     * </p>
     * <ul>
     *   <li><strong>Información proporcionada por el centro:</strong> Situación del alumno,
     *       comportamientos observados, rendimiento académico, preocupaciones detectadas</li>
     *   <li><strong>Información aportada por la familia:</strong> Contexto familiar,
     *       situación en casa, cambios observados, circunstancias relevantes</li>
     *   <li><strong>Análisis compartido:</strong> Valoración conjunta de la situación,
     *       identificación de necesidades, factores que influyen en el caso</li>
     *   <li><strong>Propuestas discutidas:</strong> Medidas planteadas, opciones valoradas,
     *       recursos disponibles</li>
     *   <li><strong>Dudas y preguntas:</strong> Inquietudes manifestadas por la familia,
     *       aclaraciones solicitadas</li>
     * </ul>
     * <p>
     * Es importante redactar este campo con lenguaje claro, respetuoso y objetivo,
     * evitando juicios de valor y centrándose en hechos observables y comunicaciones
     * concretas.
     * </p>
     */
    private String contenido;

    /**
     * Acuerdos alcanzados durante la reunión.
     * <p>
     * Campo de texto que documenta de forma específica y clara todos los compromisos,
     * acuerdos y decisiones tomadas conjuntamente entre la familia y el centro educativo.
     * Estos acuerdos constituyen la base del plan de actuación coordinado y deben ser
     * concretos, realizables y verificables.
     * </p>
     * <p>
     * Los acuerdos deben incluir:
     * </p>
     * <ul>
     *   <li><strong>Compromisos de la familia:</strong> Acciones específicas que la familia
     *       se compromete a realizar (ej: seguimiento diario de tareas, comunicación regular
     *       con el tutor, acudir a servicios externos recomendados)</li>
     *   <li><strong>Compromisos del centro:</strong> Actuaciones que el centro implementará
     *       (ej: adaptaciones metodológicas, seguimiento individualizado, coordinación
     *       con servicios de orientación)</li>
     *   <li><strong>Compromisos compartidos:</strong> Estrategias conjuntas que requieren
     *       colaboración de ambas partes</li>
     *   <li><strong>Plazos establecidos:</strong> Fechas o periodos acordados para realizar
     *       las acciones o para reuniones de seguimiento</li>
     *   <li><strong>Responsables:</strong> Quién es responsable de cada acción acordada</li>
     * </ul>
     * <p>
     * Es fundamental que los acuerdos sean realistas, específicos y que tanto la familia
     * como el centro comprendan y acepten sus compromisos. La claridad de estos acuerdos
     * es esencial para el éxito de la intervención.
     * </p>
     */
    private String acuerdos;

    /**
     * Fecha en que se celebró la reunión.
     * <p>
     * Marca temporal que documenta cuándo tuvo lugar el encuentro con la familia.
     * Esta fecha es importante para:
     * </p>
     * <ul>
     *   <li>Establecer la línea temporal del seguimiento del caso</li>
     *   <li>Verificar el cumplimiento de plazos del protocolo</li>
     *   <li>Calcular los intervalos entre reuniones</li>
     *   <li>Dar validez formal al acta de reunión</li>
     *   <li>Facilitar la programación de reuniones de seguimiento</li>
     * </ul>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    /**
     * Constructor que crea un DTO a partir de una entidad Paso4.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos del acta de reunión, incluyendo
     * los asistentes, el contenido desarrollado, los acuerdos alcanzados
     * y la fecha del encuentro.
     * </p>
     *
     * @param paso4 entidad Paso4 de la que se copiarán los datos.
     *              Si es null, se creará un DTO vacío (comportamiento por defecto
     *              si no se valida previamente).
     */
    public Paso4DTO(Paso4 paso4) {
        this.acuerdos = paso4.getAcuerdos();
        this.asistentes = paso4.getAsistentes();
        this.contenido = paso4.getContenido();
        this.fecha = paso4.getFecha();
    }

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al programar una nueva reunión o al crear
     * un nuevo acta donde aún no se ha registrado información.
     * </p>
     */
    public Paso4DTO() {
    }
}