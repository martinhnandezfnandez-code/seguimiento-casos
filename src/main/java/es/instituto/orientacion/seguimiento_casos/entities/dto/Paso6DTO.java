package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso6;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Paso6DTO {
    private Boolean tutores;

    private  Boolean alumno;

    private Boolean inspeccion;

    private  Boolean comision;

    private  Boolean servicios;

    private  Boolean otros;

    private String otrosespecificados;

    private Boolean abrir;

    private  Boolean motivacion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    public Paso6DTO() {
    }

    public Paso6DTO(Paso6 paso6) {
            this.tutores = paso6.getTutores();
            this.abrir = paso6.getAbrir();
            this.alumno = paso6.getAlumno();
            this.inspeccion = paso6.getInspeccion();
            this.servicios = paso6.getServicios();
            this.comision = paso6.getComision();
            this.otros = paso6.getOtros();
            this.otrosespecificados = paso6.getOtrosespecificados();
            this.motivacion = paso6.getMotivacion();
            this.fecha = paso6.getFecha();

    }



}
