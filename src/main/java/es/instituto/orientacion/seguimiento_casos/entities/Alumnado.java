package es.instituto.orientacion.seguimiento_casos.entities;

import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.Paso7;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Entidad principal que representa un caso de seguimiento de alumnado.
 * <p>
 * Esta clase es la entidad raíz del protocolo de seguimiento de casos. Mantiene
 * las relaciones con los 11 pasos del protocolo mediante asociaciones uno-a-uno
 * bidireccionales. Cada paso se gestiona con cascada completa y eliminación de huérfanos
 * para garantizar la integridad referencial.
 * </p>
 * <p>
 * La entidad incluye auditoría automática mediante marcas de tiempo de creación
 * y última actualización gestionadas por Hibernate.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 */
@Entity
@Table(name = "alumnado")
@Getter
@Setter
public class Alumnado {

    /**
     * Identificador único generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Identificador del caso (puede ser usado para referencias externas).
     */
    @Column(name = "idCaso")
    private String idCaso;

    /**
     * Identificador del documento asociado al caso.
     */
    @Column(name = "idDocumento")
    private Integer idDocumento;

    /**
     * Código único del alumno en el sistema educativo.
     */
    @Column(name = "codigo_alumno")
    private String codigoAlumno;

    /**
     * Paso 1: Detección y registro inicial del caso.
     * <p>
     * Incluye información sobre cómo se detectó el caso, indicadores de riesgo,
     * detalle de los hechos y registro inicial.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso1 paso1;

    /**
     * Paso 2: Cronograma de actuaciones.
     * <p>
     * Contiene la planificación temporal de las actuaciones a realizar,
     * incluyendo una colección de entradas de cronograma.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso2 paso2;

    /**
     * Paso 3: Medidas provisionales.
     * <p>
     * Registra las medidas de protección y seguridad adoptadas de forma inmediata.
     * </p>
     */
    @OneToOne(mappedBy  = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso3 paso3;

    /**
     * Paso 4: Acta de reunión con la familia.
     * <p>
     * Documenta las reuniones mantenidas con las familias, acuerdos y asistentes.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso4 paso4;

    /**
     * Paso 5: Valoración y análisis del caso.
     * <p>
     * Contiene la valoración completa del caso, incluyendo el Anexo 4 (Síntesis)
     * y el Anexo 5 (Análisis con indicadores).
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso5 paso5;

    /**
     * Paso 6: Resolución del caso.
     * <p>
     * Documenta la decisión adoptada sobre el caso y los agentes implicados
     * en su seguimiento.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso6 paso6;

    /**
     * Paso 7: Plan individualizado de intervención.
     * <p>
     * Contiene el plan completo de actuación con objetivos, medidas preventivas,
     * actuaciones del equipo docente y calendario de seguimiento.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso7 paso7;

    /**
     * Paso 8: Seguimiento de medidas.
     * <p>
     * Registra el seguimiento de las medidas implementadas y otras actuaciones
     * complementarias.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso8 paso8;

    /**
     * Paso 9: Información a dirección.
     * <p>
     * Documenta la comunicación del caso a la dirección del centro educativo.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso9 paso9;

    /**
     * Paso 10: Seguimiento por inspección.
     * <p>
     * Registra las actuaciones y seguimiento realizados por el servicio
     * de inspección educativa.
     * </p>
     */
    @OneToOne(mappedBy = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso10 paso10;

    /**
     * Paso 11: Cierre del caso y seguimiento institucional.
     * <p>
     * Documenta el cierre formal del caso y los seguimientos posteriores
     * por parte de inspección, familia y profesorado.
     * </p>
     */
    @OneToOne(mappedBy  = "alumnado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Paso11 paso11;

    /**
     * Observaciones generales sobre el caso.
     * <p>
     * Campo de texto libre para anotaciones adicionales que no encajan
     * en los pasos estructurados del protocolo.
     * </p>
     */
    @Column(name = "observaciones")
    private String observaciones;

    /**
     * Fecha y hora de creación del registro.
     * <p>
     * Se establece automáticamente por Hibernate al crear la entidad.
     * Este campo no se puede actualizar posteriormente.
     * </p>
     */
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha y hora de la última actualización del registro.
     * <p>
     * Se actualiza automáticamente por Hibernate cada vez que se modifica la entidad.
     * </p>
     */
    @UpdateTimestamp
    private LocalDateTime fechaUltimaActualizacion;

    @Version
    private Long version;
    /**
     * Constructor que crea una entidad Alumnado a partir de un FormularioDTO.
     * <p>
     * Este constructor es utilizado cuando se crea un nuevo caso de seguimiento
     * desde el formulario de la aplicación. Inicializa todos los campos básicos
     * y crea las instancias de los pasos del protocolo que vengan informados en el DTO,
     * estableciendo las relaciones bidireccionales correspondientes.
     * </p>
     *
     * @param formularioDTO objeto de transferencia de datos con la información completa del formulario
     */
    public Alumnado(FormularioDTO formularioDTO) {
        this.id = formularioDTO.getId();
        this.idCaso = formularioDTO.getIdCaso();
        this.idDocumento = formularioDTO.getIdDocumento();
        this.codigoAlumno = formularioDTO.getCodigoAlumno();

        // Inicializar Paso 1 si existe en el DTO
        if (formularioDTO.getPaso1DTO() != null) {
            Paso1 paso1 = new Paso1(formularioDTO.getPaso1DTO());
            paso1.setAlumnado(this);
            this.paso1 = paso1;
        }

        // Inicializar Paso 2 si existe en el DTO
        if (formularioDTO.getPaso2DTO() != null) {
            Paso2 paso2 = new Paso2(formularioDTO.getPaso2DTO());
            paso2.setAlumnado(this);
            this.paso2 = paso2;
        }

        // Inicializar Paso 3 si existe en el DTO
        if (formularioDTO.getPaso3DTO() != null) {
            Paso3 paso3 = new Paso3(formularioDTO.getPaso3DTO());
            paso3.setAlumnado(this);
            this.paso3 = paso3;
        }

        // Inicializar Paso 4 si existe en el DTO
        if (formularioDTO.getPaso4DTO() != null) {
            Paso4 paso4 = new Paso4(formularioDTO.getPaso4DTO());
            paso4.setAlumnado(this);
            this.paso4 = paso4;
        }

        // Inicializar Paso 5 si existe en el DTO
        if (formularioDTO.getPaso5DTO() != null) {
            Paso5 paso5 = new Paso5(formularioDTO.getPaso5DTO());
            paso5.setAlumnado(this);
            this.paso5 = paso5;
        }

        // Inicializar Paso 6 si existe en el DTO
        if (formularioDTO.getPaso6DTO() != null) {
            Paso6 paso6 = new Paso6(formularioDTO.getPaso6DTO());
            paso6.setAlumnado(this);
            this.paso6 = paso6;
        }

        // Inicializar Paso 7 si existe en el DTO
        if (formularioDTO.getPaso7DTO() != null) {
            Paso7 paso7 = new Paso7(formularioDTO.getPaso7DTO());
            paso7.setAlumnado(this);
            this.paso7 = paso7;
        }

        // Inicializar Paso 8 si existe en el DTO
        if (formularioDTO.getPaso8DTO() != null) {
            Paso8 paso8 = new Paso8(formularioDTO.getPaso8DTO());
            paso8.setAlumnado(this);
            this.paso8 = paso8;
        }

        // Inicializar Paso 9 si existe en el DTO
        if (formularioDTO.getPaso9DTO() != null) {
            Paso9 paso9 = new Paso9(formularioDTO.getPaso9DTO());
            paso9.setAlumnado(this);
            this.paso9 = paso9;
        }

        // Inicializar Paso 10 si existe en el DTO
        if (formularioDTO.getPaso10DTO() != null) {
            Paso10 paso10 = new Paso10(formularioDTO.getPaso10DTO());
            paso10.setAlumnado(this);
            this.paso10 = paso10;
        }

        // Inicializar Paso 11 si existe en el DTO
        if (formularioDTO.getPaso11DTO() != null) {
            Paso11 paso11 = new Paso11(formularioDTO.getPaso11DTO());
            paso11.setAlumnado(this);
            this.paso11 = paso11;
        }
    }

    /**
     * Constructor por defecto requerido por JPA.
     * <p>
     * Este constructor vacío es necesario para que Hibernate pueda instanciar
     * la entidad al recuperar datos de la base de datos.
     * </p>
     */
    public Alumnado() {
    }
}