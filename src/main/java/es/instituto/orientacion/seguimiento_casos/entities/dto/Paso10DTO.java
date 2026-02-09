package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso10;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso3;
import lombok.Data;

@Data
public class Paso10DTO {
    private String seguiminetoInspeccion;

    public Paso10DTO(Paso10 paso10) {
        this.seguiminetoInspeccion = paso10.getSeguiminetoInspeccion();
    }

    public Paso10DTO() {
    }
}
