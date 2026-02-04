package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso3;
import lombok.Data;

@Data
public class Paso3DTO {
    private String medidasProvisionales;

    public Paso3DTO(Paso3 paso3) {
        this.medidasProvisionales = paso3.getMedidasProvisionales();
    }

    public Paso3DTO() {
    }
}
