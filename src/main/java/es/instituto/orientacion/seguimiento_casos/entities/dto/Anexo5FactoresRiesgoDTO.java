package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5FactoresRiesgo;
import lombok.Data;

@Data
public class Anexo5FactoresRiesgoDTO {

    private Long id;

    // FACTORES DE RIESGO - PERSONALES
    private Boolean intentosSuicidioPrevios;
    private Boolean condicionDiscapacidad;
    private Boolean enfermedadGraveDolorCronico;
    private Boolean trastornosSustancias;
    private Boolean accesoMediosLetales;
    private Boolean impulsividadAgresividadPesimismo;
    private Boolean historiaViolenciaAbuso;
    private Boolean sucesosVitalesEstresantes;
    private Boolean perfeccionismoExcesivo;
    private Boolean autolesiones;
    private Boolean conductaAislamientoSoledad;
    private Boolean serviciosSaludMental;
    private Boolean abandonoTratamiento;
    private Boolean noSeguirPrescripcion;
    private Boolean personalidadInfluyente;
    private Boolean usoInadecuadoTic;
    private Boolean rechazoImagenCorporalTca;
    private Boolean presenciaTeaTdahCapacidades;

    // FACTORES DE RIESGO - FAMILIARES
    private Boolean perdidaGraveReciente;
    private Boolean historialFamiliarSuicidio;
    private Boolean negligenciaEstilosEducativos;
    private Boolean abusosSustanciasAlcoholismo;
    private Boolean estresoresRupturasFamiliares;
    private Boolean familiaNivelesPerfeccionismo;
    private Boolean equilibrioActividadesDomesticas;

    // FACTORES DE RIESGO - SOCIALES Y EDUCATIVOS
    private Boolean faltaPerdidaRedApoyo;
    private Boolean victimaAcosoCiberacoso;
    private Boolean rechazoSocialMaltrato;
    private Boolean desarraigoCultural;
    private Boolean estigmaExclusionGrupo;
    private Boolean existenciaRedApoyoSocial;
    private Boolean buenasRelacionesAdultas;
    private Boolean conflictoConfianzaSituaciones;
    private Boolean amigoSocialCultural;
    private Boolean existenciaProyectoSocialEducativo;

    public Anexo5FactoresRiesgoDTO() {
    }

    public Anexo5FactoresRiesgoDTO(Anexo5FactoresRiesgo entity) {
        if (entity != null) {
            this.id = entity.getId();
            
            // Personales
            this.intentosSuicidioPrevios = entity.getIntentosSuicidioPrevios();
            this.condicionDiscapacidad = entity.getCondicionDiscapacidad();
            this.enfermedadGraveDolorCronico = entity.getEnfermedadGraveDolorCronico();
            this.trastornosSustancias = entity.getTrastornosSustancias();
            this.accesoMediosLetales = entity.getAccesoMediosLetales();
            this.impulsividadAgresividadPesimismo = entity.getImpulsividadAgresividadPesimismo();
            this.historiaViolenciaAbuso = entity.getHistoriaViolenciaAbuso();
            this.sucesosVitalesEstresantes = entity.getSucesosVitalesEstresantes();
            this.perfeccionismoExcesivo = entity.getPerfeccionismoExcesivo();
            this.autolesiones = entity.getAutolesiones();
            this.conductaAislamientoSoledad = entity.getConductaAislamientoSoledad();
            this.serviciosSaludMental = entity.getServiciosSaludMental();
            this.abandonoTratamiento = entity.getAbandonoTratamiento();
            this.noSeguirPrescripcion = entity.getNoSeguirPrescripcion();
            this.personalidadInfluyente = entity.getPersonalidadInfluyente();
            this.usoInadecuadoTic = entity.getUsoInadecuadoTic();
            this.rechazoImagenCorporalTca = entity.getRechazoImagenCorporalTca();
            this.presenciaTeaTdahCapacidades = entity.getPresenciaTeaTdahCapacidades();
            
            // Familiares
            this.perdidaGraveReciente = entity.getPerdidaGraveReciente();
            this.historialFamiliarSuicidio = entity.getHistorialFamiliarSuicidio();
            this.negligenciaEstilosEducativos = entity.getNegligenciaEstilosEducativos();
            this.abusosSustanciasAlcoholismo = entity.getAbusosSustanciasAlcoholismo();
            this.estresoresRupturasFamiliares = entity.getEstresoresRupturasFamiliares();
            this.familiaNivelesPerfeccionismo = entity.getFamiliaNivelesPerfeccionismo();
            this.equilibrioActividadesDomesticas = entity.getEquilibrioActividadesDomesticas();
            
            // Sociales y educativos
            this.faltaPerdidaRedApoyo = entity.getFaltaPerdidaRedApoyo();
            this.victimaAcosoCiberacoso = entity.getVictimaAcosoCiberacoso();
            this.rechazoSocialMaltrato = entity.getRechazoSocialMaltrato();
            this.desarraigoCultural = entity.getDesarraigoCultural();
            this.estigmaExclusionGrupo = entity.getEstigmaExclusionGrupo();
            this.existenciaRedApoyoSocial = entity.getExistenciaRedApoyoSocial();
            this.buenasRelacionesAdultas = entity.getBuenasRelacionesAdultas();
            this.conflictoConfianzaSituaciones = entity.getConflictoConfianzaSituaciones();
            this.amigoSocialCultural = entity.getAmigoSocialCultural();
            this.existenciaProyectoSocialEducativo = entity.getExistenciaProyectoSocialEducativo();
        }
    }
}
