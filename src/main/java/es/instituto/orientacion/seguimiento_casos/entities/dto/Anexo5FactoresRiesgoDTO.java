package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5FactoresRiesgo;
import lombok.Data;

/**
 * DTO (Data Transfer Object) para los Factores de Riesgo del Anexo 5.
 * <p>
 * Este objeto de transferencia de datos representa los factores de riesgo identificados
 * en el alumno durante el análisis del caso. Los factores de riesgo son elementos,
 * circunstancias o características del contexto personal, familiar, escolar y social
 * que incrementan la vulnerabilidad del alumno y pueden comprometer su bienestar
 * físico, emocional o psicológico.
 * </p>
 * <p>
 * Los factores se organizan en tres categorías principales:
 * </p>
 * <ul>
 *   <li><strong>Personales:</strong> Características individuales, historial clínico y comportamientos del alumno</li>
 *   <li><strong>Familiares:</strong> Dinámicas, eventos y factores del entorno familiar</li>
 *   <li><strong>Sociales y Educativos:</strong> Contexto social, relacional y educativo del alumno</li>
 * </ul>
 * <p>
 * Cada factor se representa como un campo booleano que indica su presencia o ausencia,
 * permitiendo una evaluación estructurada que identifica áreas de vulnerabilidad
 * y orienta las estrategias de prevención e intervención.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Anexo5FactoresRiesgo
 * @see Anexo5DTO
 */
@Data
public class Anexo5FactoresRiesgoDTO {

    /**
     * Identificador único del registro de factores de riesgo.
     */
    private Long id;

    // ==================== FACTORES DE RIESGO - PERSONALES ====================

    /**
     * Intentos de suicidio previos.
     * <p>
     * Indica si el alumno ha realizado previamente intentos de quitarse la vida.
     * Este es uno de los factores de riesgo más significativos.
     * </p>
     */
    private Boolean intentosSuicidioPrevios;

    /**
     * Condición de discapacidad.
     * <p>
     * Indica si el alumno presenta alguna condición de discapacidad física,
     * sensorial, intelectual o del desarrollo que pueda aumentar su vulnerabilidad.
     * </p>
     */
    private Boolean condicionDiscapacidad;

    /**
     * Enfermedad grave o dolor crónico.
     * <p>
     * Indica si el alumno padece una enfermedad grave o experimenta dolor crónico
     * que afecta significativamente su calidad de vida.
     * </p>
     */
    private Boolean enfermedadGraveDolorCronico;

    /**
     * Trastornos relacionados con el uso de sustancias.
     * <p>
     * Indica si el alumno presenta problemas de abuso o dependencia de drogas,
     * alcohol u otras sustancias.
     * </p>
     */
    private Boolean trastornosSustancias;

    /**
     * Acceso a medios letales.
     * <p>
     * Indica si el alumno tiene acceso fácil a medios que puedan ser utilizados
     * para autolesionarse gravemente (medicamentos, armas, lugares elevados, etc.).
     * </p>
     */
    private Boolean accesoMediosLetales;

    /**
     * Impulsividad, agresividad o pesimismo marcado.
     * <p>
     * Indica si el alumno muestra rasgos de impulsividad, conductas agresivas
     * o una visión excesivamente pesimista de sí mismo y su futuro.
     * </p>
     */
    private Boolean impulsividadAgresividadPesimismo;

    /**
     * Historia de violencia o abuso.
     * <p>
     * Indica si el alumno ha sido víctima de violencia física, psicológica,
     * sexual o ha sufrido abusos de cualquier tipo.
     * </p>
     */
    private Boolean historiaViolenciaAbuso;

    /**
     * Sucesos vitales estresantes recientes.
     * <p>
     * Indica si el alumno ha experimentado recientemente eventos traumáticos
     * o muy estresantes (duelos, separaciones, mudanzas, etc.).
     * </p>
     */
    private Boolean sucesosVitalesEstresantes;

    /**
     * Perfeccionismo excesivo.
     * <p>
     * Indica si el alumno presenta niveles desadaptativos de perfeccionismo,
     * con autoexigencia excesiva y miedo al fracaso.
     * </p>
     */
    private Boolean perfeccionismoExcesivo;

    /**
     * Presencia de autolesiones.
     * <p>
     * Indica si el alumno se autolesiona deliberadamente (cortes, quemaduras, golpes)
     * como mecanismo de regulación emocional o expresión del malestar.
     * </p>
     */
    private Boolean autolesiones;

    /**
     * Conductas de aislamiento y soledad.
     * <p>
     * Indica si el alumno se aísla socialmente, evita el contacto con otros
     * y experimenta sentimientos persistentes de soledad.
     * </p>
     */
    private Boolean conductaAislamientoSoledad;

    /**
     * Intervención previa de servicios de salud mental.
     * <p>
     * Indica si el alumno ha sido atendido previamente por servicios de salud mental
     * por problemas psicológicos o psiquiátricos.
     * </p>
     */
    private Boolean serviciosSaludMental;

    /**
     * Abandono de tratamiento psicológico o psiquiátrico.
     * <p>
     * Indica si el alumno ha interrumpido un tratamiento de salud mental
     * sin completarlo o sin seguimiento adecuado.
     * </p>
     */
    private Boolean abandonoTratamiento;

    /**
     * Incumplimiento de prescripciones médicas.
     * <p>
     * Indica si el alumno no sigue las indicaciones médicas o no toma
     * la medicación prescrita de manera adecuada.
     * </p>
     */
    private Boolean noSeguirPrescripcion;

    /**
     * Rasgos de personalidad influyentes en el riesgo.
     * <p>
     * Indica si el alumno presenta características de personalidad que pueden
     * aumentar la vulnerabilidad (inestabilidad emocional, baja tolerancia a la frustración, etc.).
     * </p>
     */
    private Boolean personalidadInfluyente;

    /**
     * Uso inadecuado de las TIC (Tecnologías de la Información y Comunicación).
     * <p>
     * Indica si el alumno hace un uso problemático de dispositivos digitales,
     * redes sociales o internet (adicción, ciberacoso, exposición a contenidos nocivos).
     * </p>
     */
    private Boolean usoInadecuadoTic;

    /**
     * Rechazo a la imagen corporal o Trastornos de la Conducta Alimentaria (TCA).
     * <p>
     * Indica si el alumno presenta insatisfacción significativa con su imagen corporal
     * o síntomas de trastornos alimentarios (anorexia, bulimia, atracones).
     * </p>
     */
    private Boolean rechazoImagenCorporalTca;

    /**
     * Presencia de TEA, TDAH o altas capacidades.
     * <p>
     * Indica si el alumno presenta Trastorno del Espectro Autista (TEA),
     * Trastorno por Déficit de Atención e Hiperactividad (TDAH) o altas capacidades,
     * que pueden requerir apoyos específicos.
     * </p>
     */
    private Boolean presenciaTeaTdahCapacidades;

    // ==================== FACTORES DE RIESGO - FAMILIARES ====================

    /**
     * Pérdida grave reciente en el entorno familiar.
     * <p>
     * Indica si la familia ha experimentado recientemente una pérdida significativa
     * (fallecimiento, separación, pérdida de empleo, etc.).
     * </p>
     */
    private Boolean perdidaGraveReciente;

    /**
     * Historial familiar de suicidio.
     * <p>
     * Indica si existen antecedentes de suicidio en la familia, lo cual
     * incrementa significativamente el riesgo.
     * </p>
     */
    private Boolean historialFamiliarSuicidio;

    /**
     * Negligencia o estilos educativos inadecuados.
     * <p>
     * Indica si el alumno sufre negligencia parental o está expuesto a estilos
     * educativos disfuncionales (autoritarios, permisivos extremos, inconsistentes).
     * </p>
     */
    private Boolean negligenciaEstilosEducativos;

    /**
     * Abuso de sustancias o alcoholismo en la familia.
     * <p>
     * Indica si existen problemas de consumo de alcohol o drogas en el núcleo familiar
     * que afectan la dinámica y bienestar del hogar.
     * </p>
     */
    private Boolean abusosSustanciasAlcoholismo;

    /**
     * Estresores orupturas familiares.
     * <p>
     * Indica si la familia atraviesa conflictos graves, separaciones, divorcios
     * o situaciones que generan alta tensión en el hogar.
     * </p>
     */
    private Boolean estresoresRupturasFamiliares;

    /**
     * Familia con niveles elevados de perfeccionismo.
     * <p>
     * Indica si el entorno familiar mantiene expectativas excesivamente altas
     * y presiona al alumno hacia el perfeccionismo.
     * </p>
     */
    private Boolean familiaNivelesPerfeccionismo;

    /**
     * Desequilibrio en actividades domésticas y responsabilidades.
     * <p>
     * Indica si el alumno asume una carga excesiva de tareas domésticas o cuidado
     * de familiares que interfiere con su desarrollo normal.
     * </p>
     */
    private Boolean equilibrioActividadesDomesticas;

    // ==================== FACTORES DE RIESGO - SOCIALES Y EDUCATIVOS ====================

    /**
     * Falta o pérdida de red de apoyo social.
     * <p>
     * Indica si el alumno carece de una red de apoyo social adecuada o ha perdido
     * recientemente vínculos de apoyo importantes.
     * </p>
     */
    private Boolean faltaPerdidaRedApoyo;

    /**
     * Víctima de acoso o ciberacoso.
     * <p>
     * Indica si el alumno está siendo acosado, intimidado o agredido de forma
     * presencial o a través de medios digitales.
     * </p>
     */
    private Boolean victimaAcosoCiberacoso;

    /**
     * Rechazo social o maltrato entre iguales.
     * <p>
     * Indica si el alumno experimenta rechazo, exclusión o maltrato por parte
     * de sus compañeros en el contexto escolar o social.
     * </p>
     */
    private Boolean rechazoSocialMaltrato;

    /**
     * Desarraigo cultural.
     * <p>
     * Indica si el alumno experimenta dificultades de adaptación relacionadas
     * con diferencias culturales, migración o choque cultural.
     * </p>
     */
    private Boolean desarraigoCultural;

    /**
     * Estigma o exclusión del grupo.
     * <p>
     * Indica si el alumno sufre estigmatización o exclusión por características
     * específicas (orientación sexual, identidad de género, aspecto físico, origen, etc.).
     * </p>
     */
    private Boolean estigmaExclusionGrupo;

    /**
     * Ausencia de red de apoyo social efectiva.
     * <p>
     * Indica si el alumno no cuenta con personas o grupos que puedan brindar
     * apoyo emocional, instrumental o informativo cuando lo necesita.
     * </p>
     */
    private Boolean existenciaRedApoyoSocial;

    /**
     * Carencia de relaciones positivas con adultos.
     * <p>
     * Indica si el alumno no mantiene vínculos saludables con adultos de referencia
     * (profesores, familiares, mentores).
     * </p>
     */
    private Boolean buenasRelacionesAdultas;

    /**
     * Conflictos o falta de confianza en situaciones relacionales.
     * <p>
     * Indica si el alumno experimenta dificultades persistentes para confiar en otros
     * o mantiene conflictos frecuentes en sus relaciones.
     * </p>
     */
    private Boolean conflictoConfianzaSituaciones;

    /**
     * Falta de participación en entornos sociales y culturales positivos.
     * <p>
     * Indica si el alumno no participa en actividades sociales, culturales o deportivas
     * que favorezcan su integración y desarrollo.
     * </p>
     */
    private Boolean amigoSocialCultural;

    /**
     * Ausencia de proyecto social y educativo estructurado.
     * <p>
     * Indica si el centro educativo o el entorno no cuentan con programas o proyectos
     * que promuevan el bienestar y desarrollo integral del alumnado.
     * </p>
     */
    private Boolean existenciaProyectoSocialEducativo;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos booleanos sin inicializar,
     * utilizado principalmente en formularios nuevos.
     * </p>
     */
    public Anexo5FactoresRiesgoDTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Anexo5FactoresRiesgo.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los factores de riesgo identificados,
     * organizados en sus tres categorías: personales, familiares y sociales/educativos.
     * </p>
     *
     * @param entity entidad Anexo5FactoresRiesgo de la que se copiarán los datos.
     *               Si es null, los campos del DTO permanecerán sin inicializar.
     */
    public Anexo5FactoresRiesgoDTO(Anexo5FactoresRiesgo entity) {
        if (entity != null) {
            this.id = entity.getId();

            // Copiar factores personales
            this.intentosSuicidioPrevios = entity.getIntentosSuicidioPrevios();
            this.condicionDiscapacidad = entity.getCondicionDiscapacidad();
            this.enfermedadGraveDolorCronico = entity.getEnfermedadGraveDolorCronico();
            this.trastornosSustancias = entity.getTrastornosSustancias();
            this.accesoMediosLetales = entity.getAccesoMediosLetales();
            this.impulsividadAgresividadPesimismo = entity.getImpulsividadAgresividadPesimismo();
            this.historiaViolenciaAbuso = entity.getHistoriaViolenciaAbuso();
            this.sucesosVitalesEstresantes = entity.getSucesosVitalesEstresantes();
            this.perfeccionismoExcesivo = entity.getPerfeccionismoExcesivo();
            this.autolesiones = entity.getAutolesiones();
            this.conductaAislamientoSoledad = entity.getConductaAislamientoSoledad();
            this.serviciosSaludMental = entity.getServiciosSaludMental();
            this.abandonoTratamiento = entity.getAbandonoTratamiento();
            this.noSeguirPrescripcion = entity.getNoSeguirPrescripcion();
            this.personalidadInfluyente = entity.getPersonalidadInfluyente();
            this.usoInadecuadoTic = entity.getUsoInadecuadoTic();
            this.rechazoImagenCorporalTca = entity.getRechazoImagenCorporalTca();
            this.presenciaTeaTdahCapacidades = entity.getPresenciaTeaTdahCapacidades();

            // Copiar factores familiares
            this.perdidaGraveReciente = entity.getPerdidaGraveReciente();
            this.historialFamiliarSuicidio = entity.getHistorialFamiliarSuicidio();
            this.negligenciaEstilosEducativos = entity.getNegligenciaEstilosEducativos();
            this.abusosSustanciasAlcoholismo = entity.getAbusosSustanciasAlcoholismo();
            this.estresoresRupturasFamiliares = entity.getEstresoresRupturasFamiliares();
            this.familiaNivelesPerfeccionismo = entity.getFamiliaNivelesPerfeccionismo();
            this.equilibrioActividadesDomesticas = entity.getEquilibrioActividadesDomesticas();

            // Copiar factores sociales y educativos
            this.faltaPerdidaRedApoyo = entity.getFaltaPerdidaRedApoyo();
            this.victimaAcosoCiberacoso = entity.getVictimaAcosoCiberacoso();
            this.rechazoSocialMaltrato = entity.getRechazoSocialMaltrato();
            this.desarraigoCultural = entity.getDesarraigoCultural();
            this.estigmaExclusionGrupo = entity.getEstigmaExclusionGrupo();
            this.existenciaRedApoyoSocial = entity.getExistenciaRedApoyoSocial();
            this.buenasRelacionesAdultas = entity.getBuenasRelacionesAdultas();
            this.conflictoConfianzaSituaciones = entity.getConflictoConfianzaSituaciones();
            this.amigoSocialCultural = entity.getAmigoSocialCultural();
            this.existenciaProyectoSocialEducativo = entity.getExistenciaProyectoSocialEducativo();
        }
    }
}