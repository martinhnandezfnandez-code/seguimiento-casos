package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Paso1DTO {
    private String codigoAlumno;

    private Boolean familiaComunica;

    private Boolean companerosComunican;

    private Boolean alumnoComunica;

    private Boolean intentoPrevio;

    private Boolean conductaAutolesiva;


    private Boolean otrosMotivo;

    private String otrosDetalle;

    private String detalleHechos;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRegistro;

    private String firmas;

    public Paso1DTO(Paso1 paso1) {
        if (paso1 != null) {
            this.codigoAlumno = paso1.getCodigoAlumno();
            this.familiaComunica = paso1.getFamiliaComunica();
            this.companerosComunican = paso1.getCompanerosComunican();
            this.alumnoComunica = paso1.getAlumnoComunica();
            this.intentoPrevio = paso1.getIntentoPrevio();
            this.conductaAutolesiva = paso1.getConductaAutolesiva();
            this.otrosMotivo = paso1.getOtrosMotivo();
            this.otrosDetalle = paso1.getOtrosDetalle();
            this.detalleHechos = paso1.getDetalleHechos();
            this.fechaRegistro = paso1.getFechaRegistro();
            this.firmas = paso1.getFirmas();
        }

    }

    public Paso1DTO() {
    }
}
