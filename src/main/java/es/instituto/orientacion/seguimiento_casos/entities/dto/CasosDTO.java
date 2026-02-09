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
    private String codigoAlumno;

    private Paso1DTO paso1DTO;

    private Paso2DTO paso2DTO;

    private Paso3DTO paso3DTO;

    private Paso4DTO paso4DTO;

    private Paso5DTO paso5DTO;

    private Paso6DTO paso6DTO;

    private Paso7DTO paso7DTO;

    private Paso8DTO paso8DTO;

    private Paso9DTO paso9DTO;

    private Paso10DTO paso10DTO;

    private Paso11DTO paso11DTO;

    private String observaciones;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;

    public CasosDTO(Alumnado alumno, Paso1 paso1, Paso2 paso2, Paso3 paso3,Paso4 paso4, Paso5 paso5, Paso6 paso6, Paso7 paso7, Paso8 paso8, Paso9 paso9, Paso10 paso10, Paso11 paso11) {
        this.paso1DTO = (paso1 != null) ? new Paso1DTO(paso1) : new Paso1DTO();
        this.paso2DTO = (paso2 != null) ? new Paso2DTO(paso2) : new Paso2DTO();
        this.paso3DTO = (paso3 != null) ? new Paso3DTO(paso3) : new Paso3DTO();
        this.paso4DTO = (paso4 != null) ? new Paso4DTO(paso4) : new Paso4DTO();
        this.paso5DTO = (paso5 != null) ? new Paso5DTO(paso5) : new Paso5DTO();
        this.paso6DTO = (paso6 != null) ? new Paso6DTO(paso6) : new Paso6DTO();
        this.paso7DTO = (paso7 != null) ? new Paso7DTO(paso7) : new Paso7DTO();
        this.paso8DTO = (paso8 != null) ? new Paso8DTO(paso8) : new Paso8DTO();
        this.paso9DTO = (paso9 != null) ? new Paso9DTO(paso9) : new Paso9DTO();
        this.paso10DTO = (paso10 != null) ? new Paso10DTO(paso10) : new Paso10DTO();
        this.paso11DTO = (paso11 != null) ? new Paso11DTO(paso11) : new Paso11DTO();
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();
        this.fechaCreacion = alumno.getFechaCreacion();
        this.fechaUltimaActualizacion = alumno.getFechaUltimaActualizacion();
        this.observaciones = alumno.getObservaciones();
        this.codigoAlumno = alumno.getCodigoAlumno();
    }

    public CasosDTO() {
        super();
        this.paso1DTO = new Paso1DTO();
        this.paso2DTO = new Paso2DTO();
        this.paso3DTO = new Paso3DTO();
        this.paso4DTO = new Paso4DTO();
        this.paso5DTO = new Paso5DTO();
        this.paso6DTO = new Paso6DTO();
        this.paso7DTO = new Paso7DTO();
        this.paso8DTO = new Paso8DTO();
        this.paso9DTO = new Paso9DTO();
        this.paso10DTO = new Paso10DTO();
        this.paso11DTO = new Paso11DTO();
    }
}
