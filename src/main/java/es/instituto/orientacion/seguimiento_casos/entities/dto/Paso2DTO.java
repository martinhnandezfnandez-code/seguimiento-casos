package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Cronograma;
import es.instituto.orientacion.seguimiento_casos.entities.Paso2;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Paso2DTO {

    private String paso2_1;

    private String paso2_2;

    private String paso2_3;

    private String paso2_4;

    private String paso2_5;

    private List<Cronograma> cronograma = new ArrayList<>();

    private String paso2_7;

    public Paso2DTO(Paso2 paso2) {
        this.paso2_1 = paso2.getPaso2_1();
        this.paso2_2 = paso2.getPaso2_2();
        this.paso2_3 = paso2.getPaso2_3();
        this.paso2_4 = paso2.getPaso2_4();
        this.paso2_5 = paso2.getPaso2_5();
        this.cronograma = paso2.getCronograma();
        this.paso2_7 = paso2.getPaso2_7();
    }
    public Paso2DTO(){
        this.cronograma = new ArrayList<>();
    }

}
