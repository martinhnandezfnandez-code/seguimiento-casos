package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Anexo5DTO {

    private Long id;

    private String detectadoPor;
    

    private LocalDate fechaDeteccion;
    
    private String observaciones;

    private Long paso5Id;
    
    private Anexo5SenalesAlarmaDTO senalesAlarma;

    private Anexo5FactoresRiesgoDTO factoresRiesgo;

    private Anexo5FactoresProteccionDTO factoresProteccion;

    
    public Anexo5DTO() {
    }

    public Anexo5DTO(Anexo5 entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.detectadoPor = entity.getDetectadoPor();
            this.fechaDeteccion = entity.getFechaDeteccion();
            this.observaciones = entity.getObservaciones();
            
            if (entity.getPaso5() != null) {
                this.paso5Id = entity.getPaso5().getId();
            }
            
            if (entity.getSenalesAlarma() != null) {
                this.senalesAlarma = new Anexo5SenalesAlarmaDTO(entity.getSenalesAlarma());
            }
            
            if (entity.getFactoresRiesgo() != null) {
                this.factoresRiesgo = new Anexo5FactoresRiesgoDTO(entity.getFactoresRiesgo());
            }
            
            if (entity.getFactoresProteccion() != null) {
                this.factoresProteccion = new Anexo5FactoresProteccionDTO(entity.getFactoresProteccion());
            }
        }
    }
}
