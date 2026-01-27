package es.instituto.orientacion.seguimiento_casos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "casos")
@Getter
@Setter
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_caso", nullable = false, unique = true)
    private String idCaso;

    private String programa;
    private String paso;
    private String subpaso;
    private String estado;
    private String ubicacionFisica;
    private String observacionesNeutras;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;

    public Caso() {}
}
