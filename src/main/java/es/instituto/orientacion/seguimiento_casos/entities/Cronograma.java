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
    private LocalDate fecha;

    // Situación detectada o contexto
    private String situacion;

    // Actuación realizada
    private String actuacion;

    // Documento generado (actas, informes, etc.)
    private String documento;

    // Observaciones adicionales
    private String observaciones;

    // Relación con el caso de alumnado
    @ManyToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    public Cronograma() {}
}
