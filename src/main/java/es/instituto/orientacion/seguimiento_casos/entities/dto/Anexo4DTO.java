package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo4;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Anexo4DTO {

    private String sintesisfamilia;

    private String integrantesfamilia;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechafamilia;

    private String sintesisalumno;

    private String integrantesalumno;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaalumno;

    public Anexo4DTO() {
    }

    public Anexo4DTO(Anexo4 anexo4) {
        if (anexo4 != null) {
            this.sintesisalumno = anexo4.getSintesisalumno();
            this.fechaalumno = anexo4.getFechaalumno();
            this.integrantesalumno = anexo4.getIntegrantesalumno();
            this.sintesisfamilia = anexo4.getSintesisfamilia();
            this.fechafamilia = anexo4.getFechafamilia();
            this.integrantesfamilia = anexo4.getIntegrantesfamilia();
        }
    }

}
