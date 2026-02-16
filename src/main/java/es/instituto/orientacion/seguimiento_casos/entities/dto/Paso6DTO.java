package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso6;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Paso 6 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 6 - Resolución del Caso,
 * que documenta la decisión formal adoptada tras la valoración y análisis realizados
 * en el Paso 5. Este paso constituye un momento crucial del protocolo porque determina
 * si se procede a la apertura formal del expediente de seguimiento y quiénes serán
 * los agentes implicados en el proceso de intervención.
 * </p>
 * <p>
 * El Paso 6 cumple varias funciones esenciales:
 * </p>
 * <ul>
 *   <li><strong>Formalización de la decisión:</strong> Establece oficialmente si el caso
 *       requiere seguimiento protocolizado o si se pueden aplicar medidas menos intensivas</li>
 *   <li><strong>Identificación de responsables:</strong> Define qué profesionales, servicios
 *       y agentes estarán involucrados en la intervención</li>
 *   <li><strong>Fundamentación de la resolución:</strong> Justifica la decisión tomada
 *       basándose en la valoración previa</li>
 *   <li><strong>Establecimiento del marco de actuación:</strong> Delimita el alcance
 *       y los participantes del plan de intervención</li>
 * </ul>
 * <p>
 * La resolución se fundamenta en la información recopilada en los pasos anteriores,
 * especialmente en la valoración exhaustiva del Paso 5, y marca el inicio de la fase
 * de intervención activa mediante el diseño del plan individualizado (Paso 7).
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso6}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso6
 */
@Data
public class Paso6DTO {

    /**
     * Indica si los tutores estarán implicados en el seguimiento del caso.
     * <p>
     * Los tutores (tutor del grupo, tutores de materias) son habitualmente figuras
     * clave en el seguimiento educativo del alumno. Su implicación puede incluir:
     * </p>
     * <ul>
     *   <li>Seguimiento diario del estado emocional y comportamiento del alumno</li>
     *   <li>Coordinación con la familia</li>
     *   <li>Implementación de adaptaciones metodológicas en el aula</li>
     *   <li>Comunicación de incidencias al equipo de orientación</li>
     *   <li>Participación en reuniones de seguimiento del caso</li>
     * </ul>
     */
    private Boolean tutores;

    /**
     * Indica si el propio alumno participa activamente en el proceso de seguimiento.
     * <p>
     * La participación del alumno es fundamental para garantizar una intervención
     * efectiva y respetuosa. Su implicación puede manifestarse en:
     * </p>
     * <ul>
     *   <li>Conocimiento del plan de intervención y compromisos adquiridos</li>
     *   <li>Participación en sesiones de seguimiento individual</li>
     *   <li>Expresión de necesidades, preocupaciones y valoración del proceso</li>
     *   <li>Colaboración activa en la implementación de estrategias de mejora</li>
     * </ul>
     * <p>
     * Incluir al alumno como agente activo favorece su empoderamiento y aumenta
     * la probabilidad de éxito de la intervención.
     * </p>
     */
    private Boolean alumno;

    /**
     * Indica si el servicio de inspección educativa está implicado en el caso.
     * <p>
     * La inspección educativa puede participar en casos que requieren:
     * </p>
     * <ul>
     *   <li>Supervisión del cumplimiento del protocolo</li>
     *   <li>Apoyo en casos de especial complejidad o gravedad</li>
     *   <li>Coordinación con administración educativa</li>
     *   <li>Asesoramiento en aspectos normativos</li>
     *   <li>Seguimiento de medidas excepcionales</li>
     * </ul>
     * <p>
     * Su implicación suele reservarse para casos de mayor gravedad o que requieren
     * coordinación interinstitucional compleja.
     * </p>
     */
    private Boolean inspeccion;

    /**
     * Indica si la comisión de convivencia u otro órgano colegiado participa en el seguimiento.
     * <p>
     * La comisión de convivencia puede implicarse cuando:
     * </p>
     * <ul>
     *   <li>El caso afecta a la convivencia escolar</li>
     *   <li>Se requiere toma de decisiones colegiadas sobre medidas a adoptar</li>
     *   <li>Es necesaria la coordinación entre diferentes departamentos</li>
     *   <li>Se precisa seguimiento institucional del caso</li>
     * </ul>
     */
    private Boolean comision;

    /**
     * Indica si servicios externos están implicados en el seguimiento.
     * <p>
     * Los servicios externos pueden incluir:
     * </p>
     * <ul>
     *   <li><strong>Servicios de salud mental:</strong> USMI-J, psiquiatría infantojuvenil,
     *       psicología clínica</li>
     *   <li><strong>Servicios sociales:</strong> Trabajadores sociales de zona,
     *       servicios de protección de menores</li>
     *   <li><strong>Servicios comunitarios:</strong> Centros de salud, programas
     *       de prevención, asociaciones especializadas</li>
     *   <li><strong>Otros recursos educativos:</strong> Equipos de orientación externos,
     *       programas específicos</li>
     * </ul>
     * <p>
     * La coordinación con servicios externos es esencial en casos que requieren
     * intervención multidisciplinar o especializada.
     * </p>
     */
    private Boolean servicios;

    /**
     * Indica si hay otros agentes implicados no contemplados en las categorías anteriores.
     * <p>
     * Permite registrar la participación de otros profesionales o servicios que puedan
     * ser relevantes para el seguimiento del caso, tales como:
     * </p>
     * <ul>
     *   <li>Monitores de actividades extraescolares</li>
     *   <li>Educadores de programas específicos</li>
     *   <li>Mediadores interculturales</li>
     *   <li>Profesionales de entidades colaboradoras</li>
     *   <li>Otros miembros de la comunidad educativa</li>
     * </ul>
     */
    private Boolean otros;

    /**
     * Especificación de otros agentes implicados.
     * <p>
     * Campo de texto libre que se cumplimenta cuando el campo {@link #otros} es verdadero,
     * detallando quiénes son esos otros agentes y cuál será su rol en el seguimiento.
     * </p>
     * <p>
     * Es importante especificar claramente:
     * </p>
     * <ul>
     *   <li>Nombre del profesional, servicio o entidad</li>
     *   <li>Rol o función que desempeñarán en el seguimiento</li>
     *   <li>Ámbito de actuación o responsabilidad</li>
     * </ul>
     * <p>
     * Ejemplo: "Educadora del programa de refuerzo educativo municipal - apoyo académico
     * extraescolar dos tardes por semana"
     * </p>
     */
    private String otrosespecificados;

    /**
     * Indica si se procede a la apertura formal del expediente de seguimiento.
     * <p>
     * Este campo recoge la decisión principal del Paso 6. Cuando se marca como verdadero,
     * significa que tras la valoración del Paso 5 se ha determinado que el caso requiere:
     * </p>
     * <ul>
     *   <li>Seguimiento protocolizado y formal</li>
     *   <li>Diseño de un plan individualizado de intervención (Paso 7)</li>
     *   <li>Implicación coordinada de múltiples agentes</li>
     *   <li>Documentación sistemática del proceso</li>
     * </ul>
     * <p>
     * Cuando es falso, puede indicar que:
     * </p>
     * <ul>
     *   <li>Las medidas provisionales del Paso 3 han sido suficientes</li>
     *   <li>Se derivan actuaciones a otros servicios sin seguimiento protocolizado interno</li>
     *   <li>El caso no requiere intervención intensiva en este momento</li>
     * </ul>
     * <p>
     * Esta decisión debe fundamentarse adecuadamente en el campo {@link #motivacion}.
     * </p>
     */
    private Boolean abrir;

    /**
     * Indica si se ha documentado la motivación de la resolución adoptada.
     * <p>
     * Marca si existe una justificación formal de la decisión tomada (abrir o no abrir
     * el expediente de seguimiento). La motivación debe fundamentarse en:
     * </p>
     * <ul>
     *   <li>Resultados de la valoración del Paso 5</li>
     *   <li>Nivel de riesgo identificado</li>
     *   <li>Factores de protección disponibles</li>
     *   <li>Recursos necesarios y disponibles</li>
     *   <li>Evolución observada desde las medidas provisionales</li>
     * </ul>
     * <p>
     * <strong>Nota:</strong> Este campo parece diseñado como booleano para indicar
     * la existencia de motivación, aunque en la práctica la motivación en sí misma
     * probablemente se documente en un campo de texto asociado al Paso 6 (no visible
     * en este DTO pero que podría existir en la entidad).
     * </p>
     */
    private Boolean motivacion;

    /**
     * Fecha en que se adopta la resolución.
     * <p>
     * Marca temporal que documenta cuándo se tomó formalmente la decisión sobre
     * el caso. Esta fecha es importante para:
     * </p>
     * <ul>
     *   <li>Establecer el momento de transición entre la fase de valoración
     *       y la fase de intervención</li>
     *   <li>Documentar el cumplimiento de plazos del protocolo</li>
     *   <li>Dar validez formal a la resolución adoptada</li>
     *   <li>Permitir el seguimiento temporal del proceso completo</li>
     * </ul>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos booleanos sin inicializar
     * y campos de texto y fecha vacíos. Utilizado principalmente al registrar
     * la resolución de un caso nuevo donde aún no se han definido los agentes
     * implicados ni se ha tomado la decisión formal.
     * </p>
     */
    public Paso6DTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Paso6.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos que definen la resolución:
     * los agentes implicados, la decisión de apertura, la existencia de motivación
     * y la fecha de la resolución.
     * </p>
     * <p>
     * Esta conversión permite visualizar y editar la resolución de forma desacoplada
     * de la capa de persistencia, facilitando su gestión desde la interfaz de usuario.
     * </p>
     *
     * @param paso6 entidad Paso6 de la que se copiarán los datos.
     *              Si es null, se creará un DTO vacío (comportamiento por defecto
     *              si no se valida previamente).
     */
    public Paso6DTO(Paso6 paso6) {
        this.tutores = paso6.getTutores();
        this.abrir = paso6.getAbrir();
        this.alumno = paso6.getAlumno();
        this.inspeccion = paso6.getInspeccion();
        this.servicios = paso6.getServicios();
        this.comision = paso6.getComision();
        this.otros = paso6.getOtros();
        this.otrosespecificados = paso6.getOtrosespecificados();
        this.motivacion = paso6.getMotivacion();
        this.fecha = paso6.getFecha();
    }
}