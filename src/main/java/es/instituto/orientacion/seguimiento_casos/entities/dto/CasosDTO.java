package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para la visualización de casos en listados.
 * <p>
 * Este objeto de transferencia de datos representa un caso completo de seguimiento
 * optimizado para su presentación en listados, tablas y vistas resumidas de la aplicación.
 * A diferencia de {@link FormularioDTO} que se utiliza para la edición completa de casos,
 * CasosDTO está diseñado específicamente para consultas y visualizaciones donde se necesita
 * acceso a toda la información del caso sin la complejidad de la edición.
 * </p>
 * <p>
 * <strong>Diferencias clave con FormularioDTO:</strong>
 * </p>
 * <ul>
 *   <li><strong>Propósito:</strong> CasosDTO es para visualización/consulta, FormularioDTO para edición</li>
 *   <li><strong>Metadatos adicionales:</strong> CasosDTO incluye fechas de auditoría (creación y actualización)
 *       que son útiles para ordenar y filtrar casos en listados</li>
 *   <li><strong>Construcción:</strong> CasosDTO puede construirse paso a paso desde entidades individuales,
 *       permitiendo mayor control sobre qué datos cargar en consultas de rendimiento</li>
 *   <li><strong>Uso típico:</strong> Listados de casos, tablas de seguimiento, dashboards, exportaciones</li>
 * </ul>
 * <p>
 * Este DTO es fundamental para:
 * </p>
 * <ul>
 *   <li>Presentar listados de casos con información completa pero optimizada</li>
 *   <li>Facilitar el filtrado y ordenación de casos por fechas de creación/actualización</li>
 *   <li>Proporcionar acceso de solo lectura a toda la información del protocolo</li>
 *   <li>Generar exportaciones y reportes con datos completos de múltiples casos</li>
 *   <li>Mostrar vistas resumidas donde el usuario puede consultar cualquier paso del protocolo</li>
 * </ul>
 * <p>
 * Al igual que FormularioDTO, garantiza que todos los sub-DTOs de los pasos estén siempre
 * inicializados (nunca null), evitando NullPointerException al acceder a información de
 * cualquier paso del protocolo desde la interfaz de usuario.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Alumnado
 * @see FormularioDTO
 * @see Paso1DTO
 * @see Paso2DTO
 * @see Paso3DTO
 * @see Paso4DTO
 * @see Paso5DTO
 * @see Paso6DTO
 * @see Paso7DTO
 * @see Paso8DTO
 * @see Paso9DTO
 * @see Paso10DTO
 * @see Paso11DTO
 */
@Data
public class CasosDTO {

    // ==================== IDENTIFICACIÓN DEL CASO ====================

    /**
     * Identificador único del caso en el sistema.
     * <p>
     * Clave primaria que identifica de forma única este caso de seguimiento
     * en la base de datos.
     * </p>
     */
    private Long id;

    /**
     * Identificador del caso para referencias externas.
     * <p>
     * Código alfanumérico utilizado para referenciar el caso en documentación
     * externa o sistemas complementarios.
     * </p>
     */
    private String idCaso;

    /**
     * Identificador del documento principal del caso.
     * <p>
     * Número de referencia del expediente asociado en el sistema de archivo
     * del centro educativo.
     * </p>
     */
    private Integer idDocumento;

    /**
     * Código único del alumno en el sistema educativo.
     * <p>
     * Identificador oficial del alumno que permite su referencia cruzada
     * con otros sistemas y documentos oficiales.
     * </p>
     */
    private String codigoAlumno;

    // ==================== PASOS DEL PROTOCOLO ====================

    /**
     * DTO del Paso 1 - Detección y registro inicial.
     * <p>
     * Contiene información sobre cómo se detectó el caso, quién lo comunicó,
     * indicadores de riesgo iniciales y detalle de los hechos.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso1DTO
     */
    private Paso1DTO paso1DTO;

    /**
     * DTO del Paso 2 - Cronograma de actuaciones.
     * <p>
     * Contiene la planificación temporal de actuaciones y el cronograma
     * de seguimiento del caso.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso2DTO
     */
    private Paso2DTO paso2DTO;

    /**
     * DTO del Paso 3 - Medidas provisionales.
     * <p>
     * Documenta las actuaciones inmediatas adoptadas para garantizar
     * la seguridad del alumno.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso3DTO
     */
    private Paso3DTO paso3DTO;

    /**
     * DTO del Paso 4 - Acta de reunión con la familia.
     * <p>
     * Documenta los encuentros con las familias y los acuerdos alcanzados.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso4DTO
     */
    private Paso4DTO paso4DTO;

    /**
     * DTO del Paso 5 - Valoración y análisis del caso.
     * <p>
     * Contiene la valoración completa mediante Anexo 4 (entrevistas) y
     * Anexo 5 (análisis estructurado).
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso5DTO
     */
    private Paso5DTO paso5DTO;

    /**
     * DTO del Paso 6 - Resolución.
     * <p>
     * Documenta la decisión adoptada sobre el caso y los agentes implicados.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso6DTO
     */
    private Paso6DTO paso6DTO;

    /**
     * DTO del Paso 7 - Plan individualizado de intervención.
     * <p>
     * Contiene el plan completo de actuación con objetivos, medidas y
     * actuaciones coordinadas.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso7DTO
     */
    private Paso7DTO paso7DTO;

    /**
     * DTO del Paso 8 - Seguimiento de medidas.
     * <p>
     * Registra el seguimiento de las medidas implementadas.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso8DTO
     */
    private Paso8DTO paso8DTO;

    /**
     * DTO del Paso 9 - Información a dirección.
     * <p>
     * Documenta la comunicación del caso a la dirección del centro.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso9DTO
     */
    private Paso9DTO paso9DTO;

    /**
     * DTO del Paso 10 - Seguimiento por inspección.
     * <p>
     * Registra las actuaciones del servicio de inspección educativa.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso10DTO
     */
    private Paso10DTO paso10DTO;

    /**
     * DTO del Paso 11 - Cierre del caso y seguimiento institucional.
     * <p>
     * Documenta el cierre formal y los seguimientos posteriores.
     * Siempre inicializado (nunca null).
     * </p>
     *
     * @see Paso11DTO
     */
    private Paso11DTO paso11DTO;

    // ==================== INFORMACIÓN ADICIONAL Y METADATOS ====================

    /**
     * Observaciones generales sobre el caso.
     * <p>
     * Campo de texto libre para anotaciones adicionales que no encajan
     * en ningún paso específico del protocolo.
     * </p>
     */
    private String observaciones;

    /**
     * Fecha y hora de creación del caso en el sistema.
     * <p>
     * Marca temporal establecida automáticamente al crear el registro,
     * útil para:
     * </p>
     * <ul>
     *   <li>Ordenar casos por antigüedad</li>
     *   <li>Identificar casos recientes</li>
     *   <li>Generar estadísticas temporales de apertura de casos</li>
     *   <li>Auditar el historial del sistema</li>
     * </ul>
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha y hora de la última actualización del caso.
     * <p>
     * Marca temporal actualizada automáticamente cada vez que se modifica
     * cualquier aspecto del caso, útil para:
     * </p>
     * <ul>
     *   <li>Identificar casos con actividad reciente</li>
     *   <li>Ordenar casos por última modificación</li>
     *   <li>Detectar casos que llevan tiempo sin actualizarse</li>
     *   <li>Facilitar el seguimiento de la actividad del equipo</li>
     *   <li>Auditar cambios en el sistema</li>
     * </ul>
     */
    private LocalDateTime fechaUltimaActualizacion;

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor principal que crea un CasosDTO completo desde entidades individuales.
     * <p>
     * Este constructor es utilizado principalmente en consultas donde se cargan por separado
     * la entidad Alumnado y cada uno de sus pasos asociados. Proporciona flexibilidad para
     * construir el DTO de forma optimizada, permitiendo cargar solo los datos necesarios
     * o aplicar estrategias de carga específicas según las necesidades de rendimiento.
     * </p>
     * <p>
     * <strong>Ventajas de este constructor:</strong>
     * </p>
     * <ul>
     *   <li>Permite control granular sobre qué entidades se cargan de base de datos</li>
     *   <li>Facilita optimizaciones de consultas para listados grandes</li>
     *   <li>Soporta diferentes estrategias de carga (eager, lazy) según el contexto</li>
     *   <li>Evita cargas innecesarias cuando solo se necesitan ciertos pasos</li>
     * </ul>
     * <p>
     * <strong>Proceso de construcción:</strong>
     * </p>
     * <ol>
     *   <li>Para cada paso del protocolo:
     *     <ul>
     *       <li>Si la entidad no es null: crea el DTO correspondiente mediante conversión</li>
     *       <li>Si la entidad es null: crea un DTO vacío pero inicializado</li>
     *     </ul>
     *   </li>
     *   <li>Copia los datos de identificación y metadatos desde la entidad Alumnado</li>
     * </ol>
     * <p>
     * Este enfoque garantiza que todos los DTOs de pasos estén siempre inicializados,
     * incluso cuando no existen las entidades correspondientes en base de datos,
     * evitando NullPointerException al renderizar vistas.
     * </p>
     *
     * @param alumno entidad Alumnado con datos básicos e identificación del caso
     * @param paso1 entidad Paso1 o null si no existe
     * @param paso2 entidad Paso2 o null si no existe
     * @param paso3 entidad Paso3 o null si no existe
     * @param paso4 entidad Paso4 o null si no existe
     * @param paso5 entidad Paso5 o null si no existe
     * @param paso6 entidad Paso6 o null si no existe
     * @param paso7 entidad Paso7 o null si no existe
     * @param paso8 entidad Paso8 o null si no existe
     * @param paso9 entidad Paso9 o null si no existe
     * @param paso10 entidad Paso10 o null si no existe
     * @param paso11 entidad Paso11 o null si no existe
     */
    public CasosDTO(Alumnado alumno, Paso1 paso1, Paso2 paso2, Paso3 paso3, Paso4 paso4,
                    Paso5 paso5, Paso6 paso6, Paso7 paso7, Paso8 paso8, Paso9 paso9,
                    Paso10 paso10, Paso11 paso11) {
        // Convertir pasos del protocolo (si existen) o crear DTOs vacíos
        this.paso1DTO = (paso1 != null) ? new Paso1DTO(paso1) : new Paso1DTO();
        this.paso2DTO = (paso2 != null) ? new Paso2DTO(paso2) : new Paso2DTO();
        this.paso3DTO = (paso3 != null) ? new Paso3DTO(paso3) : new Paso3DTO();
        this.paso4DTO = (paso4 != null) ? new Paso4DTO(paso4) : new Paso4DTO();
        this.paso5DTO = (paso5 != null) ? new Paso5DTO(paso5) : new Paso5DTO();
        this.paso6DTO = (paso6 != null) ? new Paso6DTO(paso6) : new Paso6DTO();
        this.paso7DTO = (paso7 != null) ? new Paso7DTO(paso7) : new Paso7DTO();
        this.paso8DTO = (paso8 != null) ? new Paso8DTO(paso8) : new Paso8DTO();
        this.paso9DTO = (paso9 != null) ? new Paso9DTO(paso9) : new Paso9DTO();
        this.paso10DTO = (paso10 != null) ? new Paso10DTO(paso10) : new Paso10DTO();
        this.paso11DTO = (paso11 != null) ? new Paso11DTO(paso11) : new Paso11DTO();

        // Copiar datos de identificación y metadatos desde Alumnado
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();
        this.fechaCreacion = alumno.getFechaCreacion();
        this.fechaUltimaActualizacion = alumno.getFechaUltimaActualizacion();
        this.observaciones = alumno.getObservaciones();
        this.codigoAlumno = alumno.getCodigoAlumno();
    }

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del CasosDTO inicializando todos los pasos del protocolo
     * como objetos vacíos (no null). Esta inicialización exhaustiva garantiza que no se
     * produzcan errores al acceder a propiedades de cualquier paso desde la interfaz de usuario.
     * </p>
     * <p>
     * Este constructor se utiliza en situaciones donde:
     * </p>
     * <ul>
     *   <li>Se necesita un DTO vacío como placeholder</li>
     *   <li>Se va a poblar el DTO programáticamente campo por campo</li>
     *   <li>Se requiere un objeto inicializado para binding en frameworks</li>
     * </ul>
     * <p>
     * Aunque menos común que el constructor parametrizado en el contexto de listados,
     * es útil para ciertos escenarios de construcción dinámica de DTOs.
     * </p>
     */
    public CasosDTO() {
        super();
        this.paso1DTO = new Paso1DTO();
        this.paso2DTO = new Paso2DTO();
        this.paso3DTO = new Paso3DTO();
        this.paso4DTO = new Paso4DTO();
        this.paso5DTO = new Paso5DTO();
        this.paso6DTO = new Paso6DTO();
        this.paso7DTO = new Paso7DTO();
        this.paso8DTO = new Paso8DTO();
        this.paso9DTO = new Paso9DTO();
        this.paso10DTO = new Paso10DTO();
        this.paso11DTO = new Paso11DTO();
    }
}