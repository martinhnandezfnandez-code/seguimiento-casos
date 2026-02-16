package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5FactoresProteccion;
import lombok.Data;

/**
 * DTO (Data Transfer Object) para los Factores de Protección del Anexo 5.
 * <p>
 * Este objeto de transferencia de datos representa los factores de protección identificados
 * en el alumno durante el análisis del caso. Los factores de protección son elementos,
 * características o recursos del contexto personal, familiar, escolar y social que actúan
 * como fortalezas, favorecen la resiliencia y contribuyen positivamente al bienestar
 * y desarrollo saludable del alumno.
 * </p>
 * <p>
 * Los factores se organizan en tres categorías principales:
 * </p>
 * <ul>
 *   <li><strong>Personales:</strong> Habilidades, actitudes y características individuales del alumno</li>
 *   <li><strong>Familiares:</strong> Dinámicas y recursos del entorno familiar</li>
 *   <li><strong>Sociales y Educativos:</strong> Redes de apoyo y contexto socioeducativo</li>
 * </ul>
 * <p>
 * Cada factor se representa como un campo booleano que indica su presencia o ausencia,
 * permitiendo una evaluación estructurada que complementa el análisis de riesgos
 * y orienta las estrategias de intervención basadas en fortalezas.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Anexo5FactoresProteccion
 * @see Anexo5DTO
 */
@Data
public class Anexo5FactoresProteccionDTO {

    /**
     * Identificador único del registro de factores de protección.
     */
    private Long id;

    // ==================== FACTORES DE PROTECCIÓN - PERSONALES ====================

    /**
     * Habilidades para la gestión emocional.
     * <p>
     * Indica si el alumno posee capacidades para identificar, comprender
     * y regular sus propias emociones de manera adecuada.
     * </p>
     */
    private Boolean habilidadesGestionEmocional;

    /**
     * Habilidades de comunicación y relación.
     * <p>
     * Indica si el alumno cuenta con competencias para expresarse efectivamente
     * y establecer relaciones interpersonales saludables.
     * </p>
     */
    private Boolean habilidadesComunicacionRelacion;

    /**
     * Autoconcepto y autoestima saludables.
     * <p>
     * Indica si el alumno mantiene una imagen positiva de sí mismo
     * y un nivel adecuado de valoración personal.
     * </p>
     */
    private Boolean autoconceptoAutoestimaSaludables;

    /**
     * Actitudes positivas en la relación interpersonal.
     * <p>
     * Indica si el alumno muestra disposiciones favorables hacia los demás,
     * como empatía, respeto y colaboración.
     * </p>
     */
    private Boolean actitudesRelacionInterpersonal;

    /**
     * Hábitos personales saludables.
     * <p>
     * Indica si el alumno mantiene rutinas y hábitos que favorecen
     * su bienestar físico y mental (sueño, alimentación, higiene, ejercicio).
     * </p>
     */
    private Boolean habitosPersonalesSaludables;

    /**
     * Uso adecuado de las TIC (Tecnologías de la Información y Comunicación).
     * <p>
     * Indica si el alumno hace un uso responsable, equilibrado y seguro
     * de dispositivos digitales y redes sociales.
     * </p>
     */
    private Boolean usoAdecuadoTic;

    /**
     * Características personales que transmiten tranquilidad.
     * <p>
     * Indica si el alumno presenta rasgos de personalidad que favorecen
     * la estabilidad emocional, como paciencia, serenidad o reflexividad.
     * </p>
     */
    private Boolean caracteristicasPersonalesTranquilidad;

    /**
     * Rendimiento escolar adecuado.
     * <p>
     * Indica si el alumno mantiene un desempeño académico satisfactorio
     * y acorde a sus capacidades.
     * </p>
     */
    private Boolean rendimientoEscolarAdecuado;

    /**
     * Sentimiento positivo de pertenencia al centro educativo.
     * <p>
     * Indica si el alumno se siente parte de la comunidad educativa
     * y mantiene un vínculo positivo con su centro.
     * </p>
     */
    private Boolean sentimientoPositivoPertenencia;

    /**
     * Vinculación con proyectos personales.
     * <p>
     * Indica si el alumno tiene metas, intereses o proyectos que le motivan
     * y le proporcionan sentido de propósito.
     * </p>
     */
    private Boolean vinculacionProyectosPersonales;

    /**
     * Relaciones familiares adecuadas.
     * <p>
     * Indica si el alumno mantiene vínculos familiares saludables,
     * caracterizados por comunicación, afecto y apoyo mutuo.
     * </p>
     */
    private Boolean relacionesFamiliaresAdecuadas;

    /**
     * Vínculos de apoyo estables.
     * <p>
     * Indica si el alumno cuenta con relaciones consistentes y de confianza
     * con personas significativas (familiares, amigos, mentores).
     * </p>
     */
    private Boolean vinculosApoyoEstables;

    /**
     * Estilos educativos modulados en el entorno familiar.
     * <p>
     * Indica si la familia emplea estrategias educativas equilibradas,
     * que combinan afecto, normas claras y respeto a la autonomía del menor.
     * </p>
     */
    private Boolean estilosEducativosModulados;

    // ==================== FACTORES DE PROTECCIÓN - FAMILIARES ====================

    /**
     * Equilibrio entre actividades relacionadas con el ámbito familiar.
     * <p>
     * Indica si existe un balance adecuado entre tiempo familiar,
     * actividades compartidas y espacios de autonomía personal.
     * </p>
     */
    private Boolean equilibrioActividadesRelacionadas;

    // ==================== FACTORES DE PROTECCIÓN - SOCIALES Y EDUCATIVOS ====================

    /**
     * Existencia de red de apoyo social.
     * <p>
     * Indica si el alumno cuenta con una red de personas e instituciones
     * que pueden brindar apoyo emocional, instrumental o informativo.
     * </p>
     */
    private Boolean existenciaRedApoyoSocial;

    /**
     * Buenas relaciones con adultos de referencia.
     * <p>
     * Indica si el alumno mantiene vínculos positivos con adultos
     * significativos (profesores, orientadores, familiares, entrenadores).
     * </p>
     */
    private Boolean buenasRelacionesAdultas;

    /**
     * Contar con una referencia adulta de confianza.
     * <p>
     * Indica si el alumno tiene al menos una persona adulta con quien
     * puede hablar abiertamente y en quien confía plenamente.
     * </p>
     */
    private Boolean contarReferenciaConfianza;

    /**
     * Participación en entorno social y cultural positivo.
     * <p>
     * Indica si el alumno participa en actividades sociales, culturales
     * o deportivas que favorecen su desarrollo y sentido de pertenencia.
     * </p>
     */
    private Boolean amigoSocialCultural;

    /**
     * Existencia de proyecto social y educativo estructurado.
     * <p>
     * Indica si el centro educativo y/o el entorno social cuentan con
     * programas o proyectos que promueven el bienestar y desarrollo integral
     * del alumnado.
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
    public Anexo5FactoresProteccionDTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Anexo5FactoresProteccion.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los factores de protección identificados,
     * organizados en sus tres categorías: personales, familiares y sociales/educativos.
     * </p>
     *
     * @param entity entidad Anexo5FactoresProteccion de la que se copiarán los datos.
     *               Si es null, los campos del DTO permanecerán sin inicializar.
     */
    public Anexo5FactoresProteccionDTO(Anexo5FactoresProteccion entity) {
        if (entity != null) {
            this.id = entity.getId();

            // Copiar factores personales
            this.habilidadesGestionEmocional = entity.getHabilidadesGestionEmocional();
            this.habilidadesComunicacionRelacion = entity.getHabilidadesComunicacionRelacion();
            this.autoconceptoAutoestimaSaludables = entity.getAutoconceptoAutoestimaSaludables();
            this.actitudesRelacionInterpersonal = entity.getActitudesRelacionInterpersonal();
            this.habitosPersonalesSaludables = entity.getHabitosPersonalesSaludables();
            this.usoAdecuadoTic = entity.getUsoAdecuadoTic();
            this.caracteristicasPersonalesTranquilidad = entity.getCaracteristicasPersonalesTranquilidad();
            this.rendimientoEscolarAdecuado = entity.getRendimientoEscolarAdecuado();
            this.sentimientoPositivoPertenencia = entity.getSentimientoPositivoPertenencia();
            this.vinculacionProyectosPersonales = entity.getVinculacionProyectosPersonales();
            this.relacionesFamiliaresAdecuadas = entity.getRelacionesFamiliaresAdecuadas();
            this.vinculosApoyoEstables = entity.getVinculosApoyoEstables();
            this.estilosEducativosModulados = entity.getEstilosEducativosModulados();

            // Copiar factores familiares
            this.equilibrioActividadesRelacionadas = entity.getEquilibrioActividadesRelacionadas();

            // Copiar factores sociales y educativos
            this.existenciaRedApoyoSocial = entity.getExistenciaRedApoyoSocial();
            this.buenasRelacionesAdultas = entity.getBuenasRelacionesAdultas();
            this.contarReferenciaConfianza = entity.getContarReferenciaConfianza();
            this.amigoSocialCultural = entity.getAmigoSocialCultural();
            this.existenciaProyectoSocialEducativo = entity.getExistenciaProyectoSocialEducativo();
        }
    }
}