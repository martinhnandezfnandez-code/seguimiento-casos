package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso11DTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "paso11" )
public class Paso11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    @Column(name = "fechacierre")
    private LocalDate fecchacierre;

    @Column(name = "observacionesfechacierre")
    private String observacionesFechaCierre;

    @Column(name = "fechainspeccion")
    private LocalDate fechaInspeccion;

    @Column(name = "inspeccion")
    private String inspeccion;

    @Column(name = "fechafamilia")
    private LocalDate fecchafamilia;

    @Column(name = "familia")
    private String familia;

    @Column(name = "fechaprofesorado")
    private LocalDate fechaProfesorado;

    @Column(name = "profesorado")
    private String profesorado;
    /**
     * Constructor de clase de paso11
     * @param paso11DTO datos no sensibles del alumno correspondientes al paso 11*/
    public Paso11(Paso11DTO paso11DTO) {
        this.fecchacierre = paso11DTO.getFecchacierre();
        this.observacionesFechaCierre = paso11DTO.getObservacionesFechaCierre();
        this.fechaInspeccion = paso11DTO.getFechaInspeccion();
        this.inspeccion = paso11DTO.getInspeccion();
        this.fecchafamilia = paso11DTO.getFecchafamilia();
        this.familia = paso11DTO.getFamilia();
        this.fechaProfesorado = paso11DTO.getFechaProfesorado();
        this.profesorado = paso11DTO.getProfesorado();
    }
    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Paso11() {
    }

}
