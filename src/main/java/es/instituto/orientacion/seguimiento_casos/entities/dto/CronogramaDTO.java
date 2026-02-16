package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para una entrada del Cronograma del Paso 2.
 * <p>
 * Este objeto de transferencia de datos representa una entrada individual dentro del
 * cronograma de actuaciones del protocolo de seguimiento. El cronograma es una herramienta
 * fundamental para planificar, documentar y hacer seguimiento de todas las actuaciones
 * realizadas en relación con el caso del alumno.
 * </p>
 * <p>
 * Cada entrada del cronograma registra una actuación específica con su contexto temporal,
 * la situación que la motivó, la acción realizada, documentación asociada y observaciones
 * relevantes. Esto permite tener una visión completa y cronológica de todas las
 * intervenciones realizadas.
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Cronograma}.
 * Un caso puede tener múltiples entradas de cronograma, formando un registro temporal
 * completo del seguimiento.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Cronograma
 * @see Paso2DTO
 */
@Data
public class CronogramaDTO {

    /**
     * Fecha en que se realizó o está planificada la actuación.
     * <p>
     * Marca temporal que permite ordenar cronológicamente todas las actuaciones
     * del caso. Puede representar tanto actuaciones ya realizadas (registro histórico)
     * como actuaciones planificadas (calendario de seguimiento).
     * </p>
     * <p>
     * Esta fecha es fundamental para:
     * </p>
     * <ul>
     *   <li>Reconstruir la línea temporal del caso</li>
     *   <li>Verificar el cumplimiento de plazos del protocolo</li>
     *   <li>Planificar actuaciones futuras</li>
     *   <li>Evaluar la evolución del caso a lo largo del tiempo</li>
     * </ul>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    /**
     * Descripción de la situación que motiva la actuación.
     * <p>
     * Campo de texto que describe el contexto, circunstancias o problemática
     * que justifica la necesidad de realizar esta actuación específica.
     * Proporciona el "por qué" de la intervención.
     * </p>
     * <p>
     * Ejemplos:
     * </p>
     * <ul>
     *   <li>"Detectada bajada significativa en el rendimiento académico"</li>
     *   <li>"Familia solicita reunión para comunicar cambios en el comportamiento"</li>
     *   <li>"Compañeros alertan sobre comentarios preocupantes del alumno"</li>
     *   <li>"Seguimiento periódico tras implantación del plan individualizado"</li>
     * </ul>
     */
    private String situacion;

    /**
     * Descripción de la actuación realizada o planificada.
     * <p>
     * Campo de texto que detalla la acción específica llevada a cabo o que se
     * llevará a cabo para abordar la situación. Proporciona el "qué" de la intervención.
     * </p>
     * <p>
     * Ejemplos:
     * </p>
     * <ul>
     *   <li>"Reunión con el equipo docente para valoración conjunta"</li>
     *   <li>"Entrevista individual con el alumno"</li>
     *   <li>"Reunión informativa con la familia"</li>
     *   <li>"Derivación al servicio de orientación"</li>
     *   <li>"Coordinación con servicios externos de salud mental"</li>
     *   <li>"Sesión de seguimiento del plan de intervención"</li>
     * </ul>
     */
    private String actuacion;

    /**
     * Referencia al documento o acta generado en esta actuación.
     * <p>
     * Campo de texto que identifica el documento formal asociado a esta entrada
     * del cronograma, si existe. Puede contener el nombre del archivo, código de
     * registro, tipo de anexo del protocolo o cualquier referencia que permita
     * localizar la documentación completa de la actuación.
     * </p>
     * <p>
     * Ejemplos:
     * </p>
     * <ul>
     *   <li>"Anexo 3 - Acta de reunión con familia"</li>
     *   <li>"Informe de seguimiento - Marzo 2024"</li>
     *   <li>"Acta_reunion_equipo_docente_15032024.pdf"</li>
     *   <li>"Derivación a servicios externos - Registro 2024/045"</li>
     * </ul>
     * <p>
     * Este campo facilita la trazabilidad documental del caso y permite
     * vincular cada actuación con su evidencia formal correspondiente.
     * </p>
     */
    private String documento;

    /**
     * Observaciones adicionales sobre la actuación.
     * <p>
     * Campo de texto libre para incluir información complementaria, detalles
     * relevantes, resultados de la actuación, acuerdos alcanzados, próximos
     * pasos acordados o cualquier anotación que no encaje en los campos anteriores
     * pero sea importante para comprender el contexto completo de la actuación.
     * </p>
     * <p>
     * Ejemplos:
     * </p>
     * <ul>
     *   <li>"Familia receptiva y colaboradora. Se comprometen a seguimiento en casa"</li>
     *   <li>"Alumno muestra mejoría en su estado anímico. Continuar con seguimiento quincenal"</li>
     *   <li>"Pendiente de respuesta del servicio de salud mental para cita"</li>
     *   <li>"Se acuerda nueva reunión para dentro de dos semanas"</li>
     * </ul>
     */
    private String observaciones;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al añadir nuevas entradas al cronograma desde
     * la interfaz de usuario.
     * </p>
     */
    public CronogramaDTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Cronograma.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos de la entrada del cronograma,
     * permitiendo visualizar y editar la información de forma desacoplada
     * de la capa de persistencia.
     * </p>
     *
     * @param cronograma entidad Cronograma de la que se copiarán los datos.
     *                   Si es null, se creará un DTO vacío (comportamiento por defecto
     *                   si no se valida previamente).
     */
    public CronogramaDTO(Cronograma cronograma) {
        this.actuacion = cronograma.getActuacion();
        this.documento = cronograma.getDocumento();
        this.fecha = cronograma.getFecha();
        this.situacion = cronograma.getSituacion();
        this.observaciones = cronograma.getObservaciones();
    }
}