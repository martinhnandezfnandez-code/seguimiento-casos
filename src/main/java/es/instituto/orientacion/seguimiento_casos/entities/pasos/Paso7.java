package es.instituto.orientacion.seguimiento_casos.entities.pasos;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso7DTO;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "paso7_plan_prevencion")
public class Paso7 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "alumnado_id")
    private Alumnado alumnado;

    // 1. DATOS IDENTIFICATIVOS
    @Column(name = "codigo_alumno")
    private String codigoAlumno;

    // 2. OBJETIVOS
    @Column(name = "objetivo_general", columnDefinition = "TEXT")
    private String objetivoGeneral;

    @Column(name = "objetivos_especificos", columnDefinition = "TEXT")
    private String objetivosEspecificos;

    // 3. EQUIPO Y CALENDARIO
    @Column(name = "equipo_acompanamiento", columnDefinition = "TEXT")
    private String equipoAcompanamiento;

    @Column(name = "calendario_seguimiento", columnDefinition = "TEXT")
    private String calendarioSeguimiento;

    // 5. CHECKLIST DE FORMALIZACIÓN
    @Column(name = "tiene_repositorio_antecedentes")
    private Boolean tieneRepositorioAntecedentes;

    @Column(name = "tiene_cronograma_formalizado")
    private Boolean tieneCronogramaFormalizado;

    @Column(name = "es_formato_digital")
    private Boolean esFormatoDigital;

    // CONCRECIÓN DEL PLAN - ACTUACIONES CENTRO EDUCATIVO
    @Column(name = "medidas_prevencion_general", columnDefinition = "TEXT")
    private String medidasPrevencionGeneral;

    @Column(name = "medidas_proteccion_seguridad", columnDefinition = "TEXT")
    private String medidasProteccionSeguridad;

    @Column(name = "medidas_acompanamiento_emocional", columnDefinition = "TEXT")
    private String medidasAcompanamientoEmocional;

    @Column(name = "otras_medidas_adoptadas", columnDefinition = "TEXT")
    private String otrasMedidasAdoptadas;

    @Column(name = "informacion_equipo_docente", columnDefinition = "TEXT")
    private String informacionEquipoDocente;

    @Column(name = "planificacion_observacion_atencion", columnDefinition = "TEXT")
    private String planificacionObservacionAtencion;

    // INTERVENCIÓN ESPECÍFICA
    @Column(name = "acciones_tutor", columnDefinition = "TEXT")
    private String accionesTutor;

    @Column(name = "intervencion_equipo_docente", columnDefinition = "TEXT")
    private String intervencionEquipoDocente;

    @Column(name = "intervencion_orientacion", columnDefinition = "TEXT")
    private String intervencionOrientacion;

    @Column(name = "intervencion_otros_trabajadores", columnDefinition = "TEXT")
    private String intervencionOtrosTrabajadores;

    @Column(name = "acompanamiento_companeros", columnDefinition = "TEXT")
    private String acompanamientoCompaneros;

    @Column(name = "actividades_sensibilizacion_aula", columnDefinition = "TEXT")
    private String actividadesSensibilizacionAula;

    @Column(name = "formacion_profesorado", columnDefinition = "TEXT")
    private String formacionProfesorado;

    // COORDINACIÓN EXTERNA
    @Column(name = "actuaciones_familia", columnDefinition = "TEXT")
    private String actuacionesFamilia;

    @Column(name = "actuaciones_servicios_externos", columnDefinition = "TEXT")
    private String actuacionesServiciosExternos;

    // METADATOS DE CONTROL
    @Column(name = "elaborado_por")
    private String elaboradoPor;

    @Column(name = "fecha_elaboracion")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaElaboracion;

    public Paso7() {}

    public Paso7(Paso7DTO paso7DTO) {
        if (paso7DTO != null) {
            this.id = paso7DTO.getId();
            this.alumnado = paso7DTO.getAlumnado();
            this.codigoAlumno = paso7DTO.getCodigoAlumno();
            this.objetivoGeneral = paso7DTO.getObjetivoGeneral();
            this.objetivosEspecificos = paso7DTO.getObjetivosEspecificos();
            this.equipoAcompanamiento = paso7DTO.getEquipoAcompanamiento();
            this.calendarioSeguimiento = paso7DTO.getCalendarioSeguimiento();
            this.tieneRepositorioAntecedentes = paso7DTO.getTieneRepositorioAntecedentes();
            this.tieneCronogramaFormalizado = paso7DTO.getTieneCronogramaFormalizado();
            this.esFormatoDigital = paso7DTO.getEsFormatoDigital();
            this.medidasPrevencionGeneral = paso7DTO.getMedidasPrevencionGeneral();
            this.medidasProteccionSeguridad = paso7DTO.getMedidasProteccionSeguridad();
            this.medidasAcompanamientoEmocional = paso7DTO.getMedidasAcompanamientoEmocional();
            this.otrasMedidasAdoptadas = paso7DTO.getOtrasMedidasAdoptadas();
            this.informacionEquipoDocente = paso7DTO.getInformacionEquipoDocente();
            this.planificacionObservacionAtencion = paso7DTO.getPlanificacionObservacionAtencion();
            this.accionesTutor = paso7DTO.getAccionesTutor();
            this.intervencionEquipoDocente = paso7DTO.getIntervencionEquipoDocente();
            this.intervencionOrientacion = paso7DTO.getIntervencionOrientacion();
            this.intervencionOtrosTrabajadores = paso7DTO.getIntervencionOtrosTrabajadores();
            this.acompanamientoCompaneros = paso7DTO.getAcompanamientoCompaneros();
            this.actividadesSensibilizacionAula = paso7DTO.getActividadesSensibilizacionAula();
            this.formacionProfesorado = paso7DTO.getFormacionProfesorado();
            this.actuacionesFamilia = paso7DTO.getActuacionesFamilia();
            this.actuacionesServiciosExternos = paso7DTO.getActuacionesServiciosExternos();
            this.elaboradoPor = paso7DTO.getElaboradoPor();
            this.fechaElaboracion = paso7DTO.getFechaElaboracion();
        }
    }
}