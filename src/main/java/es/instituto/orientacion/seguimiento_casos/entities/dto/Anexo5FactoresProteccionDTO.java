package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5FactoresProteccion;
import lombok.Data;

@Data
public class Anexo5FactoresProteccionDTO {

    private Long id;

    // FACTORES DE PROTECCIÓN - PERSONALES
    private Boolean habilidadesGestionEmocional;
    private Boolean habilidadesComunicacionRelacion;
    private Boolean autoconceptoAutoestimaSaludables;
    private Boolean actitudesRelacionInterpersonal;
    private Boolean habitosPersonalesSaludables;
    private Boolean usoAdecuadoTic;
    private Boolean caracteristicasPersonalesTranquilidad;
    private Boolean rendimientoEscolarAdecuado;
    private Boolean sentimientoPositivoPertenencia;
    private Boolean vinculacionProyectosPersonales;
    private Boolean relacionesFamiliaresAdecuadas;
    private Boolean vinculosApoyoEstables;
    private Boolean estilosEducativosModulados;

    // FACTORES DE PROTECCIÓN - FAMILIARES
    private Boolean equilibrioActividadesRelacionadas;

    // FACTORES DE PROTECCIÓN - SOCIALES Y EDUCATIVOS
    private Boolean existenciaRedApoyoSocial;
    private Boolean buenasRelacionesAdultas;
    private Boolean contarReferenciaConfianza;
    private Boolean amigoSocialCultural;
    private Boolean existenciaProyectoSocialEducativo;

    public Anexo5FactoresProteccionDTO() {
    }

    public Anexo5FactoresProteccionDTO(Anexo5FactoresProteccion entity) {
        if (entity != null) {
            this.id = entity.getId();
            
            // Personales
            this.habilidadesGestionEmocional = entity.getHabilidadesGestionEmocional();
            this.habilidadesComunicacionRelacion = entity.getHabilidadesComunicacionRelacion();
            this.autoconceptoAutoestimaSaludables = entity.getAutoconceptoAutoestimaSaludables();
            this.actitudesRelacionInterpersonal = entity.getActitudesRelacionInterpersonal();
            this.habitosPersonalesSaludables = entity.getHabitosPersonalesSaludables();
            this.usoAdecuadoTic = entity.getUsoAdecuadoTic();
            this.caracteristicasPersonalesTranquilidad = entity.getCaracteristicasPersonalesTranquilidad();
            this.rendimientoEscolarAdecuado = entity.getRendimientoEscolarAdecuado();
            this.sentimientoPositivoPertenencia = entity.getSentimientoPositivoPertenencia();
            this.vinculacionProyectosPersonales = entity.getVinculacionProyectosPersonales();
            this.relacionesFamiliaresAdecuadas = entity.getRelacionesFamiliaresAdecuadas();
            this.vinculosApoyoEstables = entity.getVinculosApoyoEstables();
            this.estilosEducativosModulados = entity.getEstilosEducativosModulados();
            
            // Familiares
            this.equilibrioActividadesRelacionadas = entity.getEquilibrioActividadesRelacionadas();
            
            // Sociales y educativos
            this.existenciaRedApoyoSocial = entity.getExistenciaRedApoyoSocial();
            this.buenasRelacionesAdultas = entity.getBuenasRelacionesAdultas();
            this.contarReferenciaConfianza = entity.getContarReferenciaConfianza();
            this.amigoSocialCultural = entity.getAmigoSocialCultural();
            this.existenciaProyectoSocialEducativo = entity.getExistenciaProyectoSocialEducativo();
        }
    }
}
