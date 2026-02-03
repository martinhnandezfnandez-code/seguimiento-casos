package es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Anexo5SenalesAlarmaDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "anexo5_senales_alarma")
public class Anexo5SenalesAlarma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SEÑALES DIRECTAS
    @Column(name = "comunicacion_bloqueo_dolor_emocional")
    private Boolean comunicacionBloqueoDolor;

    @Column(name = "comunicacion_desesperanza")
    private Boolean comunicacionDesesperanza;

    @Column(name = "comunicacion_desvinculacion_proyectos")
    private Boolean comunicacionDesvinculacionProyectos;

    @Column(name = "comunicacion_no_ser_importante")
    private Boolean comunicacionNoSerImportante;

    @Column(name = "comunicacion_carga_familiar")
    private Boolean comunicacionCargaFamiliar;

    @Column(name = "comunicacion_pensamientos_aislados_muerte")
    private Boolean comunicacionPensamientosAisladosMuerte;

    @Column(name = "comunicacion_deseo_explicito_suicidio")
    private Boolean comunicacionDeseoExplicitoSuicidio;

    @Column(name = "referencias_metodos_suicidio")
    private Boolean referenciasMetodosSuicidio;

    @Column(name = "plan_conducta_suicida")
    private Boolean planConductaSuicida;

    @Column(name = "busqueda_formas_suicidio")
    private Boolean busquedaFormasSuicidio;

    // SEÑALES INDIRECTAS
    @Column(name = "existencia_intento_previo")
    private Boolean existenciaIntentoPrevio;

    @Column(name = "conductas_riesgo_hacer_dano")
    private Boolean conductasRiesgoHacerDano;

    @Column(name = "cambios_comportamiento_caracter")
    private Boolean cambiosComportamientoCaracter;

    @Column(name = "comportamientos_angustia_irritacion")
    private Boolean comportamientosAngustiaIrritacion;

    @Column(name = "senales_abatimiento_actividades")
    private Boolean senalesAbatimientoActividades;

    @Column(name = "absentismo_escolar")
    private Boolean absentismoEscolar;

    @Column(name = "alteraciones_ritmos_patrones")
    private Boolean alteracionesRitmosPatrones;

    @Column(name = "conductas_relacionales_temas_pendientes")
    private Boolean conductasRelacionalesTemasPendientes;

    @Column(name = "inicio_consumo_sustancias")
    private Boolean inicioConsumoSustancias;

    @OneToOne
    @JoinColumn(name = "anexo5_id")
    private Anexo5 anexo5;

    public Anexo5SenalesAlarma() {
    }

    public Anexo5SenalesAlarma(Anexo5SenalesAlarmaDTO dto) {
        if (dto != null) {
            // Señales directas
            this.comunicacionBloqueoDolor = dto.getComunicacionBloqueoDolor();
            this.comunicacionDesesperanza = dto.getComunicacionDesesperanza();
            this.comunicacionDesvinculacionProyectos = dto.getComunicacionDesvinculacionProyectos();
            this.comunicacionNoSerImportante = dto.getComunicacionNoSerImportante();
            this.comunicacionCargaFamiliar = dto.getComunicacionCargaFamiliar();
            this.comunicacionPensamientosAisladosMuerte = dto.getComunicacionPensamientosAisladosMuerte();
            this.comunicacionDeseoExplicitoSuicidio = dto.getComunicacionDeseoExplicitoSuicidio();
            this.referenciasMetodosSuicidio = dto.getReferenciasMetodosSuicidio();
            this.planConductaSuicida = dto.getPlanConductaSuicida();
            this.busquedaFormasSuicidio = dto.getBusquedaFormasSuicidio();
            
            // Señales indirectas
            this.existenciaIntentoPrevio = dto.getExistenciaIntentoPrevio();
            this.conductasRiesgoHacerDano = dto.getConductasRiesgoHacerDano();
            this.cambiosComportamientoCaracter = dto.getCambiosComportamientoCaracter();
            this.comportamientosAngustiaIrritacion = dto.getComportamientosAngustiaIrritacion();
            this.senalesAbatimientoActividades = dto.getSenalesAbatimientoActividades();
            this.absentismoEscolar = dto.getAbsentismoEscolar();
            this.alteracionesRitmosPatrones = dto.getAlteracionesRitmosPatrones();
            this.conductasRelacionalesTemasPendientes = dto.getConductasRelacionalesTemasPendientes();
            this.inicioConsumoSustancias = dto.getInicioConsumoSustancias();
        }
    }
}
