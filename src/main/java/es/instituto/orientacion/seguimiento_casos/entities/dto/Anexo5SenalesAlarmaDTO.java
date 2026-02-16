package es.instituto.orientacion.seguimiento_casos.entities.dto;

import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5SenalesAlarma;
import lombok.Data;

/**
 * DTO (Data Transfer Object) para las Señales de Alarma del Anexo 5.
 * <p>
 * Este objeto de transferencia de datos representa las señales de alarma identificadas
 * en el alumno durante el análisis del caso. Las señales de alarma son indicadores
 * comportamentales, emocionales y comunicacionales que alertan sobre la presencia
 * de malestar psicológico significativo y posible riesgo de conductas autolesivas
 * o suicidas.
 * </p>
 * <p>
 * Las señales se clasifican en dos categorías principales:
 * </p>
 * <ul>
 *   <li><strong>Señales Directas:</strong> Comunicaciones explícitas o muy claras sobre
 *       pensamientos, planes o intenciones relacionadas con el suicidio o autolesión</li>
 *   <li><strong>Señales Indirectas:</strong> Cambios comportamentales, conductas de riesgo
 *       y manifestaciones indirectas que sugieren malestar o crisis emocional</li>
 * </ul>
 * <p>
 * Cada señal se representa como un campo booleano que indica su presencia o ausencia,
 * permitiendo una evaluación estructurada de los indicadores de alerta que requieren
 * intervención inmediata o seguimiento prioritario.
 * </p>
 * <p>
 * <strong>IMPORTANTE:</strong> La detección de señales directas, especialmente aquellas
 * relacionadas con planes o deseos explícitos de suicidio, requiere actuación inmediata
 * siguiendo el protocolo de intervención en crisis del centro educativo.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see Anexo5SenalesAlarma
 * @see Anexo5DTO
 */
@Data
public class Anexo5SenalesAlarmaDTO {

    /**
     * Identificador único del registro de señales de alarma.
     */
    private Long id;

    // ==================== SEÑALES DIRECTAS ====================

    /**
     * Comunicación de bloqueo emocional o dolor insoportable.
     * <p>
     * Indica si el alumno expresa verbalmente que experimenta un dolor emocional
     * insoportable, que siente que no puede más o que está bloqueado sin salida.
     * </p>
     * <strong>Nivel de alerta: ALTO</strong>
     */
    private Boolean comunicacionBloqueoDolor;

    /**
     * Comunicación de desesperanza.
     * <p>
     * Indica si el alumno manifiesta sentimientos de desesperanza, expresando
     * que no hay solución, que nada va a mejorar o que no tiene futuro.
     * </p>
     * <strong>Nivel de alerta: ALTO</strong>
     */
    private Boolean comunicacionDesesperanza;

    /**
     * Comunicación de desvinculación de proyectos vitales.
     * <p>
     * Indica si el alumno expresa pérdida de interés en sus metas, proyectos
     * o actividades que antes eran importantes para él, mostrando desapego
     * hacia su futuro.
     * </p>
     * <strong>Nivel de alerta: MEDIO-ALTO</strong>
     */
    private Boolean comunicacionDesvinculacionProyectos;

    /**
     * Comunicación de no ser importante para nadie.
     * <p>
     * Indica si el alumno verbaliza sentimientos de que no importa a nadie,
     * que es invisible o que su ausencia no tendría consecuencias para otros.
     * </p>
     * <strong>Nivel de alerta: ALTO</strong>
     */
    private Boolean comunicacionNoSerImportante;

    /**
     * Comunicación de ser una carga para la familia.
     * <p>
     * Indica si el alumno expresa que es una carga para su familia o entorno,
     * que los demás estarían mejor sin él o que solo causa problemas.
     * </p>
     * <strong>Nivel de alerta: ALTO</strong>
     */
    private Boolean comunicacionCargaFamiliar;

    /**
     * Comunicación de pensamientos aislados sobre la muerte.
     * <p>
     * Indica si el alumno hace referencias ocasionales a la muerte, expresa
     * pensamientos sobre morir sin llegar a manifestar deseos concretos de suicidio.
     * </p>
     * <strong>Nivel de alerta: MEDIO</strong>
     */
    private Boolean comunicacionPensamientosAisladosMuerte;

    /**
     * Comunicación de deseo explícito de suicidio.
     * <p>
     * Indica si el alumno manifiesta de forma clara y directa su deseo de quitarse
     * la vida, de no querer seguir viviendo o de querer morir.
     * </p>
     * <strong>Nivel de alerta: CRÍTICO - Requiere intervención inmediata</strong>
     */
    private Boolean comunicacionDeseoExplicitoSuicidio;

    /**
     * Referencias a métodos de suicidio.
     * <p>
     * Indica si el alumno hace referencias, preguntas o muestra interés específico
     * en métodos o formas de quitarse la vida.
     * </p>
     * <strong>Nivel de alerta: CRÍTICO</strong>
     */
    private Boolean referenciasMetodosSuicidio;

    /**
     * Plan o conducta suicida estructurada.
     * <p>
     * Indica si el alumno ha elaborado un plan concreto de suicidio, con método,
     * momento y lugar específicos, o ha dado pasos preparatorios.
     * </p>
     * <strong>Nivel de alerta: CRÍTICO - Requiere intervención inmediata y derivación urgente</strong>
     */
    private Boolean planConductaSuicida;

    /**
     * Búsqueda activa de formas de suicidio.
     * <p>
     * Indica si el alumno busca información sobre métodos de suicidio en internet,
     * libros u otras fuentes, o si ha intentado acceder a medios letales.
     * </p>
     * <strong>Nivel de alerta: CRÍTICO</strong>
     */
    private Boolean busquedaFormasSuicidio;

    // ==================== SEÑALES INDIRECTAS ====================

    /**
     * Existencia de intento de suicidio previo.
     * <p>
     * Indica si el alumno ha realizado previamente uno o más intentos de suicidio.
     * Este es uno de los predictores más fuertes de riesgo futuro.
     * </p>
     * <strong>Nivel de alerta: MUY ALTO</strong>
     */
    private Boolean existenciaIntentoPrevio;

    /**
     * Conductas de riesgo para hacerse daño.
     * <p>
     * Indica si el alumno se involucra en conductas peligrosas o temerarias
     * sin aparente preocupación por su seguridad (autolesiones, retos peligrosos,
     * conducción temeraria, etc.).
     * </p>
     * <strong>Nivel de alerta: ALTO</strong>
     */
    private Boolean conductasRiesgoHacerDano;

    /**
     * Cambios bruscos en comportamiento o carácter.
     * <p>
     * Indica si el alumno ha experimentado cambios significativos y repentinos
     * en su personalidad, actitudes o forma de relacionarse que preocupan
     * a quienes le conocen.
     * </p>
     * <strong>Nivel de alerta: MEDIO</strong>
     */
    private Boolean cambiosComportamientoCaracter;

    /**
     * Comportamientos de angustia, ansiedad o irritación extrema.
     * <p>
     * Indica si el alumno muestra niveles elevados de angustia, ansiedad incontrolable,
     * irritabilidad excesiva o agitación emocional persistente.
     * </p>
     * <strong>Nivel de alerta: MEDIO-ALTO</strong>
     */
    private Boolean comportamientosAngustiaIrritacion;

    /**
     * Señales de abatimiento y abandono de actividades.
     * <p>
     * Indica si el alumno muestra apatía marcada, desinterés generalizado,
     * abandono de actividades que antes disfrutaba y falta de motivación.
     * </p>
     * <strong>Nivel de alerta: MEDIO</strong>
     */
    private Boolean senalesAbatimientoActividades;

    /**
     * Absentismo escolar o evitación del centro educativo.
     * <p>
     * Indica si el alumno falta frecuentemente a clase, llega tarde de forma
     * habitual o evita participar en actividades escolares sin justificación clara.
     * </p>
     * <strong>Nivel de alerta: MEDIO</strong>
     */
    private Boolean absentismoEscolar;

    /**
     * Alteraciones en ritmos y patrones habituales.
     * <p>
     * Indica si el alumno presenta cambios significativos en patrones de sueño,
     * alimentación, higiene personal u otras rutinas básicas.
     * </p>
     * <strong>Nivel de alerta: MEDIO</strong>
     */
    private Boolean alteracionesRitmosPatrones;

    /**
     * Conductas relacionales de despedida o cierre de temas pendientes.
     * <p>
     * Indica si el alumno se despide de personas importantes, regala posesiones
     * valiosas, resuelve asuntos pendientes o se comporta como si fuera a marcharse
     * definitivamente.
     * </p>
     * <strong>Nivel de alerta: MUY ALTO - Señal de alarma crítica</strong>
     */
    private Boolean conductasRelacionalesTemasPendientes;

    /**
     * Inicio o incremento en el consumo de sustancias.
     * <p>
     * Indica si el alumno ha comenzado recientemente a consumir alcohol, drogas
     * u otras sustancias, o si ha aumentado significativamente un consumo previo.
     * </p>
     * <strong>Nivel de alerta: MEDIO-ALTO</strong>
     */
    private Boolean inicioConsumoSustancias;

    /**
     * Constructor por defecto.
     * <p>
     * Crea una instancia vacía del DTO con todos los campos booleanos sin inicializar,
     * utilizado principalmente en formularios nuevos donde no se han detectado señales.
     * </p>
     */
    public Anexo5SenalesAlarmaDTO() {
    }

    /**
     * Constructor que crea un DTO a partir de una entidad Anexo5SenalesAlarma.
     * <p>
     * Este constructor facilita la conversión de la entidad JPA a un objeto
     * de transferencia de datos para su uso en la capa de presentación.
     * Realiza una copia de todas las señales de alarma identificadas,
     * organizadas en sus dos categorías: directas e indirectas.
     * </p>
     * <p>
     * Las señales directas requieren especial atención y posible actuación inmediata,
     * mientras que las señales indirectas pueden indicar la necesidad de seguimiento
     * cercano y evaluación más profunda.
     * </p>
     *
     * @param entity entidad Anexo5SenalesAlarma de la que se copiarán los datos.
     *               Si es null, los campos del DTO permanecerán sin inicializar.
     */
    public Anexo5SenalesAlarmaDTO(Anexo5SenalesAlarma entity) {
        if (entity != null) {
            this.id = entity.getId();

            // Copiar señales directas
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

            // Copiar señales indirectas
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