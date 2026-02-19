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



    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Paso8() {
    }
    /**
     * Constructor de clase de paso8
     * @param paso8DTO datos no sensibles del alumno correspondientes al paso 8*/
    public Paso8(Paso8DTO paso8DTO) {
        this.otrasMedidas = paso8DTO.getOtrasMedidas();
        this.responsableDireccion = paso8DTO.getResponsableDireccion();
    }
}
