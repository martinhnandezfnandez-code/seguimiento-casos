package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso3DTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paso3")
@Data
public class Paso3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    @Column(name = "medidasprovisionales")
    private String medidasProvisionales;



    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Paso3() {
    }
    /**
     * Constructor de clase de paso 3
     * @param paso3DTO datos no sensibles del alumno correspondientes al paso 3*/
    public Paso3(Paso3DTO paso3DTO) {
        this.medidasProvisionales = paso3DTO.getMedidasProvisionales();
    }
}
