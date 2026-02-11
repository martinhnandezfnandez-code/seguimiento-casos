package es.instituto.orientacion.seguimiento_casos.entities.pasos;


import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso6DTO;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Table(name = "anexo6")
@Entity
@Data
public class Paso6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    @Column(name="tutores")
    private Boolean tutores;

    @Column(name = "alumno")
    private  Boolean alumno;

    @Column (name = "inspeccion")
    private Boolean inspeccion;

    @Column ( name = "comision")
    private  Boolean comision;

    @Column(name = "serviciosexternos")
    private  Boolean servicios;

    @Column(name = "otros")
    private  Boolean otros;

    @Column ( name = "otrosespecificados")
    private String otrosespecificados;

    @Column(name = "abrir")
    private Boolean abrir;

    @Column(name = "motivacion")
    private  Boolean motivacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Paso6() {
    }
    public Paso6(Paso6DTO paso6DTO) {
        this.tutores = paso6DTO.getTutores();
        this.abrir = paso6DTO.getAbrir();
        this.alumno = paso6DTO.getAlumno();
        this.inspeccion = paso6DTO.getInspeccion();
        this.servicios = paso6DTO.getServicios();
        this.comision = paso6DTO.getComision();
        this.otros = paso6DTO.getOtros();
        this.otrosespecificados = paso6DTO.getOtrosespecificados();
        this.motivacion = paso6DTO.getMotivacion();
        this.fecha = paso6DTO.getFecha();
    }
}
