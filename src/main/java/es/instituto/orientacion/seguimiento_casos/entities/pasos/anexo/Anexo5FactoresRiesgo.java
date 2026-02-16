package es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Anexo5FactoresRiesgoDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "anexo5_factores_riesgo")
public class Anexo5FactoresRiesgo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FACTORES DE RIESGO - PERSONALES
    @Column(name = "intentos_suicidio_previos")
    private Boolean intentosSuicidioPrevios;

    @Column(name = "condicion_discapacidad")
    private Boolean condicionDiscapacidad;

    @Column(name = "enfermedad_grave_dolor_cronico")
    private Boolean enfermedadGraveDolorCronico;

    @Column(name = "trastornos_sustancias")
    private Boolean trastornosSustancias;

    @Column(name = "acceso_medios_letales")
    private Boolean accesoMediosLetales;

    @Column(name = "impulsividad_agresividad_pesimismo")
    private Boolean impulsividadAgresividadPesimismo;

    @Column(name = "historia_violencia_abuso")
    private Boolean historiaViolenciaAbuso;

    @Column(name = "sucesos_vitales_estresantes")
    private Boolean sucesosVitalesEstresantes;

    @Column(name = "perfeccionismo_excesivo")
    private Boolean perfeccionismoExcesivo;

    @Column(name = "autolesiones")
    private Boolean autolesiones;

    @Column(name = "conducta_aislamiento_soledad")
    private Boolean conductaAislamientoSoledad;

    @Column(name = "servicios_salud_mental")
    private Boolean serviciosSaludMental;

    @Column(name = "abandono_tratamiento")
    private Boolean abandonoTratamiento;

    @Column(name = "no_seguir_prescripcion")
    private Boolean noSeguirPrescripcion;

    @Column(name = "personalidad_influyente")
    private Boolean personalidadInfluyente;

    @Column(name = "uso_inadecuado_tic")
    private Boolean usoInadecuadoTic;

    @Column(name = "rechazo_imagen_corporal_tca")
    private Boolean rechazoImagenCorporalTca;

    @Column(name = "presencia_tea_tdah_capacidades")
    private Boolean presenciaTeaTdahCapacidades;

    // FACTORES DE RIESGO - FAMILIARES
    @Column(name = "perdida_grave_reciente")
    private Boolean perdidaGraveReciente;

    @Column(name = "historial_familiar_suicidio")
    private Boolean historialFamiliarSuicidio;

    @Column(name = "negligencia_estilos_educativos")
    private Boolean negligenciaEstilosEducativos;

    @Column(name = "abusos_sustancias_alcoholismo")
    private Boolean abusosSustanciasAlcoholismo;

    @Column(name = "estresores_rupturas_familiares")
    private Boolean estresoresRupturasFamiliares;

    @Column(name = "familia_niveles_perfeccionismo")
    private Boolean familiaNivelesPerfeccionismo;

    @Column(name = "equilibrio_actividades_domesticas")
    private Boolean equilibrioActividadesDomesticas;

    // FACTORES DE RIESGO - SOCIALES Y EDUCATIVOS
    @Column(name = "falta_perdida_red_apoyo")
    private Boolean faltaPerdidaRedApoyo;

    @Column(name = "victima_acoso_ciberacoso")
    private Boolean victimaAcosoCiberacoso;

    @Column(name = "rechazo_social_maltrato")
    private Boolean rechazoSocialMaltrato;

    @Column(name = "desarraigo_cultural")
    private Boolean desarraigoCultural;

    @Column(name = "estigma_exclusion_grupo")
    private Boolean estigmaExclusionGrupo;

    @Column(name = "existencia_red_apoyo_social")
    private Boolean existenciaRedApoyoSocial;

    @Column(name = "buenas_relaciones_adultas")
    private Boolean buenasRelacionesAdultas;

    @Column(name = "conflicto_confianza_situaciones")
    private Boolean conflictoConfianzaSituaciones;

    @Column(name = "amigo_social_cultural")
    private Boolean amigoSocialCultural;

    @Column(name = "existencia_proyecto_social_educativo")
    private Boolean existenciaProyectoSocialEducativo;

    @OneToOne
    @JoinColumn(name = "anexo5_id")
    private Anexo5 anexo5;
    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Anexo5FactoresRiesgo() {
    }

    public Anexo5FactoresRiesgo(Anexo5FactoresRiesgoDTO dto) {
        if (dto != null) {
            // Personales
            this.intentosSuicidioPrevios = dto.getIntentosSuicidioPrevios();
            this.condicionDiscapacidad = dto.getCondicionDiscapacidad();
            this.enfermedadGraveDolorCronico = dto.getEnfermedadGraveDolorCronico();
            this.trastornosSustancias = dto.getTrastornosSustancias();
            this.accesoMediosLetales = dto.getAccesoMediosLetales();
            this.impulsividadAgresividadPesimismo = dto.getImpulsividadAgresividadPesimismo();
            this.historiaViolenciaAbuso = dto.getHistoriaViolenciaAbuso();
            this.sucesosVitalesEstresantes = dto.getSucesosVitalesEstresantes();
            this.perfeccionismoExcesivo = dto.getPerfeccionismoExcesivo();
            this.autolesiones = dto.getAutolesiones();
            this.conductaAislamientoSoledad = dto.getConductaAislamientoSoledad();
            this.serviciosSaludMental = dto.getServiciosSaludMental();
            this.abandonoTratamiento = dto.getAbandonoTratamiento();
            this.noSeguirPrescripcion = dto.getNoSeguirPrescripcion();
            this.personalidadInfluyente = dto.getPersonalidadInfluyente();
            this.usoInadecuadoTic = dto.getUsoInadecuadoTic();
            this.rechazoImagenCorporalTca = dto.getRechazoImagenCorporalTca();
            this.presenciaTeaTdahCapacidades = dto.getPresenciaTeaTdahCapacidades();
            
            // Familiares
            this.perdidaGraveReciente = dto.getPerdidaGraveReciente();
            this.historialFamiliarSuicidio = dto.getHistorialFamiliarSuicidio();
            this.negligenciaEstilosEducativos = dto.getNegligenciaEstilosEducativos();
            this.abusosSustanciasAlcoholismo = dto.getAbusosSustanciasAlcoholismo();
            this.estresoresRupturasFamiliares = dto.getEstresoresRupturasFamiliares();
            this.familiaNivelesPerfeccionismo = dto.getFamiliaNivelesPerfeccionismo();
            this.equilibrioActividadesDomesticas = dto.getEquilibrioActividadesDomesticas();
            
            // Sociales y educativos
            this.faltaPerdidaRedApoyo = dto.getFaltaPerdidaRedApoyo();
            this.victimaAcosoCiberacoso = dto.getVictimaAcosoCiberacoso();
            this.rechazoSocialMaltrato = dto.getRechazoSocialMaltrato();
            this.desarraigoCultural = dto.getDesarraigoCultural();
            this.estigmaExclusionGrupo = dto.getEstigmaExclusionGrupo();
            this.existenciaRedApoyoSocial = dto.getExistenciaRedApoyoSocial();
            this.buenasRelacionesAdultas = dto.getBuenasRelacionesAdultas();
            this.conflictoConfianzaSituaciones = dto.getConflictoConfianzaSituaciones();
            this.amigoSocialCultural = dto.getAmigoSocialCultural();
            this.existenciaProyectoSocialEducativo = dto.getExistenciaProyectoSocialEducativo();
        }
    }
    public void actualizarDesdeDTO(Anexo5FactoresRiesgoDTO dto) {
        // Factores Personales
        this.intentosSuicidioPrevios = dto.getIntentosSuicidioPrevios();
        this.condicionDiscapacidad = dto.getCondicionDiscapacidad();
        this.enfermedadGraveDolorCronico = dto.getEnfermedadGraveDolorCronico();
        this.trastornosSustancias = dto.getTrastornosSustancias();
        this.accesoMediosLetales = dto.getAccesoMediosLetales();
        this.impulsividadAgresividadPesimismo = dto.getImpulsividadAgresividadPesimismo();
        this.historiaViolenciaAbuso = dto.getHistoriaViolenciaAbuso();
        this.sucesosVitalesEstresantes = dto.getSucesosVitalesEstresantes();
        this.perfeccionismoExcesivo = dto.getPerfeccionismoExcesivo();
        this.autolesiones = dto.getAutolesiones();
        this.conductaAislamientoSoledad = dto.getConductaAislamientoSoledad();
        this.serviciosSaludMental = dto.getServiciosSaludMental();
        this.abandonoTratamiento = dto.getAbandonoTratamiento();
        this.noSeguirPrescripcion = dto.getNoSeguirPrescripcion();
        this.personalidadInfluyente = dto.getPersonalidadInfluyente();
        this.usoInadecuadoTic = dto.getUsoInadecuadoTic();
        this.rechazoImagenCorporalTca = dto.getRechazoImagenCorporalTca();
        this.presenciaTeaTdahCapacidades = dto.getPresenciaTeaTdahCapacidades();

        // Factores Familiares
        this.perdidaGraveReciente = dto.getPerdidaGraveReciente();
        this.historialFamiliarSuicidio = dto.getHistorialFamiliarSuicidio();
        this.negligenciaEstilosEducativos = dto.getNegligenciaEstilosEducativos();
        this.abusosSustanciasAlcoholismo = dto.getAbusosSustanciasAlcoholismo();
        this.estresoresRupturasFamiliares = dto.getEstresoresRupturasFamiliares();
        this.familiaNivelesPerfeccionismo = dto.getFamiliaNivelesPerfeccionismo();
        this.equilibrioActividadesDomesticas = dto.getEquilibrioActividadesDomesticas();

        // Factores Sociales y Educativos
        this.faltaPerdidaRedApoyo = dto.getFaltaPerdidaRedApoyo();
        this.victimaAcosoCiberacoso = dto.getVictimaAcosoCiberacoso();
        this.rechazoSocialMaltrato = dto.getRechazoSocialMaltrato();
        this.desarraigoCultural = dto.getDesarraigoCultural();
        this.estigmaExclusionGrupo = dto.getEstigmaExclusionGrupo();
        this.existenciaRedApoyoSocial = dto.getExistenciaRedApoyoSocial();
        this.buenasRelacionesAdultas = dto.getBuenasRelacionesAdultas();
        this.conflictoConfianzaSituaciones = dto.getConflictoConfianzaSituaciones();
    }
}
