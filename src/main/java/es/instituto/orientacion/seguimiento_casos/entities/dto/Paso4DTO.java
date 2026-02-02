package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Paso4;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class Paso4DTO {
    private String asistentes;

    private String contenido;

    private  String acuerdos;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    public Paso4DTO(Paso4 paso4){
        this.acuerdos = paso4.getAcuerdos();
        this.asistentes = paso4.getAsistentes();
        this.contenido = paso4.getContenido();
        this.fecha = paso4.getFecha();
    }
    public Paso4DTO(){

    }
}
