package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class FormularioDTO {
    private Long id;
    private String idCaso;
    private Integer idDocumento;
    private Paso1DTO paso1DTO;
    private Paso2DTO paso2DTO;
    private Paso4DTO paso4DTO;
    private Paso5DTO paso5DTO;

    private String paso3_1;



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

    // CONSTRUCTOR CORREGIDO - Ahora mapea TODOS los campos
    public FormularioDTO(Alumnado alumno, Paso1 paso1, Paso2 paso2, Paso4 paso4, Paso5 paso5) {
        // Mapear Paso1 (con protección contra null)
        this.paso1DTO = new Paso1DTO(paso1);

        // Mapear datos básicos
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();

        // Mapear PASO 2 (con protección contra null)
       this.paso2DTO = new Paso2DTO(paso2);

        // Mapear PASO 3
        this.paso3_1 = alumno.getPaso3_1();

        // Mapear PASO 4
        this.paso4DTO = new Paso4DTO(paso4);

        // Mapear PASO 5
        this.paso5DTO = new Paso5DTO(paso5);

        // Mapear PASO 6
        this.paso6_1 = alumno.getPaso6_1();
        this.paso6_2 = alumno.getPaso6_2();
        this.paso6_3 = alumno.getPaso6_3();

        // Mapear PASO 7
        this.paso7_1 = alumno.getPaso7_1();

        // Mapear PASO 8
        this.paso8_1 = alumno.getPaso8_1();

        // Mapear PASO 9
        this.paso9_1 = alumno.getPaso9_1();

        // Mapear PASO 10
        this.paso10_1 = alumno.getPaso10_1();

        // Mapear PASO 11
        this.paso11_1 = alumno.getPaso11_1();
        this.paso11_2 = alumno.getPaso11_2();
        this.paso11_3 = alumno.getPaso11_3();
        this.paso11_4 = alumno.getPaso11_4();

        // Mapear observaciones
        this.observaciones = alumno.getObservaciones();
    }

    // Constructor vacío
    public FormularioDTO() {
        super();
        this.paso1DTO = new Paso1DTO();
        this.paso2DTO = new Paso2DTO();
        this.paso4DTO = new Paso4DTO();
        this.paso5DTO = new Paso5DTO();

    }

    public FormularioDTO(Alumnado alumnado) {

        this.id = alumnado.getId();
        this.idCaso = alumnado.getIdCaso();
        this.idDocumento = alumnado.getIdDocumento();
        this.paso3_1 = alumnado.getPaso3_1();
        this.paso7_1 = alumnado.getPaso7_1();
        this.paso8_1 = alumnado.getPaso8_1();
        this.paso9_1 = alumnado.getPaso9_1();
        this.paso10_1 = alumnado.getPaso10_1();
        this.observaciones= alumnado.getObservaciones();

        if (alumnado.getPaso1() != null) {
            this.paso1DTO = new Paso1DTO(alumnado.getPaso1());
        } else {
            this.paso1DTO = new Paso1DTO();
        }
        if (alumnado.getPaso2() != null) {
            this.paso2DTO = new Paso2DTO(alumnado.getPaso2());
        } else {
            this.paso2DTO = new Paso2DTO();
        }
        if (alumnado.getPaso4() != null) {
            this.paso4DTO = new Paso4DTO(alumnado.getPaso4());
        } else {
            this.paso4DTO = new Paso4DTO();
        }
    }
}