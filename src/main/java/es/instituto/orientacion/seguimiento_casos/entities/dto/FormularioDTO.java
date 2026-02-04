package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FormularioDTO {
    private Long id;
    private String idCaso;
    private Integer idDocumento;
    private Paso1DTO paso1DTO;
    private Paso2DTO paso2DTO;
    private Paso3DTO paso3DTO;
    private Paso4DTO paso4DTO;
    private Paso5DTO paso5DTO;
    private Paso8DTO paso8DTO;

    private String paso6_1;
    private String paso6_2;
    private String paso6_3;

    private String paso7_1;

    private String paso9_1;

    private String paso10_1;

    private Paso11DTO paso11DTO;

    private String observaciones;

    public FormularioDTO(Alumnado alumno, Paso1 paso1, Paso2 paso2, Paso3 paso3, Paso4 paso4, Paso5 paso5, Paso8 paso8, Paso11 paso11) {
        // Mapear Paso1 (con protección contra null)
        this.paso1DTO = new Paso1DTO(paso1);

        // Mapear datos básicos
        this.id = alumno.getId();
        this.idCaso = alumno.getIdCaso();
        this.idDocumento = alumno.getIdDocumento();

        // Mapear PASO 2 (con protección contra null)
       this.paso2DTO = new Paso2DTO(paso2);

        // Mapear PASO 3 (con protección contra null)
        this.paso3DTO = new Paso3DTO(paso3);

        // Mapear Paso 4 (con protección contra null)
        this.paso4DTO = new Paso4DTO(paso4);

        // Mapear Paso 5 (con protección contra null)

        this.paso5DTO = new Paso5DTO(paso5);

        // Mapear PASO 6
        this.paso6_1 = alumno.getPaso6_1();
        this.paso6_2 = alumno.getPaso6_2();
        this.paso6_3 = alumno.getPaso6_3();

        // Mapear PASO 7
        this.paso7_1 = alumno.getPaso7_1();

        // Mapear Paso 8 (con protección contra null)
        this.paso8DTO = new Paso8DTO(paso8);

        // Mapear PASO 9
        this.paso9_1 = alumno.getPaso9_1();

        // Mapear PASO 10
        this.paso10_1 = alumno.getPaso10_1();

        // Mapear Paso 11 (con protección contra null)
        this.paso11DTO = new Paso11DTO(paso11);

        // Mapear observaciones
        this.observaciones = alumno.getObservaciones();
    }

    // Constructor vacío
    public FormularioDTO() {
        super();
        this.paso1DTO = new Paso1DTO();
        this.paso2DTO = new Paso2DTO();
        this.paso3DTO = new Paso3DTO();
        this.paso4DTO = new Paso4DTO();
        this.paso5DTO = new Paso5DTO();
        this.paso8DTO = new Paso8DTO();
        this.paso11DTO = new Paso11DTO();

    }

    public FormularioDTO(Alumnado alumnado) {

        this.id = alumnado.getId();
        this.idCaso = alumnado.getIdCaso();
        this.idDocumento = alumnado.getIdDocumento();
        this.paso7_1 = alumnado.getPaso7_1();
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
        if (alumnado.getPaso3() != null) {
            this.paso3DTO = new Paso3DTO(alumnado.getPaso3());
        } else {
            this.paso3DTO = new Paso3DTO();
        }
        if (alumnado.getPaso4() != null) {
            this.paso4DTO = new Paso4DTO(alumnado.getPaso4());
        } else {
            this.paso4DTO = new Paso4DTO();
        }
        if (alumnado.getPaso5() != null) {
            this.paso5DTO = new Paso5DTO(alumnado.getPaso5());
        } else {
            this.paso5DTO = new Paso5DTO();
        }
        if (alumnado.getPaso8() != null) {
            this.paso8DTO = new Paso8DTO(alumnado.getPaso8());
        } else {
            this.paso8DTO = new Paso8DTO();
        }
        if (alumnado.getPaso11() != null) {
            this.paso11DTO = new Paso11DTO(alumnado.getPaso11());
        } else {
            this.paso11DTO = new Paso11DTO();
        }
    }
}