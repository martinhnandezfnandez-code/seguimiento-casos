package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso5;
import lombok.Data;

@Data
public class Paso5DTO {
    private Anexo4DTO anexo4;
    private Anexo5DTO anexo5;
    private Alumnado alumnado;

    public Paso5DTO(Paso5 paso5){
        this.anexo4 = new Anexo4DTO(paso5.getAnexo4());
        this.anexo5 = new Anexo5DTO(paso5.getAnexo5());
        this.alumnado = paso5.getAlumnado();
    }
    public Paso5DTO(){
        this.anexo4 = new Anexo4DTO();
        this.anexo5 = new Anexo5DTO();
    }
}
