package es.instituto.orientacion.seguimiento_casos.entities;


import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso4DTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "paso4")
public class Paso4 {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "asistentes")
    private String asistentes;

     @Column(name= "contenido")
    private String contenido;

     @Column(name = "acuerdos")
    private  String acuerdos;

     @Column(name = "fecha")
    private LocalDate fecha;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    public Paso4(Paso4DTO paso4DTO){
        this.acuerdos = paso4DTO.getAcuerdos();
        this.asistentes = paso4DTO.getAsistentes();
        this.fecha = paso4DTO.getFecha();
        this.contenido = paso4DTO.getContenido();

    }
    public Paso4(){}
}