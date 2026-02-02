package es.instituto.orientacion.seguimiento_casos.entities;

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


    @Column(name = "expresa_deseo_morir")
    private Boolean expresaDeseoMorir;

    @Column(name = "amenazas_verbales")
    private Boolean amenazasVerbales;

    @Column(name = "comentarios_culpa_inutilidad")
    private Boolean comentariosCulpaInutilidad;

    @Column(name = "aislamiento_social")
    private Boolean aislamientoSocial;

    @Column(name = "abandono_actividades")
    private Boolean abandonoActividades;

    @Column(name = "conductas_autolesivas")
    private Boolean conductasAutolesivas;

    @Column(name = "regala_pertenencias")
    private Boolean regalaPertenencias;

    @Column(name = "cambios_bruscos_conducta")
    private Boolean cambiosBruscosConducta;

    @Column(name = "tristeza_intensa")
    private Boolean tristezaIntensa;

    @Column(name = "irritabilidad")
    private Boolean irritabilidad;

    @Column(name = "ansiedad")
    private Boolean ansiedad;

    @Column(name = "desesperanza")
    private Boolean desesperanza;


    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    @Column(name = "detectado_por")
    private String detectadoPor;

    @Column(name = "fecha_deteccion")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDeteccion;

    @OneToOne
    @JoinColumn(name = "paso5_id")
    private Paso5 paso5;

    public Anexo5() {
    }
}
