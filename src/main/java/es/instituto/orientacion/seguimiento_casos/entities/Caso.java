package es.instituto.orientacion.seguimiento_casos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "casos")
public class Caso {

    @Id
    private String idCaso;

    private String programa;

    private String paso;

    private String subpaso;

    private String estado;

    private String ubicacionFisica;

    private String observacionesNeutras;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaUltimaActualizacion;


    public Caso() {

    }

    public Caso(String idCaso, String programa, String paso, String subpaso,
                String estado, String ubicacionFisica, String observacionesNeutras) {
        this.idCaso = idCaso;
        this.programa = programa;
        this.paso = paso;
        this.subpaso = subpaso;
        this.estado = estado;
        this.ubicacionFisica = ubicacionFisica;
        this.observacionesNeutras = observacionesNeutras;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaUltimaActualizacion = LocalDateTime.now();
    }

}
