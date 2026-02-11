package es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo;

import es.instituto.orientacion.seguimiento_casos.entities.dto.Anexo5FactoresProteccionDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "anexo5_factores_proteccion")
public class    Anexo5FactoresProteccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FACTORES DE PROTECCIÓN - PERSONALES
    @Column(name = "habilidades_gestion_emocional")
    private Boolean habilidadesGestionEmocional;

    @Column(name = "habilidades_comunicacion_relacion")
    private Boolean habilidadesComunicacionRelacion;

    @Column(name = "autoconcepto_autoestima_saludables")
    private Boolean autoconceptoAutoestimaSaludables;

    @Column(name = "actitudes_relacion_interpersonal")
    private Boolean actitudesRelacionInterpersonal;

    @Column(name = "habitos_personales_saludables")
    private Boolean habitosPersonalesSaludables;

    @Column(name = "uso_adecuado_tic")
    private Boolean usoAdecuadoTic;

    @Column(name = "caracteristicas_personales_tranquilidad")
    private Boolean caracteristicasPersonalesTranquilidad;

    @Column(name = "rendimiento_escolar_adecuado")
    private Boolean rendimientoEscolarAdecuado;

    @Column(name = "sentimiento_positivo_pertenencia")
    private Boolean sentimientoPositivoPertenencia;

    @Column(name = "vinculacion_proyectos_personales")
    private Boolean vinculacionProyectosPersonales;

    @Column(name = "relaciones_familiares_adecuadas")
    private Boolean relacionesFamiliaresAdecuadas;

    @Column(name = "vinculos_apoyo_estables")
    private Boolean vinculosApoyoEstables;

    @Column(name = "estilos_educativos_modulados")
    private Boolean estilosEducativosModulados;

    // FACTORES DE PROTECCIÓN - FAMILIARES
    @Column(name = "equilibrio_actividades_relacionadas")
    private Boolean equilibrioActividadesRelacionadas;

    // FACTORES DE PROTECCIÓN - SOCIALES Y EDUCATIVOS
    @Column(name = "existencia_red_apoyo_social")
    private Boolean existenciaRedApoyoSocial;

    @Column(name = "buenas_relaciones_adultas")
    private Boolean buenasRelacionesAdultas;

    @Column(name = "contar_referencia_confianza")
    private Boolean contarReferenciaConfianza;

    @Column(name = "amigo_social_cultural")
    private Boolean amigoSocialCultural;

    @Column(name = "existencia_proyecto_social_educativo")
    private Boolean existenciaProyectoSocialEducativo;

    @OneToOne
    @JoinColumn(name = "anexo5_id")
    private Anexo5 anexo5;

    public Anexo5FactoresProteccion() {
    }

    public Anexo5FactoresProteccion(Anexo5FactoresProteccionDTO dto) {
        if (dto != null) {
            // Personales
            this.habilidadesGestionEmocional = dto.getHabilidadesGestionEmocional();
            this.habilidadesComunicacionRelacion = dto.getHabilidadesComunicacionRelacion();
            this.autoconceptoAutoestimaSaludables = dto.getAutoconceptoAutoestimaSaludables();
            this.actitudesRelacionInterpersonal = dto.getActitudesRelacionInterpersonal();
            this.habitosPersonalesSaludables = dto.getHabitosPersonalesSaludables();
            this.usoAdecuadoTic = dto.getUsoAdecuadoTic();
            this.caracteristicasPersonalesTranquilidad = dto.getCaracteristicasPersonalesTranquilidad();
            this.rendimientoEscolarAdecuado = dto.getRendimientoEscolarAdecuado();
            this.sentimientoPositivoPertenencia = dto.getSentimientoPositivoPertenencia();
            this.vinculacionProyectosPersonales = dto.getVinculacionProyectosPersonales();
            this.relacionesFamiliaresAdecuadas = dto.getRelacionesFamiliaresAdecuadas();
            this.vinculosApoyoEstables = dto.getVinculosApoyoEstables();
            this.estilosEducativosModulados = dto.getEstilosEducativosModulados();
            
            // Familiares
            this.equilibrioActividadesRelacionadas = dto.getEquilibrioActividadesRelacionadas();
            
            // Sociales y educativos
            this.existenciaRedApoyoSocial = dto.getExistenciaRedApoyoSocial();
            this.buenasRelacionesAdultas = dto.getBuenasRelacionesAdultas();
            this.contarReferenciaConfianza = dto.getContarReferenciaConfianza();
            this.amigoSocialCultural = dto.getAmigoSocialCultural();
            this.existenciaProyectoSocialEducativo = dto.getExistenciaProyectoSocialEducativo();
        }
    }
    public void actualizarDesdeDTO(Anexo5FactoresProteccionDTO dto) {
        // Personales
        this.habilidadesGestionEmocional = dto.getHabilidadesGestionEmocional();
        this.habilidadesComunicacionRelacion = dto.getHabilidadesComunicacionRelacion();
        this.autoconceptoAutoestimaSaludables = dto.getAutoconceptoAutoestimaSaludables();
        this.actitudesRelacionInterpersonal = dto.getActitudesRelacionInterpersonal();
        this.habitosPersonalesSaludables = dto.getHabitosPersonalesSaludables();
        this.usoAdecuadoTic = dto.getUsoAdecuadoTic();
        this.caracteristicasPersonalesTranquilidad = dto.getCaracteristicasPersonalesTranquilidad();
        this.rendimientoEscolarAdecuado = dto.getRendimientoEscolarAdecuado();
        this.sentimientoPositivoPertenencia = dto.getSentimientoPositivoPertenencia();
        this.vinculacionProyectosPersonales = dto.getVinculacionProyectosPersonales();
        this.relacionesFamiliaresAdecuadas = dto.getRelacionesFamiliaresAdecuadas();
        this.vinculosApoyoEstables = dto.getVinculosApoyoEstables();
        this.estilosEducativosModulados = dto.getEstilosEducativosModulados();

        // Familiares
        this.equilibrioActividadesRelacionadas = dto.getEquilibrioActividadesRelacionadas();

        // Sociales y educativos
        this.existenciaRedApoyoSocial = dto.getExistenciaRedApoyoSocial();
        this.buenasRelacionesAdultas = dto.getBuenasRelacionesAdultas();
        this.contarReferenciaConfianza = dto.getContarReferenciaConfianza();
        this.amigoSocialCultural = dto.getAmigoSocialCultural();
        this.existenciaProyectoSocialEducativo = dto.getExistenciaProyectoSocialEducativo();
    }
}
