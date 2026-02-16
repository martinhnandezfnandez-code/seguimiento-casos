package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso2;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO (Data Transfer Object) para el Paso 2 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 2 del protocolo,
 * que documenta diversos aspectos del proceso inicial de seguimiento y gestiona
 * el cronograma detallado de actuaciones planificadas y realizadas con el alumno.
 * </p>
 * <p>
 * El Paso 2 es fundamental para la planificación y seguimiento temporal del caso,
 * permitiendo registrar información sobre diferentes aspectos del proceso
 * (comunicaciones, valoraciones iniciales, coordinaciones) y mantener un registro
 * cronológico completo de todas las actuaciones mediante una lista de entradas
 * de cronograma.
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso2}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso2
 * @see CronogramaDTO
 */
@Data
public class Paso2DTO {

    /**
     * Registro del primer aspecto del Paso 2.
     * <p>
     * Campo de texto libre para documentar el primer aspecto relevante
     * del proceso de seguimiento inicial. El contenido específico de este campo
     * depende de la estructura definida en el protocolo del centro educativo.
     * </p>
     * <p>
     * Puede incluir información sobre: comunicación inicial con la familia,
     * primera valoración del caso, registro de la demanda inicial, etc.
     * </p>
     */
    private String paso2_1;

    /**
     * Registro del segundo aspecto del Paso 2.
     * <p>
     * Campo de texto libre para documentar el segundo aspecto del proceso
     * de seguimiento. El contenido específico depende de la estructura del protocolo.
     * </p>
     * <p>
     * Puede incluir información sobre: coordinación con el equipo docente,
     * primeras medidas adoptadas, valoración inicial del equipo de orientación, etc.
     * </p>
     */
    private String paso2_2;

    /**
     * Registro del tercer aspecto del Paso 2.
     * <p>
     * Campo de texto libre para documentar el tercer aspecto del proceso
     * de seguimiento. El contenido específico depende de la estructura del protocolo.
     * </p>
     * <p>
     * Puede incluir información sobre: comunicaciones con servicios externos,
     * primera entrevista con el alumno, valoración de necesidades inmediatas, etc.
     * </p>
     */
    private String paso2_3;

    /**
     * Registro del cuarto aspecto del Paso 2.
     * <p>
     * Campo de texto libre para documentar el cuarto aspecto del proceso
     * de seguimiento. El contenido específico depende de la estructura del protocolo.
     * </p>
     * <p>
     * Puede incluir información sobre: planificación inicial de actuaciones,
     * asignación de responsables, establecimiento de plazos, etc.
     * </p>
     */
    private String paso2_4;

    /**
     * Registro del quinto aspecto del Paso 2.
     * <p>
     * Campo de texto libre para documentar el quinto aspecto del proceso
     * de seguimiento. El contenido específico depende de la estructura del protocolo.
     * </p>
     * <p>
     * Puede incluir información sobre: evaluación de recursos disponibles,
     * identificación de apoyos necesarios, valoración de riesgos iniciales, etc.
     * </p>
     */
    private String paso2_5;

    /**
     * Lista de entradas del cronograma de actuaciones.
     * <p>
     * Colección ordenada de entradas que conforman el cronograma completo
     * del caso. Cada entrada ({@link CronogramaDTO}) registra una actuación específica
     * con su fecha, situación que la motiva, acción realizada, documentación
     * asociada y observaciones.
     * </p>
     * <p>
     * Este cronograma es la columna vertebral del seguimiento del caso, permitiendo:
     * </p>
     * <ul>
     *   <li>Planificar actuaciones futuras</li>
     *   <li>Registrar intervenciones realizadas</li>
     *   <li>Mantener trazabilidad temporal del caso</li>
     *   <li>Verificar cumplimiento de plazos del protocolo</li>
     *   <li>Facilitar la coordinación entre profesionales</li>
     *   <li>Evaluar la evolución del caso a lo largo del tiempo</li>
     * </ul>
     * <p>
     * La lista se inicializa siempre (nunca es null) para facilitar las operaciones
     * de adición y gestión de entradas desde la interfaz de usuario.
     * </p>
     */
    private List<CronogramaDTO> cronogramaDTO;

    /**
     * Registro del séptimo aspecto del Paso 2.
     * <p>
     * Campo de texto libre para documentar un aspecto adicional del proceso
     * de seguimiento. El contenido específico depende de la estructura del protocolo.
     * </p>
     * <p>
     * Puede incluir información sobre: observaciones generales del paso,
     * aspectos no contemplados en campos anteriores, notas del equipo de orientación,
     * conclusiones de la fase inicial, etc.
     * </p>
     * <p>
     * <strong>Nota:</strong> Se observa que no existe paso2_6, lo cual puede deberse
     * a que ese espacio está ocupado por el cronograma en el formulario original del protocolo.
     * </p>
     */
    private String paso2_7;

    /**
     * Constructor que crea un DTO a partir de una entidad Paso2.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos de texto del paso y convierte
     * la colección de entidades {@link Cronograma} en una lista de DTOs
     * {@link CronogramaDTO}, desacoplando completamente la capa de presentación
     * de la capa de persistencia.
     * </p>
     * <p>
     * El proceso de conversión del cronograma es fundamental para permitir
     * la edición de las entradas sin afectar directamente a las entidades
     * gestionadas por JPA hasta que se persistan explícitamente los cambios.
     * </p>
     *
     * @param paso2 entidad Paso2 de la que se copiarán los datos.
     *              La lista de cronograma se convierte iterativamente a DTOs.
     */
    public Paso2DTO(Paso2 paso2) {
        this.paso2_1 = paso2.getPaso2_1();
        this.paso2_2 = paso2.getPaso2_2();
        this.paso2_3 = paso2.getPaso2_3();
        this.paso2_4 = paso2.getPaso2_4();
        this.paso2_5 = paso2.getPaso2_5();

        // Convertir colección de entidades Cronograma a DTOs
        this.cronogramaDTO = new ArrayList<>();
        for (Cronograma cronograma : paso2.getCronograma()) {
            this.cronogramaDTO.add(new CronogramaDTO(cronograma));
        }

        this.paso2_7 = paso2.getPaso2_7();
    }

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos de texto sin inicializar
     * y la lista de cronograma inicializada como lista vacía (no null).
     * </p>
     * <p>
     * La inicialización de la lista de cronograma es importante para evitar
     * NullPointerException al añadir entradas desde la interfaz de usuario
     * en casos nuevos donde aún no se ha registrado ninguna actuación.
     * </p>
     */
    public Paso2DTO() {
        this.cronogramaDTO = new ArrayList<>();
    }
}