package es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Anexo4DTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Anexo5DTO;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso5;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "anexo5")
public class Anexo5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detectado_por")
    private String detectadoPor;

    @Column(name = "fecha_deteccion")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDeteccion;

    @Column(name = "observaciones", length = 2000)
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "paso5_id")
    private Paso5 paso5;

    @OneToOne(mappedBy = "anexo5", cascade = CascadeType.ALL, orphanRemoval = true)
    private Anexo5SenalesAlarma senalesAlarma;

    @OneToOne(mappedBy = "anexo5", cascade = CascadeType.ALL, orphanRemoval = true)
    private Anexo5FactoresRiesgo factoresRiesgo;

    @OneToOne(mappedBy = "anexo5", cascade = CascadeType.ALL, orphanRemoval = true)
    private Anexo5FactoresProteccion factoresProteccion;
    public void actualizarDesdeDTO(Anexo5DTO dto) {
        if (dto != null) {
            this.detectadoPor = dto.getDetectadoPor();
            this.fechaDeteccion = dto.getFechaDeteccion();
            this.observaciones = dto.getObservaciones();

            if (dto.getSenalesAlarma() != null) {
                this.senalesAlarma = new Anexo5SenalesAlarma(dto.getSenalesAlarma());
                this.senalesAlarma.setAnexo5(this);
            }

            if (dto.getFactoresRiesgo() != null) {
                this.factoresRiesgo = new Anexo5FactoresRiesgo(dto.getFactoresRiesgo());
                this.factoresRiesgo.setAnexo5(this);
            }

            if (dto.getFactoresProteccion() != null) {
                this.factoresProteccion = new Anexo5FactoresProteccion(dto.getFactoresProteccion());
                this.factoresProteccion.setAnexo5(this);
            }
        }
    }

    public Anexo5() {
    }

    public Anexo5(Anexo5DTO dto) {
        if (dto != null) {
            this.detectadoPor = dto.getDetectadoPor();
            this.fechaDeteccion = dto.getFechaDeteccion();
            this.observaciones = dto.getObservaciones();
            
            if (dto.getSenalesAlarma() != null) {
                this.senalesAlarma = new Anexo5SenalesAlarma(dto.getSenalesAlarma());
                this.senalesAlarma.setAnexo5(this);
            }
            
            if (dto.getFactoresRiesgo() != null) {
                this.factoresRiesgo = new Anexo5FactoresRiesgo(dto.getFactoresRiesgo());
                this.factoresRiesgo.setAnexo5(this);
            }
            
            if (dto.getFactoresProteccion() != null) {
                this.factoresProteccion = new Anexo5FactoresProteccion(dto.getFactoresProteccion());
                this.factoresProteccion.setAnexo5(this);
            }
        }
    }
}
