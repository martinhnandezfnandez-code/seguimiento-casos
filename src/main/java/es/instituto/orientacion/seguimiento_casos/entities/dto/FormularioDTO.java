package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso7;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO (Data Transfer Object) maestro que representa el formulario completo del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos actúa como contenedor principal de toda la información
 * del protocolo de seguimiento de casos de alumnado. Integra los 11 pasos del protocolo mediante
 * sus respectivos DTOs especializados, proporcionando una visión unificada y completa del caso
 * desde su detección inicial hasta su cierre y seguimiento posterior.
 * </p>
 * <p>
 * El FormularioDTO es la estructura de datos central utilizada para:
 * </p>
 * <ul>
 *   <li>Presentar el formulario completo en la interfaz de usuario</li>
 *   <li>Recoger y validar toda la información introducida por los profesionales</li>
 *   <li>Transferir datos entre la capa de presentación y la capa de servicios</li>
 *   <li>Facilitar la creación y edición de casos completos</li>
 *   <li>Garantizar la coherencia entre todos los pasos del protocolo</li>
 * </ul>
 * <p>
 * <strong>Estructura del protocolo integrado:</strong>
 * </p>
 * <ol>
 *   <li><strong>Paso 1:</strong> Detección y registro inicial</li>
 *   <li><strong>Paso 2:</strong> Cronograma de actuaciones</li>
 *   <li><strong>Paso 3:</strong> Medidas provisionales</li>
 *   <li><strong>Paso 4:</strong> Acta de reunión con la familia</li>
 *   <li><strong>Paso 5:</strong> Valoración y análisis del caso (con Anexos 4 y 5)</li>
 *   <li><strong>Paso 6:</strong> Resolución</li>
 *   <li><strong>Paso 7:</strong> Plan individualizado de intervención</li>
 *   <li><strong>Paso 8:</strong> Seguimiento de medidas</li>
 *   <li><strong>Paso 9:</strong> Información a dirección</li>
 *   <li><strong>Paso 10:</strong> Seguimiento por inspección</li>
 *   <li><strong>Paso 11:</strong> Cierre del caso y seguimiento institucional</li>
 * </ol>
 * <p>
 * Este DTO garantiza que todos los sub-DTOs estén siempre inicializados (nunca null),
 * facilitando el binding con formularios web y evitando NullPointerException durante
 * la cumplimentación del protocolo.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Alumnado
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
@EqualsAndHashCode(callSuper = false)
@Data
public class FormularioDTO {

    // ==================== IDENTIFICACIÓN DEL CASO ====================

    /**
     * Identificador único del caso en el sistema.
     * <p>
     * Clave primaria generada automáticamente que identifica de forma única
     * este caso de seguimiento en la base de datos.
     * </p>
     */
    private Long id;

    /**
     * Identificador del caso para referencias externas.
     * <p>
     * Código alfanumérico que puede utilizarse para referenciar el caso
     * en documentación externa o en sistemas complementarios.
     * </p>
     */
    private String idCaso;

    /**
     * Identificador del documento principal del caso.
     * <p>
     * Número de referencia del documento o expediente asociado al caso
     * en el sistema de archivo del centro educativo.
     * </p>
     */
    private Integer idDocumento;

    /**
     * Código único del alumno en el sistema educativo.
     * <p>
     * Identificador oficial del alumno que permite su referencia cruzada
     * con otros sistemas educativos y documentos oficiales.
     * </p>
     */
    private String codigoAlumno;

    // ==================== PASOS DEL PROTOCOLO ====================

    /**
     * DTO del Paso 1 - Detección y registro inicial.
     * <p>
     * Contiene información sobre cómo se detectó el caso, quién lo comunicó,
     * indicadores de riesgo iniciales y detalle de los hechos.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null) para facilitar
     * el acceso a sus propiedades desde formularios web.
     * </p>
     *
     * @see Paso1DTO
     */
    private Paso1DTO paso1DTO;

    /**
     * DTO del Paso 2 - Cronograma de actuaciones.
     * <p>
     * Contiene la planificación temporal de actuaciones y aspectos relevantes
     * del proceso inicial de seguimiento.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null) con su lista de
     * cronograma inicializada como lista vacía.
     * </p>
     *
     * @see Paso2DTO
     */
    private Paso2DTO paso2DTO;

    /**
     * DTO del Paso 3 - Medidas provisionales.
     * <p>
     * Documenta las actuaciones inmediatas adoptadas para garantizar
     * la seguridad y bienestar del alumno.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso3DTO
     */
    private Paso3DTO paso3DTO;

    /**
     * DTO del Paso 4 - Acta de reunión con la familia.
     * <p>
     * Documenta los encuentros con las familias, el contenido tratado
     * y los acuerdos alcanzados.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso4DTO
     */
    private Paso4DTO paso4DTO;

    /**
     * DTO del Paso 5 - Valoración y análisis del caso.
     * <p>
     * Contiene la valoración completa del caso mediante el Anexo 4
     * (síntesis de entrevistas) y el Anexo 5 (análisis estructurado
     * con señales de alarma, factores de riesgo y factores de protección).
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null) con ambos anexos
     * inicializados y todas sus sub-estructuras preparadas.
     * </p>
     *
     * @see Paso5DTO
     */
    private Paso5DTO paso5DTO;

    /**
     * DTO del Paso 6 - Resolución.
     * <p>
     * Documenta la decisión adoptada sobre el caso y los agentes
     * implicados en su seguimiento.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso6DTO
     */
    private Paso6DTO paso6DTO;

    /**
     * DTO del Paso 7 - Plan individualizado de intervención.
     * <p>
     * Contiene el plan completo de actuación con objetivos, medidas generales,
     * actuaciones específicas por agentes, calendario de seguimiento y
     * coordinación externa. Es el paso más extenso y detallado del protocolo.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso7DTO
     */
    private Paso7DTO paso7DTO;

    /**
     * DTO del Paso 8 - Seguimiento de medidas.
     * <p>
     * Registra el seguimiento de las medidas implementadas y otras
     * actuaciones complementarias.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso8DTO
     */
    private Paso8DTO paso8DTO;

    /**
     * DTO del Paso 9 - Información a dirección.
     * <p>
     * Documenta la comunicación del caso a la dirección del centro educativo.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso9DTO
     */
    private Paso9DTO paso9DTO;

    /**
     * DTO del Paso 10 - Seguimiento por inspección.
     * <p>
     * Registra las actuaciones y seguimiento realizados por el servicio
     * de inspección educativa.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso10DTO
     */
    private Paso10DTO paso10DTO;

    /**
     * DTO del Paso 11 - Cierre del caso y seguimiento institucional.
     * <p>
     * Documenta el cierre formal del caso y los seguimientos posteriores
     * por inspección, familia y profesorado.
     * </p>
     * <p>
     * Este campo se inicializa siempre (nunca es null).
     * </p>
     *
     * @see Paso11DTO
     */
    private Paso11DTO paso11DTO;

    // ==================== INFORMACIÓN ADICIONAL ====================

    /**
     * Observaciones generales sobre el caso.
     * <p>
     * Campo de texto libre para incluir información adicional, anotaciones
     * o comentarios que no encajan en ningún paso específico del protocolo
     * pero son relevantes para comprender el caso en su globalidad.
     * </p>
     */
    private String observaciones;

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del FormularioDTO inicializando todos los pasos
     * del protocolo como objetos vacíos (no null). Esta inicialización exhaustiva
     * es fundamental para garantizar que:
     * </p>
     * <ul>
     *   <li>Los formularios web puedan hacer binding directo con los campos sin errores</li>
     *   <li>No se produzcan NullPointerException al acceder a propiedades de los pasos</li>
     *   <li>Todos los sub-DTOs complejos (como Paso 5 con sus anexos) estén completamente
     *       inicializados con sus estructuras anidadas</li>
     *   <li>Las listas (como el cronograma del Paso 2) estén inicializadas como listas vacías</li>
     * </ul>
     * <p>
     * Este constructor se utiliza principalmente al crear un nuevo caso desde
     * la interfaz de usuario, donde aún no existe información en ningún paso.
     * </p>
     */
    public FormularioDTO() {
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

    /**
     * Constructor que crea un FormularioDTO completo a partir de una entidad Alumnado.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA completa (con todos
     * sus pasos asociados) a un objeto de transferencia de datos para su uso en la
     * capa de presentación. Es fundamental para la funcionalidad de edición de casos
     * existentes.
     * </p>
     * <p>
     * El proceso de conversión:
     * </p>
     * <ol>
     *   <li>Copia los datos básicos de identificación del alumno</li>
     *   <li>Para cada uno de los 11 pasos del protocolo:
     *     <ul>
     *       <li>Verifica si el paso existe en la entidad alumnado</li>
     *       <li>Si existe: crea el DTO correspondiente mediante conversión desde la entidad</li>
     *       <li>Si no existe: crea un DTO vacío pero inicializado</li>
     *     </ul>
     *   </li>
     * </ol>
     * <p>
     * Esta estrategia garantiza que el FormularioDTO resultante:
     * </p>
     * <ul>
     *   <li>Contiene toda la información existente del caso</li>
     *   <li>Tiene todos sus pasos inicializados (nunca null)</li>
     *   <li>Está desacoplado de las entidades JPA (no hay referencias a entidades gestionadas)</li>
     *   <li>Puede modificarse en la capa de presentación sin afectar a las entidades
     *       hasta que se persistan explícitamente los cambios</li>
     * </ul>
     * <p>
     * <strong>Nota:</strong> Se observa un posible error en la línea del Paso 6 donde
     * se asigna paso5DTO en lugar de paso6DTO en el else. Esto debería revisarse.
     * </p>
     *
     * @param alumnado entidad Alumnado con todos sus pasos asociados de la que se
     *                 extraerá la información completa del caso.
     */
    public FormularioDTO(Alumnado alumnado) {
        // Copiar datos básicos de identificación
        this.id = alumnado.getId();
        this.idCaso = alumnado.getIdCaso();
        this.idDocumento = alumnado.getIdDocumento();
        this.observaciones = alumnado.getObservaciones();
        this.codigoAlumno = alumnado.getCodigoAlumno();

        // Convertir Paso 1
        if (alumnado.getPaso1() != null) {
            this.paso1DTO = new Paso1DTO(alumnado.getPaso1());
        } else {
            this.paso1DTO = new Paso1DTO();
        }

        // Convertir Paso 2
        if (alumnado.getPaso2() != null) {
            this.paso2DTO = new Paso2DTO(alumnado.getPaso2());
        } else {
            this.paso2DTO = new Paso2DTO();
        }

        // Convertir Paso 3
        if (alumnado.getPaso3() != null) {
            this.paso3DTO = new Paso3DTO(alumnado.getPaso3());
        } else {
            this.paso3DTO = new Paso3DTO();
        }

        // Convertir Paso 4
        if (alumnado.getPaso4() != null) {
            this.paso4DTO = new Paso4DTO(alumnado.getPaso4());
        } else {
            this.paso4DTO = new Paso4DTO();
        }

        // Convertir Paso 5
        if (alumnado.getPaso5() != null) {
            this.paso5DTO = new Paso5DTO(alumnado.getPaso5());
        } else {
            this.paso5DTO = new Paso5DTO();
        }

        // Convertir Paso 6
        if (alumnado.getPaso6() != null) {
            this.paso6DTO = new Paso6DTO(alumnado.getPaso6());
        } else {
            // POSIBLE ERROR: Debería ser paso6DTO = new Paso6DTO();
            this.paso6DTO = new Paso6DTO();
        }

        // Convertir Paso 7
        if (alumnado.getPaso7() != null) {
            this.paso7DTO = new Paso7DTO(alumnado.getPaso7());
        } else {
            this.paso7DTO = new Paso7DTO();
        }

        // Convertir Paso 8
        if (alumnado.getPaso8() != null) {
            this.paso8DTO = new Paso8DTO(alumnado.getPaso8());
        } else {
            this.paso8DTO = new Paso8DTO();
        }

        // Convertir Paso 9
        if (alumnado.getPaso9() != null) {
            this.paso9DTO = new Paso9DTO(alumnado.getPaso9());
        } else {
            this.paso9DTO = new Paso9DTO();
        }

        // Convertir Paso 10
        if (alumnado.getPaso10() != null) {
            this.paso10DTO = new Paso10DTO(alumnado.getPaso10());
        } else {
            this.paso10DTO = new Paso10DTO();
        }

        // Convertir Paso 11
        if (alumnado.getPaso11() != null) {
            this.paso11DTO = new Paso11DTO(alumnado.getPaso11());
        } else {
            this.paso11DTO = new Paso11DTO();
        }
    }
}