package es.instituto.orientacion.seguimiento_casos.entities;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso5DTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "Paso5")
public class Paso5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;
    @OneToOne(mappedBy = "paso5",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Anexo4 anexo4;

    @OneToOne(mappedBy = "paso5",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Anexo5 anexo5;

    public Paso5(Paso5DTO paso5DTO){
        this.anexo4 = paso5DTO.getAnexo4();
        this.anexo5 = paso5DTO.getAnexo5();
    }
    public Paso5(){}

}
