package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso9;
import lombok.Data;

@Data
public class Paso9DTO {
    private String directorinforma;

    public Paso9DTO(Paso9 paso9) {
        this.directorinforma = paso9.getDirectorinforma();;
    }

    public Paso9DTO() {
    }
}
