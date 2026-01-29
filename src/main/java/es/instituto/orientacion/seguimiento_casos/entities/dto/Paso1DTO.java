package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import lombok.Data;

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

    private LocalDate fechaRegistro;

    private String firmas;

    public Paso1DTO(Paso1 paso1){
        this.alumnoComunica = paso1.getAlumnoComunica();
        this.codigoAlumno = paso1.getCodigoAlumno();
        this.companerosComunican = paso1.getCompanerosComunican();
        this.detalleHechos = paso1.getDetalleHechos();
        this.intentoPrevio = paso1.getIntentoPrevio();
        this.familiaComunica = paso1.getFamiliaComunica();
        this.conductaAutolesiva = paso1.getConductaAutolesiva();
        this.otrosDetalle = paso1.getOtrosDetalle();
        this.fechaRegistro = paso1.getFechaRegistro();
        this.firmas = paso1.getFirmas();
    }
    public Paso1DTO(){}
}
