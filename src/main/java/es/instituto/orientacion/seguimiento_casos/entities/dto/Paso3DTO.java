package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso3;
import lombok.Data;

@Data
public class Paso3DTO {
    private String medidasProvisionales;

    /**
     * Constructor que crea un DTO a partir de una entidad Paso3.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de las medidas provisionales
     * </p>
     *
     * @param paso3 entidad Paso3 de la que se copiarán los datos.
     *              Si es null, se creará un DTO vacío (comportamiento por defecto
     *              si no se valida previamente).
     */
    public Paso3DTO(Paso3 paso3) {
        this.medidasProvisionales = paso3.getMedidasProvisionales();
    }
    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos sin inicializar,
     * utilizado principalmente al programar una nueva reunión o al crear
     * un nuevo acta donde aún no se ha registrado información.
     * </p>
     */
    public Paso3DTO() {
    }
}
