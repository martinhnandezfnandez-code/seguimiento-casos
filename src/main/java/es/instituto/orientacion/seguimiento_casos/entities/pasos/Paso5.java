package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo4;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso5DTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Paso5")
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
    /**
     * Constructor de clase de paso5
     * @param paso5DTO datos no sensibles del alumno correspondientes al paso 5*/
    public Paso5(Paso5DTO paso5DTO) {
        if (paso5DTO != null) {
            this.alumnado = paso5DTO.getAlumnado();

            if (paso5DTO.getAnexo4() != null) {
                Anexo4 anexo4Entity = new Anexo4(paso5DTO.getAnexo4());
                anexo4Entity.setPaso5(this);
                this.anexo4 = anexo4Entity;
            }

            if (paso5DTO.getAnexo5() != null) {
                Anexo5 anexo5Entity = new Anexo5(paso5DTO.getAnexo5());
                anexo5Entity.setPaso5(this);
                this.anexo5 = anexo5Entity;
            }
        }
    }

    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Paso5() {

    }

}
