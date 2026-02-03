package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso8DTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paso8")
public class Paso8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "otrasMedidas")
    private String otrasMedidas;

    @Column(name = "responsableDireccion")
    private String responsableDireccion;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    public Paso8() {
    }

    public Paso8(Paso8DTO paso8DTO) {
        this.otrasMedidas = paso8DTO.getOtrasMedidas();
        this.responsableDireccion = paso8DTO.getResponsableDireccion();
    }
}
