package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso7;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Paso7DTO {

    private Long id;
    private Alumnado alumnado;
    private String codigoAlumno;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String equipoAcompanamiento;
    private String calendarioSeguimiento;
    private Boolean tieneRepositorioAntecedentes;
    private Boolean tieneCronogramaFormalizado;
    private Boolean esFormatoDigital;

    private String medidasPrevencionGeneral;
    private String medidasProteccionSeguridad;
    private String medidasAcompanamientoEmocional;
    private String otrasMedidasAdoptadas;
    private String informacionEquipoDocente;
    private String planificacionObservacionAtencion;

    private String accionesTutor;
    private String intervencionEquipoDocente;
    private String intervencionOrientacion;
    private String intervencionOtrosTrabajadores;
    private String acompanamientoCompaneros;
    private String actividadesSensibilizacionAula;
    private String formacionProfesorado;

    private String actuacionesFamilia;
    private String actuacionesServiciosExternos;

    private String elaboradoPor;
    private LocalDate fechaElaboracion;

    public Paso7DTO() {}

    // Constructor actualizado para referenciar a Paso7
    public Paso7DTO(Paso7 paso7) {
        if (paso7 != null) {
            this.id = paso7.getId();
            this.codigoAlumno = paso7.getCodigoAlumno();
            this.alumnado = paso7.getAlumnado();
            this.objetivoGeneral = paso7.getObjetivoGeneral();
            this.objetivosEspecificos = paso7.getObjetivosEspecificos();
            this.equipoAcompanamiento = paso7.getEquipoAcompanamiento();
            this.calendarioSeguimiento = paso7.getCalendarioSeguimiento();
            this.tieneRepositorioAntecedentes = paso7.getTieneRepositorioAntecedentes();
            this.tieneCronogramaFormalizado = paso7.getTieneCronogramaFormalizado();
            this.esFormatoDigital = paso7.getEsFormatoDigital();
            this.medidasPrevencionGeneral = paso7.getMedidasPrevencionGeneral();
            this.medidasProteccionSeguridad = paso7.getMedidasProteccionSeguridad();
            this.medidasAcompanamientoEmocional = paso7.getMedidasAcompanamientoEmocional();
            this.otrasMedidasAdoptadas = paso7.getOtrasMedidasAdoptadas();
            this.informacionEquipoDocente = paso7.getInformacionEquipoDocente();
            this.planificacionObservacionAtencion = paso7.getPlanificacionObservacionAtencion();
            this.accionesTutor = paso7.getAccionesTutor();
            this.intervencionEquipoDocente = paso7.getIntervencionEquipoDocente();
            this.intervencionOrientacion = paso7.getIntervencionOrientacion();
            this.intervencionOtrosTrabajadores = paso7.getIntervencionOtrosTrabajadores();
            this.acompanamientoCompaneros = paso7.getAcompanamientoCompaneros();
            this.actividadesSensibilizacionAula = paso7.getActividadesSensibilizacionAula();
            this.formacionProfesorado = paso7.getFormacionProfesorado();
            this.actuacionesFamilia = paso7.getActuacionesFamilia();
            this.actuacionesServiciosExternos = paso7.getActuacionesServiciosExternos();
            this.elaboradoPor = paso7.getElaboradoPor();
            this.fechaElaboracion = paso7.getFechaElaboracion();
        }
    }
}