package es.instituto.orientacion.seguimiento_casos.entities;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso2DTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paso2")
@Data
public class Paso2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ConstitucióndelEA")
    private String paso2_1;


    @Column(name = "Actaconmedidasinmediatas")
    private String paso2_2;

    @Column(name = "Informarafamilia")
    private String paso2_3;

    @Column(name = "InformaraInspección")
    private String paso2_4;

    @Column(name = "InformaralaCPAyC")
    private String paso2_5;

    @OneToMany(mappedBy = "paso2",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Cronograma> cronograma = new ArrayList<>();

    @Column(name = "AntiguoAnexoI")
    private String paso2_7;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    public Paso2(Paso2DTO paso2DTO) {
        this.paso2_1 = paso2DTO.getPaso2_1();
        this.paso2_2 = paso2DTO.getPaso2_2();
        this.paso2_3 = paso2DTO.getPaso2_3();
        this.paso2_4 = paso2DTO.getPaso2_4();
        this.paso2_5 = paso2DTO.getPaso2_5();
        this.cronograma = paso2DTO.getCronograma();
        this.paso2_7 = paso2DTO.getPaso2_7();
    }
   public Paso2(){
       this.cronograma = new ArrayList<>();
   }

}
