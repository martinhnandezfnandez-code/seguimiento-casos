package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso1DTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "paso1")
@Data
public class Paso1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "p1_familia_comunica")
    private Boolean familiaComunica;

    @Column(name = "p1_companeros_comunican")
    private Boolean companerosComunican;

    @Column(name = "p1_alumno_comunica")
    private Boolean alumnoComunica;

    @Column(name = "p1_intento_previo")
    private Boolean intentoPrevio;

    @Column(name = "p1_conducta_autolesiva")
    private Boolean conductaAutolesiva;

    @Column(name = "p1_otros")
    private Boolean otrosMotivo;

    @Column(name = "p1_otros_detalle")
    private String otrosDetalle;

    @Column(name = "p1_detalle_hechos", length = 500)
    private String detalleHechos;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "p1_firmas")
    private String firmas;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    public Paso1(Paso1DTO paso1DTO) {
        this.alumnoComunica = paso1DTO.getAlumnoComunica();
        this.companerosComunican = paso1DTO.getCompanerosComunican();
        this.detalleHechos = paso1DTO.getDetalleHechos();
        this.intentoPrevio = paso1DTO.getIntentoPrevio();
        this.familiaComunica = paso1DTO.getFamiliaComunica();
        this.conductaAutolesiva = paso1DTO.getConductaAutolesiva();
        this.otrosDetalle = paso1DTO.getOtrosDetalle();
        this.fechaRegistro = paso1DTO.getFechaRegistro();
        this.firmas = paso1DTO.getFirmas();

    }
    public Paso1(){}
}
