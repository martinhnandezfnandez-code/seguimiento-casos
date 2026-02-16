package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso10;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso3;
import lombok.Data;

@Data
public class Paso10DTO {
    private String seguiminetoInspeccion;
    /**
     * Constructor que crea un DTO a partir de una entidad Paso10.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de lo que el seguimiento inspeccion.
     * </p>
     *
     * @param paso10 entidad Paso10 de la que se copiarán los datos.
     *              Si es null, se creará un DTO vacío (comportamiento por defecto
     *              si no se valida previamente).
     */
    public Paso10DTO(Paso10 paso10) {
        this.seguiminetoInspeccion = paso10.getSeguiminetoInspeccion();
    }
    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar.
     * </p>
     */
    public Paso10DTO() {
    }
}
