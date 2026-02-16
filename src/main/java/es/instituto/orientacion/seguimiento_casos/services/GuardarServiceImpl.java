package es.instituto.orientacion.seguimiento_casos.services;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.dto.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo4;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import es.instituto.orientacion.seguimiento_casos.repositories.*;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementación del servicio de guardado de información de alumnado.
 * <p>
 * Esta clase gestiona la persistencia de los datos del alumnado y todos los pasos
 * del protocolo de seguimiento de casos. Se encarga de crear nuevos registros de
 * alumnado y actualizar los existentes, coordinando la persistencia de las 11 fases
 * del protocolo junto con sus anexos asociados.
 * </p>
 * <p>
 * Utiliza el patrón de transferencia de datos (DTO) para recibir información desde
 * la capa de presentación y la convierte en entidades JPA para su persistencia.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 * @see GuardarService
 */
@Service
public class GuardarServiceImpl implements GuardarService {

    private final AlumnadoRepository alumnadoRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param alumnadoRepository repositorio para operaciones de persistencia de alumnado
     */
    public GuardarServiceImpl(AlumnadoRepository alumnadoRepository) {
        this.alumnadoRepository = alumnadoRepository;
    }

    /**
     * Crea un nuevo registro de alumno con toda la información del protocolo de seguimiento.
     * <p>
     * Este método procesa el formulario completo recibido y crea una nueva entidad de alumnado
     * junto con todos los pasos del protocolo que estén cumplimentados. Establece las relaciones
     * bidireccionales entre las entidades y asigna la fecha de registro actual al Paso 1.
     * </p>
     *
     * @param formularioDTO objeto de transferencia de datos con toda la información del formulario
     * @return true si el alumno se guardó correctamente (ID generado no nulo), false en caso contrario
     */
    @Override
    public boolean crearAlumnado(FormularioDTO formularioDTO) {
        // Crear entidad principal de alumnado
        Alumnado alumnado = new Alumnado(formularioDTO);
        alumnado.setObservaciones(formularioDTO.getObservaciones());
        alumnado.setCodigoAlumno(formularioDTO.getCodigoAlumno());

        // Configurar Paso 1 con fecha de registro
        if (alumnado.getPaso1() != null) {
            alumnado.getPaso1().setAlumnado(alumnado);
            alumnado.getPaso1().setFechaRegistro(LocalDate.now());
        }

        // Configurar Paso 2 y cronograma
        if (alumnado.getPaso2() != null) {
            alumnado.getPaso2().setAlumnado(alumnado);
        }
        guardarCronograma(formularioDTO, alumnado.getPaso2());

        guardarPaso3(formularioDTO, alumnado);

        guardarPaso4(formularioDTO, alumnado);

        // Configurar Paso 5 con sus anexos 4 y 5
        Paso5 paso5 = alumnado.getPaso5();
        if (paso5 == null) {
            paso5 = new Paso5();
            paso5.setAlumnado(alumnado);
            alumnado.setPaso5(paso5);
        }

        Paso5DTO dto5 = formularioDTO.getPaso5DTO();

        if (dto5.getAnexo4() != null) {
            Anexo4 anexo4 = new Anexo4(dto5.getAnexo4());
            anexo4.setPaso5(paso5);
            paso5.setAnexo4(anexo4);
        }

        if (dto5.getAnexo5() != null) {
            Anexo5 anexo5 = new Anexo5(dto5.getAnexo5());
            anexo5.setPaso5(paso5);
            paso5.setAnexo5(anexo5);
        }

        guardarPaso6(formularioDTO, alumnado);

        guardarPaso7(formularioDTO, alumnado);

        guardarPaso8(formularioDTO, alumnado);

        guardarPaso9(formularioDTO, alumnado);

        guardarPaso10(formularioDTO, alumnado);

        guardarPaso11(formularioDTO, alumnado);

        // Persistir en base de datos
        Long idNuevo = alumnadoRepository.save(alumnado).getId();
        return idNuevo != null;
    }

    /**
     * Actualiza un registro existente de alumno con la información modificada.
     * <p>
     * Este método recupera el alumno existente por su ID y actualiza todos los pasos
     * del protocolo con la nueva información proporcionada en el formulario. Preserva
     * los datos no modificados y actualiza solo los campos que vienen en el DTO.
     * </p>
     *
     * @param formularioDTO objeto de transferencia de datos con la información actualizada
     * @return true si la actualización fue exitosa
     * @throws java.util.NoSuchElementException si no se encuentra el alumno con el ID especificado
     */
    @Override
    public boolean editarAlumnado(FormularioDTO formularioDTO) {
        // Recuperar alumno existente
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(formularioDTO.getId()))
                .orElseThrow();
        alumnado.setObservaciones(formularioDTO.getObservaciones());
        alumnado.setCodigoAlumno(formularioDTO.getCodigoAlumno());

        // Actualizar todos los pasos del protocolo
        guardarPaso1(formularioDTO, alumnado);
        guardarPaso2(formularioDTO, alumnado);
        guardarPaso3(formularioDTO, alumnado);
        guardarPaso4(formularioDTO, alumnado);
        guardarPaso5(formularioDTO, alumnado);
        guardarPaso6(formularioDTO, alumnado);
        guardarPaso7(formularioDTO, alumnado);
        guardarPaso8(formularioDTO, alumnado);
        guardarPaso9(formularioDTO, alumnado);
        guardarPaso10(formularioDTO, alumnado);
        guardarPaso11(formularioDTO, alumnado);

        alumnadoRepository.save(alumnado);
        return true;
    }

    /**
     * Guarda o actualiza la información del Paso 11 (Cierre del caso y seguimiento institucional).
     * <p>
     * Este paso registra las fechas y observaciones del cierre del caso, así como
     * los seguimientos realizados por inspección, familia y profesorado.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso11(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso11 paso11 = alumnado.getPaso11();
        if (paso11 == null) {
            paso11 = new Paso11();
            paso11.setAlumnado(alumnado);
            alumnado.setPaso11(paso11);
        }
        Paso11DTO dto11 = formularioDTO.getPaso11DTO();
        paso11.setFecchacierre(dto11.getFecchacierre());
        paso11.setObservacionesFechaCierre(dto11.getObservacionesFechaCierre());
        paso11.setFechaInspeccion(dto11.getFechaInspeccion());
        paso11.setInspeccion(dto11.getInspeccion());
        paso11.setFecchafamilia(dto11.getFecchafamilia());
        paso11.setFamilia(dto11.getFamilia());
        paso11.setFechaProfesorado(dto11.getFechaProfesorado());
        paso11.setProfesorado(dto11.getProfesorado());
    }

    /**
     * Guarda o actualiza la información del Paso 9 (Información a dirección).
     * <p>
     * Este paso registra si la dirección del centro ha sido informada sobre el caso.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso9(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso9 paso9 = alumnado.getPaso9();
        if (paso9 == null) {
            paso9 = new Paso9();
            paso9.setAlumnado(alumnado);
            alumnado.setPaso9(paso9);
        }
        Paso9DTO dto9 = formularioDTO.getPaso9DTO();
        paso9.setDirectorinforma(dto9.getDirectorinforma());
    }

    /**
     * Guarda o actualiza la información del Paso 10 (Seguimiento por inspección).
     * <p>
     * Este paso documenta el seguimiento realizado por el servicio de inspección educativa.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso10(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso10 paso10 = alumnado.getPaso10();
        if (paso10 == null) {
            paso10 = new Paso10();
            paso10.setAlumnado(alumnado);
            alumnado.setPaso10(paso10);
        }
        Paso10DTO dto10 = formularioDTO.getPaso10DTO();
        paso10.setSeguiminetoInspeccion(dto10.getSeguiminetoInspeccion());
    }

    /**
     * Guarda o actualiza la información del Paso 8 (Seguimiento de medidas).
     * <p>
     * Este paso registra otras medidas adoptadas y los responsables de dirección
     * asignados al seguimiento del caso.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso8(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso8 paso8 = alumnado.getPaso8();
        if (paso8 == null) {
            paso8 = new Paso8();
            paso8.setAlumnado(alumnado);
            alumnado.setPaso8(paso8);
        }
        Paso8DTO dto8 = formularioDTO.getPaso8DTO();
        paso8.setOtrasMedidas(dto8.getOtrasMedidas());
        paso8.setResponsableDireccion(dto8.getResponsableDireccion());
    }

    /**
     * Guarda o actualiza la información del Paso 7 (Plan individualizado de intervención).
     * <p>
     * Este paso contiene el plan completo de intervención con objetivos, medidas preventivas,
     * acciones del equipo docente, calendario de seguimiento y toda la planificación
     * de actuaciones para el alumno.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso7(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso7 paso7 = alumnado.getPaso7();
        if (paso7 == null) {
            paso7 = new Paso7();
            paso7.setAlumnado(alumnado);
            alumnado.setPaso7(paso7);
        }

        Paso7DTO dto7 = formularioDTO.getPaso7DTO();

        // Datos básicos del plan
        paso7.setCodigoAlumno(dto7.getCodigoAlumno());
        paso7.setObjetivoGeneral(dto7.getObjetivoGeneral());
        paso7.setObjetivosEspecificos(dto7.getObjetivosEspecificos());
        paso7.setEquipoAcompanamiento(dto7.getEquipoAcompanamiento());
        paso7.setCalendarioSeguimiento(dto7.getCalendarioSeguimiento());

        // Configuración del repositorio y formato
        paso7.setTieneRepositorioAntecedentes(dto7.getTieneRepositorioAntecedentes());
        paso7.setTieneCronogramaFormalizado(dto7.getTieneCronogramaFormalizado());
        paso7.setEsFormatoDigital(dto7.getEsFormatoDigital());

        // Medidas adoptadas
        paso7.setMedidasPrevencionGeneral(dto7.getMedidasPrevencionGeneral());
        paso7.setMedidasProteccionSeguridad(dto7.getMedidasProteccionSeguridad());
        paso7.setMedidasAcompanamientoEmocional(dto7.getMedidasAcompanamientoEmocional());
        paso7.setOtrasMedidasAdoptadas(dto7.getOtrasMedidasAdoptadas());
        paso7.setInformacionEquipoDocente(dto7.getInformacionEquipoDocente());
        paso7.setPlanificacionObservacionAtencion(dto7.getPlanificacionObservacionAtencion());

        // Actuaciones específicas por agentes
        paso7.setAccionesTutor(dto7.getAccionesTutor());
        paso7.setIntervencionEquipoDocente(dto7.getIntervencionEquipoDocente());
        paso7.setIntervencionOrientacion(dto7.getIntervencionOrientacion());
        paso7.setIntervencionOtrosTrabajadores(dto7.getIntervencionOtrosTrabajadores());
        paso7.setAcompanamientoCompaneros(dto7.getAcompanamientoCompaneros());
        paso7.setActividadesSensibilizacionAula(dto7.getActividadesSensibilizacionAula());
        paso7.setFormacionProfesorado(dto7.getFormacionProfesorado());
        paso7.setActuacionesFamilia(dto7.getActuacionesFamilia());
        paso7.setActuacionesServiciosExternos(dto7.getActuacionesServiciosExternos());

        // Metadatos de elaboración
        paso7.setElaboradoPor(dto7.getElaboradoPor());
        paso7.setFechaElaboracion(dto7.getFechaElaboracion());
    }

    /**
     * Guarda o actualiza la información del Paso 6 (Resolución).
     * <p>
     * Este paso documenta la resolución tomada sobre el caso, indicando si se procede
     * a abrir expediente, quién está involucrado (alumno, comisión, inspección, tutores,
     * servicios externos, etc.), la motivación y fecha de la decisión.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso6(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso6 paso6 = alumnado.getPaso6();
        if (paso6 == null) {
            paso6 = new Paso6();
            paso6.setAlumnado(alumnado);
            alumnado.setPaso6(paso6);
        }
        Paso6DTO dto6 = formularioDTO.getPaso6DTO();
        paso6.setAbrir(dto6.getAbrir());
        paso6.setAlumno(dto6.getAlumno());
        paso6.setComision(dto6.getComision());
        paso6.setInspeccion(dto6.getInspeccion());
        paso6.setTutores(dto6.getTutores());
        paso6.setServicios(dto6.getServicios());
        paso6.setOtros(dto6.getOtros());
        paso6.setOtrosespecificados(dto6.getOtrosespecificados());
        paso6.setMotivacion(dto6.getMotivacion());
        paso6.setFecha(dto6.getFecha());
    }

    /**
     * Guarda o actualiza la información del Paso 5 (Valoración y análisis).
     * <p>
     * Este paso gestiona la valoración del caso y sus dos anexos asociados:
     * Anexo 4 (Síntesis de la valoración) y Anexo 5 (Análisis del caso con indicadores).
     * Si los anexos ya existen, se actualizan; si no, se crean nuevos.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso5(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso5 paso5 = alumnado.getPaso5();
        if (paso5 == null) {
            paso5 = new Paso5();
            paso5.setAlumnado(alumnado);
            alumnado.setPaso5(paso5);
        }

        Paso5DTO dto5 = formularioDTO.getPaso5DTO();

        // Lógica para Anexo 4 (Síntesis)
        if (dto5.getAnexo4() != null) {
            if (paso5.getAnexo4() == null) {
                // Si no existe, creamos uno nuevo
                Anexo4 nuevoAnexo4 = new Anexo4(dto5.getAnexo4());
                nuevoAnexo4.setPaso5(paso5);
                paso5.setAnexo4(nuevoAnexo4);
            } else {
                // Si ya existe, actualizamos la instancia que Hibernate ya conoce
                paso5.getAnexo4().actualizarDesdeDTO(dto5.getAnexo4());
            }
        }

        // Lógica para Anexo 5 (Análisis del caso)
        if (dto5.getAnexo5() != null) {
            if (paso5.getAnexo5() == null) {
                Anexo5 nuevoAnexo5 = new Anexo5(dto5.getAnexo5());
                nuevoAnexo5.setPaso5(paso5);
                paso5.setAnexo5(nuevoAnexo5);
            } else {
                paso5.getAnexo5().actualizarDesdeDTO(dto5.getAnexo5());
            }
        }
    }

    /**
     * Guarda o actualiza la información del Paso 4 (Acta de reunión con la familia).
     * <p>
     * Este paso registra los datos de las reuniones con las familias, incluyendo
     * contenido tratado, acuerdos alcanzados, asistentes y fecha.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso4(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso4 paso4 = alumnado.getPaso4();
        if (paso4 == null) {
            paso4 = new Paso4();
            paso4.setAlumnado(alumnado);
            alumnado.setPaso4(paso4);
        }
        Paso4DTO dto4 = formularioDTO.getPaso4DTO();
        paso4.setContenido(dto4.getContenido());
        paso4.setAcuerdos(dto4.getAcuerdos());
        paso4.setAsistentes(dto4.getAsistentes());
        paso4.setFecha(dto4.getFecha());
    }

    /**
     * Guarda o actualiza la información del Paso 3 (Medidas provisionales).
     * <p>
     * Este paso documenta las medidas provisionales adoptadas de forma inmediata
     * para garantizar la seguridad y bienestar del alumno.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private static void guardarPaso3(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso3 paso3 = alumnado.getPaso3();
        if (paso3 == null) {
            paso3 = new Paso3();
            paso3.setAlumnado(alumnado);
            alumnado.setPaso3(paso3);
        }
        Paso3DTO dto3 = formularioDTO.getPaso3DTO();
        paso3.setMedidasProvisionales(dto3.getMedidasProvisionales());
    }

    /**
     * Guarda o actualiza la información del Paso 2 (Cronograma de actuaciones).
     * <p>
     * Este paso registra diversos aspectos del proceso de seguimiento y gestiona
     * el cronograma de actuaciones planificadas.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private void guardarPaso2(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso2 paso2 = alumnado.getPaso2();
        if (paso2 == null) {
            paso2 = new Paso2();
            paso2.setAlumnado(alumnado);
            alumnado.setPaso2(paso2);
        }
        Paso2DTO dto2 = formularioDTO.getPaso2DTO();
        paso2.setPaso2_1(dto2.getPaso2_1());
        paso2.setPaso2_2(dto2.getPaso2_2());
        paso2.setPaso2_3(dto2.getPaso2_3());
        paso2.setPaso2_4(dto2.getPaso2_4());
        paso2.setPaso2_5(dto2.getPaso2_5());
        paso2.setPaso2_7(dto2.getPaso2_7());

        guardarCronograma(formularioDTO, paso2);
    }

    /**
     * Guarda o actualiza la información del Paso 1 (Detección y registro inicial).
     * <p>
     * Este paso registra cómo se detectó el caso (comunicación del alumno, compañeros o familia),
     * indicadores de riesgo (intentos previos, conductas autolesivas), detalle de los hechos
     * y firmas de responsables.
     * </p>
     *
     * @param formularioDTO DTO con la información del formulario completo
     * @param alumnado entidad de alumno a la que se asocia este paso
     */
    private void guardarPaso1(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso1 paso1 = alumnado.getPaso1();
        if (paso1 == null) {
            paso1 = new Paso1();
            paso1.setAlumnado(alumnado);
            alumnado.setPaso1(paso1);
        }
        Paso1DTO dto = formularioDTO.getPaso1DTO();
        paso1.setAlumnoComunica(dto.getAlumnoComunica());
        paso1.setCompanerosComunican(dto.getCompanerosComunican());
        paso1.setFamiliaComunica(dto.getFamiliaComunica());
        paso1.setIntentoPrevio(dto.getIntentoPrevio());
        paso1.setConductaAutolesiva(dto.getConductaAutolesiva());
        paso1.setOtrosDetalle(dto.getOtrosDetalle());
        paso1.setDetalleHechos(dto.getDetalleHechos());
        paso1.setFechaRegistro(dto.getFechaRegistro());
        paso1.setFirmas(dto.getFirmas());
    }

    /**
     * Guarda el cronograma de actuaciones asociado al Paso 2.
     * <p>
     * Este método gestiona la colección de entradas del cronograma, donde cada entrada
     * representa una actuación planificada con su fecha, situación, actuación realizada,
     * documentos asociados y observaciones. Limpia las entradas existentes y crea nuevas
     * instancias para garantizar la correcta sincronización con Hibernate.
     * </p>
     *
     * @param formularioDTO DTO con la información completa del formulario
     * @param paso2 entidad del Paso 2 a la que se asociará el cronograma
     */
    private void guardarCronograma(FormularioDTO formularioDTO, Paso2 paso2) {
        System.out.println("=== Guardando cronograma ===");
        System.out.println("Paso2DTO completo: " + formularioDTO.getPaso2DTO());
        System.out.println("Cronograma DTO: " + formularioDTO.getPaso2DTO().getCronogramaDTO());

        // Validar que existan datos de cronograma
        if (formularioDTO.getPaso2DTO() == null ||
                formularioDTO.getPaso2DTO().getCronogramaDTO() == null) {
            System.out.println("No hay cronograma para guardar");
            return;
        }

        // Inicializar la colección si es null
        if (paso2.getCronograma() == null) {
            paso2.setCronograma(new ArrayList<>());
        }

        System.out.println("Cantidad de items recibidos: " + formularioDTO.getPaso2DTO().getCronogramaDTO().size());

        // Limpiar elementos existentes para evitar duplicados
        paso2.getCronograma().clear();

        // Crear nuevos objetos Cronograma desde el DTO
        formularioDTO.getPaso2DTO().getCronogramaDTO().forEach(cronogramaDTO -> {
            System.out.println("Procesando item:");
            System.out.println("  - Fecha: " + cronogramaDTO.getFecha());
            System.out.println("  - Situacion: " + cronogramaDTO.getSituacion());
            System.out.println("  - Actuacion: " + cronogramaDTO.getActuacion());

            // Crear una nueva instancia de Cronograma
            Cronograma nuevoCronograma = getCronograma(paso2, cronogramaDTO);

            // Añadir a la colección
            paso2.getCronograma().add(nuevoCronograma);
        });

        System.out.println("Total items añadidos a paso2: " + paso2.getCronograma().size());
    }

    /**
     * Crea una nueva entidad Cronograma a partir de un DTO.
     * <p>
     * Este método auxiliar construye una instancia de Cronograma con todos sus campos
     * y establece la relación bidireccional con el Paso2 correspondiente.
     * </p>
     *
     * @param paso2 entidad del Paso 2 a la que pertenece este cronograma
     * @param cronogramaDTO DTO con los datos del cronograma
     * @return nueva instancia de Cronograma configurada y vinculada al Paso2
     */
    private static Cronograma getCronograma(Paso2 paso2, CronogramaDTO cronogramaDTO) {
        Cronograma nuevoCronograma = new Cronograma();
        nuevoCronograma.setFecha(cronogramaDTO.getFecha());
        nuevoCronograma.setSituacion(cronogramaDTO.getSituacion());
        nuevoCronograma.setActuacion(cronogramaDTO.getActuacion());
        nuevoCronograma.setDocumento(cronogramaDTO.getDocumento());
        nuevoCronograma.setObservaciones(cronogramaDTO.getObservaciones());

        // Establecer la relación bidireccional
        nuevoCronograma.setPaso2(paso2);
        return nuevoCronograma;
    }
}