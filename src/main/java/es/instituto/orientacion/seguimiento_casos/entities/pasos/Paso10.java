package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso10DTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso3DTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paso10")
@Data
public class Paso10 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    @Column(name = "medidasprovisionales")
    private String seguiminetoInspeccion;
    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Paso10() {
    }
    /**
     * Constructor de clase de paso10
     * @param paso10DTO datos no sensibles del alumno correspondientes al paso 10*/
    public Paso10(Paso10DTO paso10DTO) {
        this.seguiminetoInspeccion = paso10DTO.getSeguiminetoInspeccion();
    }
}
