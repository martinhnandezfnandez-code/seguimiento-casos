package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso7;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Paso 7 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 7 - Plan Individualizado de Intervención,
 * que constituye el núcleo operativo del protocolo de seguimiento. Es el documento más extenso
 * y completo del protocolo, ya que integra toda la información recogida en los pasos anteriores
 * para diseñar un plan de actuación específico, personalizado y coordinado que responda a las
 * necesidades concretas del alumno.
 * </p>
 * <p>
 * El plan se estructura en varios bloques:
 * </p>
 * <ul>
 *   <li><strong>Identificación y objetivos:</strong> Datos del alumno y objetivos de la intervención</li>
 *   <li><strong>Organización del seguimiento:</strong> Equipo responsable, calendario y herramientas</li>
 *   <li><strong>Medidas generales:</strong> Prevención, protección y acompañamiento emocional</li>
 *   <li><strong>Actuaciones específicas por agentes:</strong> Intervenciones diferenciadas según roles</li>
 *   <li><strong>Coordinación externa:</strong> Actuaciones con familia y servicios externos</li>
 *   <li><strong>Metadatos:</strong> Autoría y fecha de elaboración del plan</li>
 * </ul>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso7}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso7
 */
@Data
public class Paso7DTO {

    // ==================== IDENTIFICACIÓN ====================

    /**
     * Identificador único del plan individualizado.
     */
    private Long id;

    /**
     * Referencia al alumno al que se aplica este plan individualizado.
     * <p>
     * Mantiene la asociación con la entidad principal de alumnado.
     * </p>
     */
    private Alumnado alumnado;

    /**
     * Código identificador del alumno.
     * <p>
     * Código único que identifica al alumno en el sistema educativo,
     * facilitando la referencia cruzada con otros documentos y sistemas.
     * </p>
     */
    private String codigoAlumno;

    // ==================== OBJETIVOS ====================

    /**
     * Objetivo general del plan individualizado.
     * <p>
     * Objetivo principal y global que se pretende alcanzar con la intervención,
     * expresado de forma clara, realista y relacionado directamente con el bienestar
     * y desarrollo del alumno.
     * </p>
     */
    private String objetivoGeneral;

    /**
     * Objetivos específicos del plan individualizado.
     * <p>
     * Conjunto de objetivos concretos, medibles y alcanzables que desglosan
     * el objetivo general en metas más específicas. Cada objetivo debe ser
     * verificable y tener criterios claros de consecución.
     * </p>
     *
     */
    private String objetivosEspecificos;

    // ==================== ORGANIZACIÓN DEL SEGUIMIENTO ====================

    /**
     * Equipo de acompañamiento del alumno.
     * <p>
     * Listado de profesionales y personas que conforman el equipo responsable
     * del seguimiento y acompañamiento del alumno, especificando sus roles.
     * </p>
     *
     */
    private String equipoAcompanamiento;

    /**
     * Calendario de seguimiento del plan.
     * <p>
     * Planificación temporal de las reuniones de seguimiento, evaluaciones periódicas
     * y revisiones del plan. Define la frecuencia y fechas de valoración de la efectividad
     * de las medidas adoptadas.
     * </p>
     *
     */
    private String calendarioSeguimiento;

    /**
     * Indica si se dispone de repositorio de antecedentes del caso.
     * <p>
     * Especifica si existe un archivo organizado con toda la documentación
     * previa relacionada con el alumno (informes anteriores, valoraciones,
     * actuaciones previas, etc.).
     * </p>
     */
    private Boolean tieneRepositorioAntecedentes;

    /**
     * Indica si existe un cronograma formalizado de actuaciones.
     * <p>
     * Especifica si se ha elaborado un cronograma detallado (Paso 2) con
     * todas las actuaciones planificadas y realizadas de forma estructurada.
     * </p>
     */
    private Boolean tieneCronogramaFormalizado;

    /**
     * Indica si el plan se gestiona en formato digital.
     * <p>
     * Especifica si toda la documentación del plan se mantiene en formato
     * digital, facilitando su acceso, actualización y compartición entre
     * los profesionales implicados.
     * </p>
     */
    private Boolean esFormatoDigital;

    // ==================== MEDIDAS GENERALES ====================

    /**
     * Medidas de prevención general adoptadas.
     * <p>
     * Actuaciones preventivas de carácter general implementadas en el centro
     * o en el aula para crear un entorno protector y favorable para el alumno.
     * </p>
     */
    private String medidasPrevencionGeneral;

    /**
     * Medidas específicas de protección y seguridad.
     * <p>
     * Actuaciones concretas destinadas a garantizar la seguridad física y emocional
     * del alumno, minimizando riesgos y proporcionando un entorno seguro.
     * </p>
     */
    private String medidasProteccionSeguridad;

    /**
     * Medidas de acompañamiento emocional.
     * <p>
     * Actuaciones específicas para proporcionar apoyo emocional al alumno,
     * ayudarle a gestionar sus emociones y fortalecer su bienestar psicológico.
     * </p>
     *
     */
    private String medidasAcompanamientoEmocional;

    /**
     * Otras medidas adoptadas no contempladas en categorías anteriores.
     * <p>
     * Campo para documentar medidas adicionales específicas del caso que no
     * encajan en las categorías previas pero son relevantes para la intervención.
     * </p>
     */
    private String otrasMedidasAdoptadas;

    /**
     * Información proporcionada al equipo docente.
     * <p>
     * Detalle de la información compartida con el equipo docente sobre la situación
     * del alumno, las necesidades detectadas y las pautas de actuación recomendadas,
     * respetando siempre la confidencialidad y compartiendo solo lo necesario.
     * </p>
     */
    private String informacionEquipoDocente;

    /**
     * Planificación de la observación y atención al alumno.
     * <p>
     * Estrategia para la observación sistemática del alumno en diferentes contextos
     * escolares (aula, recreo, actividades) y para proporcionarle atención específica
     * cuando lo necesite.
     * </p>
     */
    private String planificacionObservacionAtencion;

    // ==================== ACTUACIONES ESPECÍFICAS POR AGENTES ====================

    /**
     * Acciones específicas del tutor o tutora.
     * <p>
     * Actuaciones concretas que desarrollará el tutor como figura de referencia
     * directa del alumno en el día a día escolar.
     * </p>
     *
     */
    private String accionesTutor;

    /**
     * Intervención del equipo docente.
     * <p>
     * Actuaciones coordinadas que desarrollará el conjunto del profesorado
     * que imparte clase al alumno.
     * </p>
     *
     */
    private String intervencionEquipoDocente;

    /**
     * Intervención del departamento u equipo de orientación.
     * <p>
     * Actuaciones especializadas que desarrollará el servicio de orientación
     * educativa y psicopedagógica.
     * </p>
     *
     */
    private String intervencionOrientacion;

    /**
     * Intervención de otros trabajadores del centro.
     * <p>
     * Actuaciones de otros profesionales del centro educativo (trabajador social,
     * educador social, monitor, personal de apoyo, etc.).
     * </p>
     *
     */
    private String intervencionOtrosTrabajadores;

    /**
     * Estrategias de acompañamiento por compañeros.
     * <p>
     * Actuaciones que implican a compañeros del alumno como agentes de apoyo,
     * promoviendo la ayuda entre iguales y el sentido de pertenencia al grupo.
     * </p>
     *
     */
    private String acompanamientoCompaneros;

    /**
     * Actividades de sensibilización en el aula.
     * <p>
     * Actuaciones educativas con el grupo-clase orientadas a crear un clima
     * de respeto, empatía y apoyo mutuo.
     * </p>
     *
     */
    private String actividadesSensibilizacionAula;

    /**
     * Formación específica del profesorado.
     * <p>
     * Acciones formativas dirigidas al equipo docente para mejorar su capacitación
     * en la detección, acompañamiento y gestión de situaciones similares.
     * </p>
     *
     */
    private String formacionProfesorado;

    // ==================== COORDINACIÓN EXTERNA ====================

    /**
     * Actuaciones coordinadas con la familia.
     * <p>
     * Compromisos, acuerdos y actuaciones que se desarrollarán en coordinación
     * con la familia del alumno, fundamentales para la coherencia y efectividad
     * de la intervención.
     * </p>
     *
     */
    private String actuacionesFamilia;

    /**
     * Actuaciones coordinadas con servicios externos.
     * <p>
     * Coordinación con recursos comunitarios y servicios especializados externos
     * al centro educativo (salud mental, servicios sociales, entidades del tercer sector).
     * </p>
     *
     */
    private String actuacionesServiciosExternos;

    // ==================== METADATOS ====================

    /**
     * Profesional o profesionales que elaboraron el plan.
     * <p>
     * Identificación de la persona o equipo responsable de la elaboración
     * del plan individualizado, asumiendo la autoría del documento.
     * </p>
     *
     */
    private String elaboradoPor;

    /**
     * Fecha de elaboración del plan individualizado.
     * <p>
     * Marca temporal que registra cuándo se diseñó y formalizó el plan.
     * Es importante para establecer la vigencia del plan y programar
     * las revisiones periódicas.
     * </p>
     */
    private LocalDate fechaElaboracion;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al comenzar a diseñar un nuevo plan individualizado.
     * </p>
     */
    public Paso7DTO() {}

    /**
     * Constructor que crea un DTO a partir de una entidad Paso7.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia exhaustiva de todos los campos que componen el plan
     * individualizado, incluyendo identificación, objetivos, organización,
     * medidas generales, actuaciones específicas de cada agente, coordinación
     * externa y metadatos.
     * </p>
     * <p>
     * Dada la extensión del Paso 7, este constructor maneja
     * un número significativo de campos que abarcan todas las dimensiones
     * de la intervención planificada.
     * </p>
     *
     * @param paso7 entidad Paso7 de la que se copiarán los datos.
     *              Si es null, los campos del DTO permanecerán sin inicializar.
     */
    public Paso7DTO(Paso7 paso7) {
        if (paso7 != null) {
            // Identificación
            this.id = paso7.getId();
            this.codigoAlumno = paso7.getCodigoAlumno();
            this.alumnado = paso7.getAlumnado();

            // Objetivos
            this.objetivoGeneral = paso7.getObjetivoGeneral();
            this.objetivosEspecificos = paso7.getObjetivosEspecificos();

            // Organización del seguimiento
            this.equipoAcompanamiento = paso7.getEquipoAcompanamiento();
            this.calendarioSeguimiento = paso7.getCalendarioSeguimiento();
            this.tieneRepositorioAntecedentes = paso7.getTieneRepositorioAntecedentes();
            this.tieneCronogramaFormalizado = paso7.getTieneCronogramaFormalizado();
            this.esFormatoDigital = paso7.getEsFormatoDigital();

            // Medidas generales
            this.medidasPrevencionGeneral = paso7.getMedidasPrevencionGeneral();
            this.medidasProteccionSeguridad = paso7.getMedidasProteccionSeguridad();
            this.medidasAcompanamientoEmocional = paso7.getMedidasAcompanamientoEmocional();
            this.otrasMedidasAdoptadas = paso7.getOtrasMedidasAdoptadas();
            this.informacionEquipoDocente = paso7.getInformacionEquipoDocente();
            this.planificacionObservacionAtencion = paso7.getPlanificacionObservacionAtencion();

            // Actuaciones específicas por agentes
            this.accionesTutor = paso7.getAccionesTutor();
            this.intervencionEquipoDocente = paso7.getIntervencionEquipoDocente();
            this.intervencionOrientacion = paso7.getIntervencionOrientacion();
            this.intervencionOtrosTrabajadores = paso7.getIntervencionOtrosTrabajadores();
            this.acompanamientoCompaneros = paso7.getAcompanamientoCompaneros();
            this.actividadesSensibilizacionAula = paso7.getActividadesSensibilizacionAula();
            this.formacionProfesorado = paso7.getFormacionProfesorado();

            // Coordinación externa
            this.actuacionesFamilia = paso7.getActuacionesFamilia();
            this.actuacionesServiciosExternos = paso7.getActuacionesServiciosExternos();

            // Metadatos
            this.elaboradoPor = paso7.getElaboradoPor();
            this.fechaElaboracion = paso7.getFechaElaboracion();
        }
    }
}