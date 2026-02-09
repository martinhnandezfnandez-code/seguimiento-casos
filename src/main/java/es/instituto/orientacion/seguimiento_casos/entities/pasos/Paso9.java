package es.instituto.orientacion.seguimiento_casos.entities.pasos;


import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso3DTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso9DTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paso9")
@Data
public class Paso9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    @Column(name = "directorinforma")
    private String directorinforma;

    public Paso9() {
    }

    public Paso9(Paso9DTO paso9DTO) {
        this.directorinforma = paso9DTO.getDirectorinforma();
    }
}
