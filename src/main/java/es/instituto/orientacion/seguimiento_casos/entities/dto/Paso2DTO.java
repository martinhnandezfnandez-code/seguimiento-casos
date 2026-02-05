package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso2;
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

    private List<CronogramaDTO> cronogramaDTO;

    private String paso2_7;

    public Paso2DTO(Paso2 paso2) {
        this.paso2_1 = paso2.getPaso2_1();
        this.paso2_2 = paso2.getPaso2_2();
        this.paso2_3 = paso2.getPaso2_3();
        this.paso2_4 = paso2.getPaso2_4();
        this.paso2_5 = paso2.getPaso2_5();
        this.cronogramaDTO = new ArrayList<>();
        for (Cronograma cronograma : paso2.getCronograma()) {
            this.cronogramaDTO.add(new CronogramaDTO(cronograma));
        }
        this.paso2_7 = paso2.getPaso2_7();
    }

    public Paso2DTO() {
        this.cronogramaDTO = new ArrayList<>();
    }

}
