package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5SenalesAlarma;
import lombok.Data;

@Data
public class Anexo5SenalesAlarmaDTO {

    private Long id;

    // SEÑALES DIRECTAS
    private Boolean comunicacionBloqueoDolor;
    private Boolean comunicacionDesesperanza;
    private Boolean comunicacionDesvinculacionProyectos;
    private Boolean comunicacionNoSerImportante;
    private Boolean comunicacionCargaFamiliar;
    private Boolean comunicacionPensamientosAisladosMuerte;
    private Boolean comunicacionDeseoExplicitoSuicidio;
    private Boolean referenciasMetodosSuicidio;
    private Boolean planConductaSuicida;
    private Boolean busquedaFormasSuicidio;

    // SEÑALES INDIRECTAS
    private Boolean existenciaIntentoPrevio;
    private Boolean conductasRiesgoHacerDano;
    private Boolean cambiosComportamientoCaracter;
    private Boolean comportamientosAngustiaIrritacion;
    private Boolean senalesAbatimientoActividades;
    private Boolean absentismoEscolar;
    private Boolean alteracionesRitmosPatrones;
    private Boolean conductasRelacionalesTemasPendientes;
    private Boolean inicioConsumoSustancias;

    public Anexo5SenalesAlarmaDTO() {
    }

    public Anexo5SenalesAlarmaDTO(Anexo5SenalesAlarma entity) {
        if (entity != null) {
            this.id = entity.getId();
            
            // Señales directas
            this.comunicacionBloqueoDolor = entity.getComunicacionBloqueoDolor();
            this.comunicacionDesesperanza = entity.getComunicacionDesesperanza();
            this.comunicacionDesvinculacionProyectos = entity.getComunicacionDesvinculacionProyectos();
            this.comunicacionNoSerImportante = entity.getComunicacionNoSerImportante();
            this.comunicacionCargaFamiliar = entity.getComunicacionCargaFamiliar();
            this.comunicacionPensamientosAisladosMuerte = entity.getComunicacionPensamientosAisladosMuerte();
            this.comunicacionDeseoExplicitoSuicidio = entity.getComunicacionDeseoExplicitoSuicidio();
            this.referenciasMetodosSuicidio = entity.getReferenciasMetodosSuicidio();
            this.planConductaSuicida = entity.getPlanConductaSuicida();
            this.busquedaFormasSuicidio = entity.getBusquedaFormasSuicidio();
            
            // Señales indirectas
            this.existenciaIntentoPrevio = entity.getExistenciaIntentoPrevio();
            this.conductasRiesgoHacerDano = entity.getConductasRiesgoHacerDano();
            this.cambiosComportamientoCaracter = entity.getCambiosComportamientoCaracter();
            this.comportamientosAngustiaIrritacion = entity.getComportamientosAngustiaIrritacion();
            this.senalesAbatimientoActividades = entity.getSenalesAbatimientoActividades();
            this.absentismoEscolar = entity.getAbsentismoEscolar();
            this.alteracionesRitmosPatrones = entity.getAlteracionesRitmosPatrones();
            this.conductasRelacionalesTemasPendientes = entity.getConductasRelacionalesTemasPendientes();
            this.inicioConsumoSustancias = entity.getInicioConsumoSustancias();
        }
    }
}
