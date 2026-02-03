package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso8;
import lombok.Data;

@Data
public class Paso8DTO {
    private String otrasMedidas;

    private String responsableDireccion;

    public Paso8DTO() {
    }
    public Paso8DTO(Paso8 paso8) {
        this.otrasMedidas = paso8.getOtrasMedidas();
        this.responsableDireccion = paso8.getResponsableDireccion();
    }
}
