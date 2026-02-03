package es.instituto.orientacion.seguimiento_casos.entities;

import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "alumnado")
@Getter
@Setter
public class Alumnado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "idCaso")
    private String idCaso;
    @Column(name = "idDocumento")
    private Integer idDocumento;
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso1 paso1;

    // PASO 2
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso2 paso2;

    // PASO 3
    @Column(name = "paso3")
    private String paso3_1;

    // PASO 4
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso4 paso4;

    // PASO 5
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso5 paso5;

    // PASO 6
    private String paso6_1;
    private String paso6_2;
    private String paso6_3;

    // PASO 7
    @Column(name = "paso7")
    private String paso7_1;

    // PASO 8
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso8 paso8;

    // PASO 9
    @Column(name = "paso9")
    private String paso9_1;

    // PASO 10
    @Column(name = "paso10")
    private String paso10_1;

    // PASO 11
    private String paso11_1;
    private String paso11_2;
    private String paso11_3;
    private String paso11_4;

    //OBSERVACIONES
    @Column(name = "observaciones")
    private String observaciones;

    @CreationTimestamp  // Se establece automáticamente al crear
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp  // Se actualiza automáticamente al modificar
    private LocalDateTime fechaUltimaActualizacion;

    public Alumnado(FormularioDTO formularioDTO) {
        this.id = formularioDTO.getId();
        this.idCaso = formularioDTO.getIdCaso();
        this.idDocumento = formularioDTO.getIdDocumento();
        this.paso3_1 = formularioDTO.getPaso3_1();

        this.paso7_1 = formularioDTO.getPaso7_1();
        this.paso9_1 = formularioDTO.getPaso9_1();
        this.paso10_1 = formularioDTO.getPaso10_1();
        if (formularioDTO.getPaso1DTO() != null) {
            Paso1 paso1 = new Paso1(formularioDTO.getPaso1DTO());
            paso1.setAlumnado(this);
            this.paso1 = paso1;
        }
        if (formularioDTO.getPaso2DTO() != null) {
            Paso2 paso2 = new Paso2(formularioDTO.getPaso2DTO());
            paso2.setAlumnado(this);
            this.paso2 = paso2;
        }
        if (formularioDTO.getPaso4DTO() != null) {
            Paso4 paso4 = new Paso4(formularioDTO.getPaso4DTO());
            paso4.setAlumnado(this);
            this.paso4 = paso4;
        }
        if (formularioDTO.getPaso5DTO() != null) {
            Paso5 paso5 = new Paso5(formularioDTO.getPaso5DTO());
            paso5.setAlumnado(this);
            this.paso5 = paso5;
        }
        if (formularioDTO.getPaso8DTO() != null) {
            Paso8 paso8 = new Paso8(formularioDTO.getPaso8DTO());
            paso8.setAlumnado(this);
            this.paso8 = paso8;
        }
    }

    public Alumnado() {
    }
}


