package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso1;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para el Paso 1 del protocolo de seguimiento.
 * <p>
 * Este objeto de transferencia de datos representa el Paso 1 - Detección y Registro Inicial
 * del caso. Es el primer paso del protocolo y documenta cómo se detectó la situación,
 * quién comunicó la preocupación, los indicadores de riesgo iniciales observados
 * y el detalle de los hechos que motivaron la apertura del caso.
 * </p>
 * <p>
 * Este paso es fundamental porque establece el punto de partida del seguimiento,
 * registrando la información inicial que permitirá evaluar la situación y determinar
 * las actuaciones necesarias. La correcta cumplimentación de este paso es esencial
 * para garantizar la trazabilidad del caso y la adecuada intervención.
 * </p>
 * <p>
 * Este DTO se utiliza para transferir datos entre la capa de presentación y la capa
 * de servicios, facilitando la conversión desde y hacia la entidad {@link Paso1}.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Paso1
 */
@Data
public class Paso1DTO {

    /**
     * Indica si la familia comunicó la situación de preocupación.
     * <p>
     * Se marca como verdadero cuando son los padres, tutores legales u otros
     * familiares quienes informan al centro educativo sobre una situación
     * que requiere atención o seguimiento.
     * </p>
     */
    private Boolean familiaComunica;

    /**
     * Indica si fueron los compañeros quienes comunicaron la situación.
     * <p>
     * Se marca como verdadero cuando otros alumnos del centro alertan
     * sobre comportamientos, comentarios o situaciones preocupantes
     * de un compañero que requieren intervención.
     * </p>
     */
    private Boolean companerosComunican;

    /**
     * Indica si fue el propio alumno quien comunicó su situación.
     * <p>
     * Se marca como verdadero cuando el alumno busca ayuda de forma activa,
     * comunica su malestar o solicita apoyo a profesionales del centro
     * (tutor, orientador, profesor, etc.).
     * </p>
     */
    private Boolean alumnoComunica;

    /**
     * Indica si existe constancia de intento de suicidio previo.
     * <p>
     * Se marca como verdadero cuando hay información documentada o verificable
     * de que el alumno ha realizado previamente uno o más intentos de quitarse
     * la vida. Este es un indicador de riesgo muy significativo.
     * </p>
     * <strong>Indicador de riesgo: MUY ALTO</strong>
     */
    private Boolean intentoPrevio;

    /**
     * Indica si se han detectado conductas autolesivas.
     * <p>
     * Se marca como verdadero cuando el alumno presenta autolesiones deliberadas
     * (cortes, quemaduras, golpes autoinfligidos) como forma de gestionar
     * su malestar emocional. Estas conductas pueden o no tener intencionalidad suicida.
     * </p>
     * <strong>Indicador de riesgo: ALTO</strong>
     */
    private Boolean conductaAutolesiva;

    /**
     * Indica si existen otros motivos de detección no contemplados anteriormente.
     * <p>
     * Se marca como verdadero cuando la detección del caso se produce por
     * razones diferentes a las especificadas en los campos anteriores
     * (observación de profesorado, detección por servicios externos, etc.).
     * </p>
     */
    private Boolean otrosMotivo;

    /**
     * Detalle específico de otros motivos de detección.
     * <p>
     * Campo de texto libre para especificar cuáles son esos otros motivos
     * de detección cuando el campo {@link #otrosMotivo} está marcado como verdadero.
     * Por ejemplo: "Detectado por el servicio de salud mental", "Comunicado por
     * trabajador social", "Observado por monitor de actividades extraescolares", etc.
     * </p>
     */
    private String otrosDetalle;

    /**
     * Descripción detallada de los hechos que motivaron la apertura del caso.
     * <p>
     * Campo de texto extenso donde se narra de forma completa y objetiva
     * la situación detectada, incluyendo:
     * </p>
     * <ul>
     *   <li>Qué hechos o comportamientos se observaron</li>
     *   <li>Cuándo y dónde ocurrieron</li>
     *   <li>Quiénes estuvieron presentes o involucrados</li>
     *   <li>Qué manifestaciones verbales o conductuales hubo</li>
     *   <li>Contexto y circunstancias relevantes</li>
     * </ul>
     * <p>
     * Este campo es fundamental para la evaluación inicial del caso y debe
     * cumplimentarse con el máximo detalle posible, manteniendo siempre
     * un lenguaje objetivo y profesional.
     * </p>
     */
    private String detalleHechos;

    /**
     * Fecha de registro oficial del caso en el sistema.
     * <p>
     * Marca temporal que indica cuándo se abrió formalmente el caso de seguimiento.
     * Esta fecha es importante para la trazabilidad del expediente y para establecer
     * los plazos de actuación según el protocolo.
     * </p>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRegistro;

    /**
     * Firmas de los profesionales responsables del registro inicial.
     * <p>
     * Campo de texto donde se consignan los nombres y cargos de los profesionales
     * que han participado en la detección y registro inicial del caso
     * (orientador, tutor, director, etc.), asumiendo la responsabilidad
     * de la información registrada.
     * </p>
     * <p>
     * Ejemplo: "María García López (Orientadora), Juan Pérez Martín (Tutor)"
     * </p>
     */
    private String firmas;

    /**
     * Constructor que crea un DTO a partir de una entidad Paso1.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todos los campos relevantes del registro inicial,
     * incluyendo las fuentes de detección, indicadores de riesgo observados
     * y el detalle completo de los hechos.
     * </p>
     *
     * @param paso1 entidad Paso1 de la que se copiarán los datos.
     *              Si es null, los campos del DTO permanecerán sin inicializar.
     */
    public Paso1DTO(Paso1 paso1) {
        if (paso1 != null) {
            this.familiaComunica = paso1.getFamiliaComunica();
            this.companerosComunican = paso1.getCompanerosComunican();
            this.alumnoComunica = paso1.getAlumnoComunica();
            this.intentoPrevio = paso1.getIntentoPrevio();
            this.conductaAutolesiva = paso1.getConductaAutolesiva();
            this.otrosMotivo = paso1.getOtrosMotivo();
            this.otrosDetalle = paso1.getOtrosDetalle();
            this.detalleHechos = paso1.getDetalleHechos();
            this.fechaRegistro = paso1.getFechaRegistro();
            this.firmas = paso1.getFirmas();
        }
    }

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al crear un nuevo caso donde aún no se ha
     * registrado información.
     * </p>
     */
    public Paso1DTO() {
    }
}