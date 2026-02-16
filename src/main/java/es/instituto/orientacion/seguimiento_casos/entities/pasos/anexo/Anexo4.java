package es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Anexo4DTO;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso5;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "anexo4")
public class    Anexo4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sintesisfamilia")
    private String sintesisfamilia;

    @Column(name = "integrantesfamilia")
    private String integrantesfamilia;

    @Column(name = "fechafamilia")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechafamilia;

    @Column(name = "sintesisalumno")
    private String sintesisalumno;

    @Column(name = "integrantesalumno")
    private String integrantesalumno;

    @Column(name = "fechaalumno")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaalumno;


    @OneToOne
    @JoinColumn(name = "paso5_id")
    private Paso5 paso5;

    public void actualizarDesdeDTO(Anexo4DTO dto) {
        this.sintesisalumno = dto.getSintesisalumno();
        this.fechaalumno = dto.getFechaalumno();
        this.integrantesalumno = dto.getIntegrantesalumno();
        this.sintesisfamilia = dto.getSintesisfamilia();
        this.fechafamilia = dto.getFechafamilia();
        this.integrantesfamilia = dto.getIntegrantesfamilia();
    }
    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Anexo4() {
    }
    public Anexo4(Anexo4DTO anexo4DTO) {
        this.sintesisalumno = anexo4DTO.getSintesisalumno();
        this.fechaalumno = anexo4DTO.getFechaalumno();
        this.integrantesalumno = anexo4DTO.getIntegrantesalumno();
        this.sintesisfamilia = anexo4DTO.getSintesisfamilia();
        this.fechafamilia = anexo4DTO.getFechafamilia();
        this.integrantesfamilia = anexo4DTO.getIntegrantesfamilia();
    }
}
