package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Cronograma;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.Paso2;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class CasosDTO{
    private Long id;
    private String idCaso;
    private Integer idDocumento;

    private Paso1DTO paso1DTO;

  private  Paso2DTO paso2DTO;


    private String paso3_1;


    private String paso4_1;


    private String paso5_1;
    private String paso5_2;

    private String paso6_1;
    private String paso6_2;
    private String paso6_3;

    private String paso7_1;

    private String paso8_1;

    private String paso9_1;

    private String paso10_1;

    private String paso11_1;
    private String paso11_2;
    private String paso11_3;
    private String paso11_4;

    private String observaciones;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;

    public CasosDTO(Alumnado alumno, Paso1 paso1, Paso2 paso2) {
        this.paso1DTO = (paso1 != null) ? new Paso1DTO(paso1) : new Paso1DTO();
        this.paso2DTO = (paso2 != null)? new Paso2DTO(paso2): new Paso2DTO();
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();
        this.fechaCreacion = alumno.getFechaCreacion();
        this.fechaUltimaActualizacion = alumno.getFechaUltimaActualizacion();
        this.paso3_1 = alumno.getPaso3_1();
        this.paso4_1 = alumno.getPaso4_1();
        this.paso7_1 = alumno.getPaso7_1();
        this.paso8_1 = alumno.getPaso8_1();
        this.paso9_1 = alumno.getPaso9_1();
        this.paso10_1 = alumno.getPaso10_1();
        this.observaciones= alumno.getObservaciones();
    }
    public CasosDTO(){
        super();
        this.paso1DTO = new Paso1DTO();
        this.paso2DTO = new Paso2DTO();
    }
}
