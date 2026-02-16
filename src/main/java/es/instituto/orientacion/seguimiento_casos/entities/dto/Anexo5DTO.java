package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Anexo 5 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Anexo 5 - Análisis del Caso,
 * que documenta un análisis exhaustivo de la situación del alumno mediante tres
 * dimensiones principales: señales de alarma, factores de riesgo y factores de protección.
 * </p>
 * <p>
 * El análisis se estructura en tres componentes especializados:
 * </p>
 * <ul>
 *   <li>{@link Anexo5SenalesAlarmaDTO}: Indicadores de alerta detectados</li>
 *   <li>{@link Anexo5FactoresRiesgoDTO}: Factores que incrementan la vulnerabilidad</li>
 *   <li>{@link Anexo5FactoresProteccionDTO}: Factores que favorecen la resiliencia</li>
 * </ul>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Anexo5}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Anexo5
 * @see Anexo5SenalesAlarmaDTO
 * @see Anexo5FactoresRiesgoDTO
 * @see Anexo5FactoresProteccionDTO
 */
@Data
public class Anexo5DTO {

    /**
     * Identificador único del anexo.
     */
    private Long id;

    /**
     * Persona o profesional que detectó los indicadores de riesgo.
     * <p>
     * Puede ser el tutor, orientador, familia, compañeros u otro profesional
     * del centro educativo.
     * </p>
     */
    private String detectadoPor;

    /**
     * Fecha en que se realizó la detección de los indicadores.
     * <p>
     * Marca temporal del momento en que se identificaron las señales
     * que motivaron el análisis del caso.
     * </p>
     */
    private LocalDate fechaDeteccion;

    /**
     * Observaciones adicionales sobre el análisis realizado.
     * <p>
     * Campo de texto libre para incluir información complementaria,
     * contexto específico o cualquier detalle relevante que no encaje
     * en las categorías estructuradas.
     * </p>
     */
    private String observaciones;

    /**
     * Identificador del Paso 5 al que pertenece este anexo.
     * <p>
     * Establece la relación con el paso del protocolo que contiene
     * este análisis del caso.
     * </p>
     */
    private Long paso5Id;

    /**
     * Señales de alarma detectadas en el alumno.
     * <p>
     * Contiene los indicadores comportamentales, emocionales y relacionales
     * que alertaron sobre la necesidad de intervención.
     * </p>
     */
    private Anexo5SenalesAlarmaDTO senalesAlarma;

    /**
     * Factores de riesgo identificados.
     * <p>
     * Elementos del contexto personal, familiar, escolar o social
     * que incrementan la vulnerabilidad del alumno y pueden agravar
     * su situación.
     * </p>
     */
    private Anexo5FactoresRiesgoDTO factoresRiesgo;

    /**
     * Factores de protección identificados.
     * <p>
     * Elementos del contexto personal, familiar, escolar o social
     * que actúan como recursos y fortalezas, favoreciendo la resiliencia
     * y el bienestar del alumno.
     * </p>
     */
    private Anexo5FactoresProteccionDTO factoresProteccion;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO inicializando los tres sub-DTOs
     * (señales de alarma, factores de riesgo y factores de protección)
     * para evitar referencias nulas y facilitar el uso en formularios.
     * </p>
     */
    public Anexo5DTO() {
        this.senalesAlarma = new Anexo5SenalesAlarmaDTO();
        this.factoresRiesgo = new Anexo5FactoresRiesgoDTO();
        this.factoresProteccion = new Anexo5FactoresProteccionDTO();
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Anexo5.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia profunda de todos los campos, incluyendo los tres
     * sub-objetos anidados (señales de alarma, factores de riesgo y factores
     * de protección), verificando nulidad en cada nivel.
     * </p>
     *
     * @param entity entidad Anexo5 de la que se copiarán los datos.
     *               Si es null, solo se inicializarán los sub-DTOs vacíos.
     */
    public Anexo5DTO(Anexo5 entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.detectadoPor = entity.getDetectadoPor();
            this.fechaDeteccion = entity.getFechaDeteccion();
            this.observaciones = entity.getObservaciones();

            // Copiar referencia al Paso 5
            if (entity.getPaso5() != null) {
                this.paso5Id = entity.getPaso5().getId();
            }

            // Copiar señales de alarma si existen
            if (entity.getSenalesAlarma() != null) {
                this.senalesAlarma = new Anexo5SenalesAlarmaDTO(entity.getSenalesAlarma());
            }

            // Copiar factores de riesgo si existen
            if (entity.getFactoresRiesgo() != null) {
                this.factoresRiesgo = new Anexo5FactoresRiesgoDTO(entity.getFactoresRiesgo());
            }

            // Copiar factores de protección si existen
            if (entity.getFactoresProteccion() != null) {
                this.factoresProteccion = new Anexo5FactoresProteccionDTO(entity.getFactoresProteccion());
            }
        }
    }
}