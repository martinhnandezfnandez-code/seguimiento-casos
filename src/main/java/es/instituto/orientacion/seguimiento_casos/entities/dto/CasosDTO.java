package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Cronograma;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class CasosDTO extends Paso1DTO {
    private Long id;
    private String idCaso;
    private Integer idDocumento;

    private String paso2_1;
    private String paso2_2;
    private String paso2_3;
    private String paso2_4;
    private String paso2_5;

    private List<Cronograma> cronograma = new ArrayList<>();

    private String paso2_7;


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

    public CasosDTO(Alumnado alumno, Paso1 paso1) {
        super(paso1);
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();
        this.fechaCreacion = alumno.getFechaCreacion();
        this.fechaUltimaActualizacion = alumno.getFechaUltimaActualizacion();
    }
    public CasosDTO(){
        super();
    }
}
