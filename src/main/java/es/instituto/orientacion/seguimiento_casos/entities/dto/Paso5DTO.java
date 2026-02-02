package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Anexo4;
import es.instituto.orientacion.seguimiento_casos.entities.Anexo5;
import es.instituto.orientacion.seguimiento_casos.entities.Paso5;
import lombok.Data;

@Data
public class Paso5DTO {
    private Anexo4 anexo4;
    private Anexo5 anexo5;

    public Paso5DTO(Paso5 paso5){
        this.anexo4 = paso5.getAnexo4();
        this.anexo5 = paso5.getAnexo5();
    }
    public Paso5DTO(){}
}
