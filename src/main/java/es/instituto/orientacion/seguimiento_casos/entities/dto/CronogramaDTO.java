package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CronogramaDTO {

    private LocalDate fecha;

    private String situacion;

    private String actuacion;

    private String documento;

    private String observaciones;

    public CronogramaDTO() {
    }
    public CronogramaDTO(Cronograma cronograma) {
        this.actuacion= cronograma.getActuacion();
        this.documento= cronograma.getDocumento();
        this.fecha= cronograma.getFecha();
        this.situacion= cronograma.getSituacion();
        this.observaciones = cronograma.getObservaciones();
    }
}
