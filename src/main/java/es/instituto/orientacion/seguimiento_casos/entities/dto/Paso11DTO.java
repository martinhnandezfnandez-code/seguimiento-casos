package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso11;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Paso11DTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecchacierre;

    private String observacionesFechaCierre;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaInspeccion;

    private String inspeccion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecchafamilia;

    private String familia;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaProfesorado;

    private String profesorado;

    public Paso11DTO() {
    }
    public Paso11DTO(Paso11 paso11) {
        this.fecchacierre = paso11.getFecchacierre();
        this.observacionesFechaCierre = paso11.getObservacionesFechaCierre();
        this.fechaInspeccion = paso11.getFechaInspeccion();
        this.inspeccion = paso11.getInspeccion();
        this.fecchafamilia = paso11.getFecchafamilia();
        this.familia = paso11.getFamilia();
        this.fechaProfesorado = paso11.getFechaProfesorado();
        this.profesorado = paso11.getProfesorado();
    }
}
