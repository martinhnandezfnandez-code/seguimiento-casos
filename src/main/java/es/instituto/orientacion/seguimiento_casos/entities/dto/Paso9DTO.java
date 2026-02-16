package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso9;
import lombok.Data;

@Data
public class Paso9DTO {
    private String directorinforma;

    /**
     * Constructor que crea un DTO a partir de una entidad Paso9.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de lo que el director informe
     * </p>
     *
     * @param paso9 entidad Paso9 de la que se copiarán los datos.
     *              Si es null, se creará un DTO vacío (comportamiento por defecto
     *              si no se valida previamente).
     */
    public Paso9DTO(Paso9 paso9) {
        this.directorinforma = paso9.getDirectorinforma();;
    }
    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar.
     * </p>
     */
    public Paso9DTO() {
    }
}
