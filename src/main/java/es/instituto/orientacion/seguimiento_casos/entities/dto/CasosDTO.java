package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CasosDTO {
    private Long id;
    private String idCaso;
    private Integer idDocumento;

    private Paso1DTO paso1DTO;

    private Paso2DTO paso2DTO;

    private Paso4DTO paso4DTO;


    private String paso3_1;


    private Paso5DTO paso5DTO;

    private String paso6_1;
    private String paso6_2;
    private String paso6_3;

    private String paso7_1;

    private Paso8DTO paso8DTO;


    private String paso9_1;

    private String paso10_1;

    private Paso11DTO paso11DTO;

    private String observaciones;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;

    public CasosDTO(Alumnado alumno, Paso1 paso1, Paso2 paso2, Paso4 paso4, Paso5 paso5, Paso8 paso8, Paso11 paso11) {
        this.paso1DTO = (paso1 != null) ? new Paso1DTO(paso1) : new Paso1DTO();
        this.paso2DTO = (paso2 != null) ? new Paso2DTO(paso2) : new Paso2DTO();
        this.paso4DTO = (paso4 != null) ? new Paso4DTO(paso4) : new Paso4DTO();
        this.paso5DTO = (paso5 != null) ? new Paso5DTO(paso5) : new Paso5DTO();
        this.paso8DTO = (paso8 != null) ? new Paso8DTO(paso8) : new Paso8DTO();
        this.paso11DTO = (paso11 != null) ? new Paso11DTO(paso11) : new Paso11DTO();
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();
        this.fechaCreacion = alumno.getFechaCreacion();
        this.fechaUltimaActualizacion = alumno.getFechaUltimaActualizacion();
        this.paso3_1 = alumno.getPaso3_1();
        this.paso7_1 = alumno.getPaso7_1();
        this.paso9_1 = alumno.getPaso9_1();
        this.paso10_1 = alumno.getPaso10_1();
        this.observaciones = alumno.getObservaciones();
    }

    public CasosDTO() {
        super();
        this.paso1DTO = new Paso1DTO();
        this.paso2DTO = new Paso2DTO();
        this.paso4DTO = new Paso4DTO();
        this.paso5DTO = new Paso5DTO();
        this.paso8DTO = new Paso8DTO();
        this.paso11DTO = new Paso11DTO();
    }
}
