package es.instituto.orientacion.seguimiento_casos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "cronograma_anexo2")
@Getter
@Setter
public class Cronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fecha de la actuación
    @Column(name= "fecha")
    private LocalDate fecha;

    // Situación detectada o contexto
    @Column(name= "situacion")
    private String situacion;

    // Actuación realizada
    @Column(name= "actuacion")
    private String actuacion;

    // Documento generado (actas, informes, etc.)
    @Column(name= "documento")
    private String documento;

    // Observaciones adicionales
    @Column(name= "observaciones")
    private String observaciones;

    // Relación con el caso de alumnado
    @ManyToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    public Cronograma() {}
}
