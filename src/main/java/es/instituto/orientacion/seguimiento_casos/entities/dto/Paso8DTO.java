package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso8;
import lombok.Data;

@Data
public class Paso8DTO {
    private String otrasMedidas;

    private String responsableDireccion;
    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al programar una nueva medida y un responsable de direccion.
     * </p>
     */
    public Paso8DTO() {
    }
    /**
     * Constructor que crea un DTO a partir de una entidad Paso8.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de las otras medidas y del responsable de direccion
     * </p>
     *
     * @param paso8 entidad Paso8 de la que se copiarán los datos.
     *              Si es null, se creará un DTO vacío (comportamiento por defecto
     *              si no se valida previamente).
     */
    public Paso8DTO(Paso8 paso8) {
        this.otrasMedidas = paso8.getOtrasMedidas();
        this.responsableDireccion = paso8.getResponsableDireccion();
    }
}
