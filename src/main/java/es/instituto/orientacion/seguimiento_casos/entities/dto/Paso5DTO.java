package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso5;
import lombok.Data;

/**
 * DTO (Data Transfer Object) para el Paso 5 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 5 - Valoración y Análisis del Caso,
 * que constituye uno de los pasos más importantes y complejos del protocolo. En este paso
 * se realiza una evaluación exhaustiva y estructurada de la situación del alumno mediante
 * dos anexos especializados que permiten obtener una comprensión profunda del caso.
 * </p>
 * <p>
 * El Paso 5 integra dos componentes fundamentales:
 * </p>
 * <ul>
 *   <li><strong>Anexo 4 - Síntesis de la Valoración:</strong> Documenta las entrevistas
 *       realizadas con el alumno y la familia, recogiendo información cualitativa sobre
 *       su percepción de la situación, dinámica familiar y aspectos contextuales relevantes.</li>
 *   <li><strong>Anexo 5 - Análisis del Caso:</strong> Proporciona un análisis estructurado
 *       mediante tres dimensiones (señales de alarma, factores de riesgo y factores de protección)
 *       que permiten evaluar de forma sistemática la gravedad del caso y los recursos disponibles.</li>
 * </ul>
 * <p>
 * La información recopilada en este paso es fundamental porque:
 * </p>
 * <ul>
 *   <li>Fundamenta la toma de decisiones sobre la apertura formal del caso (Paso 6)</li>
 *   <li>Orienta el diseño del plan individualizado de intervención (Paso 7)</li>
 *   <li>Identifica áreas prioritarias de actuación</li>
 *   <li>Reconoce fortalezas del alumno que pueden potenciarse</li>
 *   <li>Permite evaluar el nivel de riesgo de forma objetiva</li>
 *   <li>Facilita la coordinación con servicios externos al compartir una valoración estructurada</li>
 * </ul>
 * <p>
 * Este DTO actúa como contenedor de los dos anexos que conforman la valoración completa,
 * permitiendo su gestión conjunta y garantizando la coherencia entre la información
 * cualitativa (entrevistas) y el análisis estructurado (indicadores).
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso5}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso5
 * @see Anexo4DTO
 * @see Anexo5DTO
 */
@Data
public class Paso5DTO {

    /**
     * Anexo 4 - Síntesis de la Valoración.
     * <p>
     * Contiene la documentación de las entrevistas realizadas con el alumno y su familia,
     * registrando la síntesis de la información recogida, los participantes en cada entrevista
     * y las fechas de realización.
     * </p>
     * <p>
     * Este anexo proporciona la perspectiva subjetiva y cualitativa del caso:
     * </p>
     * <ul>
     *   <li><strong>Visión del alumno:</strong> Cómo percibe su situación, qué siente,
     *       qué necesita, cómo se ve a sí mismo</li>
     *   <li><strong>Visión de la familia:</strong> Cómo perciben el problema, qué observan
     *       en casa, qué preocupaciones tienen, qué apoyos pueden ofrecer</li>
     * </ul>
     * <p>
     * Este componente cualitativo es esencial porque:
     * </p>
     * <ul>
     *   <li>Recoge la voz del alumno y su familia como protagonistas del proceso</li>
     *   <li>Proporciona contexto para interpretar los indicadores del Anexo 5</li>
     *   <li>Identifica necesidades y preocupaciones desde la perspectiva de los implicados</li>
     *   <li>Facilita la construcción de una relación de confianza y colaboración</li>
     * </ul>
     * <p>
     * El campo se inicializa automáticamente (nunca es null) para facilitar
     * su uso desde la interfaz de usuario.
     * </p>
     *
     * @see Anexo4DTO
     */
    private Anexo4DTO anexo4;

    /**
     * Anexo 5 - Análisis del Caso.
     * <p>
     * Contiene el análisis estructurado del caso mediante tres dimensiones de evaluación:
     * señales de alarma detectadas, factores de riesgo identificados y factores de
     * protección presentes. Este análisis sistemático permite objetivar la valoración
     * y fundamentar las decisiones sobre el nivel de intervención necesario.
     * </p>
     * <p>
     * Las tres dimensiones que integra son:
     * </p>
     * <ul>
     *   <li><strong>Señales de Alarma:</strong> Indicadores comportamentales, emocionales
     *       y comunicacionales que alertan sobre malestar psicológico significativo
     *       (clasificadas en directas e indirectas)</li>
     *   <li><strong>Factores de Riesgo:</strong> Elementos personales, familiares,
     *       sociales y educativos que incrementan la vulnerabilidad del alumno</li>
     *   <li><strong>Factores de Protección:</strong> Recursos, fortalezas y elementos
     *       del contexto que favorecen la resiliencia y el bienestar del alumno</li>
     * </ul>
     * <p>
     * Este componente estructurado es fundamental porque:
     * </p>
     * <ul>
     *   <li>Permite evaluar objetivamente el nivel de riesgo del caso</li>
     *   <li>Identifica áreas prioritarias de intervención (donde hay más riesgos)</li>
     *   <li>Reconoce fortalezas sobre las que construir la intervención</li>
     *   <li>Facilita la comunicación con otros profesionales mediante un lenguaje común</li>
     *   <li>Proporciona una base para evaluar la evolución del caso en el tiempo</li>
     *   <li>Fundamenta la toma de decisiones sobre el tipo de intervención necesaria</li>
     * </ul>
     * <p>
     * El campo se inicializa automáticamente (nunca es null) para facilitar
     * su uso desde la interfaz de usuario.
     * </p>
     *
     * @see Anexo5DTO
     * @see Anexo5SenalesAlarmaDTO
     * @see Anexo5FactoresRiesgoDTO
     * @see Anexo5FactoresProteccionDTO
     */
    private Anexo5DTO anexo5;

    /**
     * Referencia al alumno al que pertenece esta valoración.
     * <p>
     * Mantiene la asociación con la entidad principal de alumnado, permitiendo
     * acceder a la información básica del caso (código de alumno, datos personales,
     * otros pasos del protocolo) desde el contexto de la valoración.
     * </p>
     * <p>
     * Esta referencia es útil para:
     * </p>
     * <ul>
     *   <li>Contextualizar la valoración dentro del caso completo</li>
     *   <li>Facilitar la navegación entre diferentes pasos del protocolo</li>
     *   <li>Acceder a información complementaria durante el análisis</li>
     * </ul>
     */
    private Alumnado alumnado;

    /**
     * Constructor que crea un DTO a partir de una entidad Paso5.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una conversión completa de los dos anexos que conforman la valoración,
     * creando DTOs especializados para cada uno de ellos y preservando la referencia
     * al alumno.
     * </p>
     * <p>
     * El proceso de conversión crea copias profundas de los anexos, incluyendo
     * todos sus sub-componentes (en el caso del Anexo 5: señales de alarma,
     * factores de riesgo y factores de protección), desacoplando completamente
     * la capa de presentación de la capa de persistencia.
     * </p>
     *
     * @param paso5 entidad Paso5 de la que se copiarán los datos.
     *              Se convierten ambos anexos a sus DTOs correspondientes.
     */
    public Paso5DTO(Paso5 paso5) {
        this.anexo4 = new Anexo4DTO(paso5.getAnexo4());
        this.anexo5 = new Anexo5DTO(paso5.getAnexo5());
        this.alumnado = paso5.getAlumnado();
    }

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO inicializando ambos anexos como objetos
     * vacíos (no null). Esta inicialización es fundamental para evitar
     * NullPointerException al cumplimentar la valoración desde la interfaz de usuario,
     * ya que ambos anexos contienen estructuras complejas con múltiples campos
     * que deben estar disponibles para su edición.
     * </p>
     * <p>
     * La inicialización automática garantiza que:
     * </p>
     * <ul>
     *   <li>El Anexo 4 está listo para registrar las síntesis de las entrevistas</li>
     *   <li>El Anexo 5 tiene sus tres sub-componentes inicializados (señales de alarma,
     *       factores de riesgo y factores de protección)</li>
     *   <li>Los formularios pueden vincularse directamente a estos objetos sin
     *       verificaciones adicionales de nulidad</li>
     * </ul>
     */
    public Paso5DTO() {
        this.anexo4 = new Anexo4DTO();
        this.anexo5 = new Anexo5DTO();
    }
}