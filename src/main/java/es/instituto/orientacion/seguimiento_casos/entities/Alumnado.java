package es.instituto.orientacion.seguimiento_casos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnado")
@Getter
@Setter
public class Alumnado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idCaso;
    private Integer idDocumento;  // Cambié a Integer para que pueda ser null

    // PASO 1
    // PASO 1 - ANEXO I REAL

    @Column(name = "codigo_alumno")
    private String codigoAlumno;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    @Column(name = "p1_firmas")
    private String firmas;


    // PASO 2
    private String paso2_1;
    private String paso2_2;
    private String paso2_3;
    private String paso2_4;
    private String paso2_5;
    @OneToMany(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Cronograma> cronograma = new ArrayList<>();

    private String paso2_7;

    // PASO 3
    private String paso3_1;

    // PASO 4
    private String paso4_1;

    // PASO 5
    private String paso5_1;
    private String paso5_2;

    // PASO 6
    private String paso6_1;
    private String paso6_2;
    private String paso6_3;

    // PASO 7
    private String paso7_1;

    // PASO 8
    private String paso8_1;

    // PASO 9
    private String paso9_1;

    // PASO 10
    private String paso10_1;

    // PASO 11
    private String paso11_1;
    private String paso11_2;
    private String paso11_3;
    private String paso11_4;

    private String observaciones;

    @CreationTimestamp  // Se establece automáticamente al crear
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp  // Se actualiza automáticamente al modificar
    private LocalDateTime fechaUltimaActualizacion;

    public Alumnado() {}
}


