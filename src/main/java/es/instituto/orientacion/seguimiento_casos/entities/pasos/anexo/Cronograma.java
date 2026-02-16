package es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo;

import es.instituto.orientacion.seguimiento_casos.entities.dto.CronogramaDTO;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso2;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "cronograma_anexo2")
@Getter
@Setter
public class Cronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fecha de la actuación
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name= "fecha")
    private LocalDate fecha;


    // Situación detectada o contexto
    @Column(name= "situacion")
    private String situacion;

    // Actuación realizada
    @Column(name= "actuacion")
    private String actuacion;

    // Documento generado (actas, informes, etc.)
    @Column(name= "documento")
    private String documento;

    // Observaciones adicionales
    @Column(name= "observaciones")
    private String observaciones;

    // Relación con el caso de alumnado
    @ManyToOne
    @JoinColumn(name = "paso2_id")
    private Paso2 paso2;

    /**
     * Constructor de clase cronograma para el paso2
     * @param cronogramaDTO */
    public Cronograma(CronogramaDTO cronogramaDTO) {
        this.actuacion= cronogramaDTO.getActuacion();
        this.documento= cronogramaDTO.getDocumento();
        this.fecha= cronogramaDTO.getFecha();
        this.situacion= cronogramaDTO.getSituacion();
        this.observaciones = cronogramaDTO.getObservaciones();
    }
    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Cronograma(){}
}
