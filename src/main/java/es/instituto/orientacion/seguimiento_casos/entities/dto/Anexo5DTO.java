package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Anexo5DTO {
    private Boolean expresaDeseoMorir;

    private Boolean amenazasVerbales;

    private Boolean comentariosCulpaInutilidad;

    private Boolean aislamientoSocial;

    private Boolean abandonoActividades;

    private Boolean conductasAutolesivas;

    private Boolean regalaPertenencias;

    private Boolean cambiosBruscosConducta;

    private Boolean tristezaIntensa;

    private Boolean irritabilidad;

    private Boolean ansiedad;

    private Boolean desesperanza;

    private String observaciones;

    private String detectadoPor;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDeteccion;

    public Anexo5DTO(Anexo5 anexo5) {
        if (anexo5 != null) {
            this.expresaDeseoMorir = anexo5.getExpresaDeseoMorir();
            this.amenazasVerbales = anexo5.getAmenazasVerbales();
            this.comentariosCulpaInutilidad = anexo5.getComentariosCulpaInutilidad();
            this.aislamientoSocial = anexo5.getAislamientoSocial();
            this.abandonoActividades = anexo5.getAbandonoActividades();
            this.conductasAutolesivas = anexo5.getConductasAutolesivas();
            this.regalaPertenencias = anexo5.getRegalaPertenencias();
            this.cambiosBruscosConducta = anexo5.getCambiosBruscosConducta();
            this.tristezaIntensa = anexo5.getTristezaIntensa();
            this.irritabilidad = anexo5.getIrritabilidad();
            this.ansiedad = anexo5.getAnsiedad();
            this.desesperanza = anexo5.getDesesperanza();
            this.observaciones = anexo5.getObservaciones();
            this.detectadoPor = anexo5.getDetectadoPor();
            this.fechaDeteccion = anexo5.getFechaDeteccion();
        }
    }

    public Anexo5DTO() {
    }

}
