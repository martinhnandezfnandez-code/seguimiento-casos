package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Cronograma;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
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

    // CONSTRUCTOR CORREGIDO - Ahora mapea TODOS los campos
    public FormularioDTO(Alumnado alumno, Paso1 paso1) {
        // Mapear Paso1 (con protección contra null)
        this.paso1DTO = new Paso1DTO(paso1);

        // Mapear datos básicos
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();

        // Mapear PASO 2 - ESTOS CAMPOS FALTABAN
        this.paso2_1 = alumno.getPaso2_1();
        this.paso2_2 = alumno.getPaso2_2();
        this.paso2_3 = alumno.getPaso2_3();
        this.paso2_4 = alumno.getPaso2_4();
        this.paso2_5 = alumno.getPaso2_5();
        this.cronograma = (alumno.getCronograma() != null) ? alumno.getCronograma() : new ArrayList<>();
        this.paso2_7 = alumno.getPaso2_7();

        // Mapear PASO 3
        this.paso3_1 = alumno.getPaso3_1();

        // Mapear PASO 4
        this.paso4_1 = alumno.getPaso4_1();

        // Mapear PASO 5
        this.paso5_1 = alumno.getPaso5_1();
        this.paso5_2 = alumno.getPaso5_2();

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
        this.cronograma = new ArrayList<>();
    }

    public FormularioDTO(Alumnado alumnado) {

        this.id = alumnado.getId();
        this.idCaso = alumnado.getIdCaso();
        this.idDocumento = alumnado.getIdDocumento();

        if (alumnado.getPaso1() != null) {
            this.paso1DTO = new Paso1DTO(alumnado.getPaso1());
        } else {
            this.paso1DTO = new Paso1DTO();
        }
    }
}