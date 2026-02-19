package es.instituto.orientacion.seguimiento_casos.services.servicesimpl;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.dto.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo4;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Anexo5;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.anexo.Cronograma;
import es.instituto.orientacion.seguimiento_casos.repositories.*;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementación del servicio de persistencia para la gestión de protocolos de orientación.
 * <p>
 * Esta clase se encarga de orquestar el mapeo entre los objetos DTO provenientes de la vista
 * y las entidades del modelo de datos. Gestiona la lógica de negocio para la creación
 * y edición de expedientes de alumnado, asegurando la integridad de las relaciones
 * bidireccionales en JPA para cada uno de los 11 pasos del protocolo.
 * </p>
 *
 * @author Departamento de Orientación
 * @version 1.0
 */
@Service
public class GuardarServiceImpl implements GuardarService {

    private final AlumnadoRepository alumnadoRepository;

    /**
     * Inyecta el repositorio necesario para la persistencia del alumnado.
     * @param alumnadoRepository Repositorio de acceso a datos de Alumnado.
     */
    public GuardarServiceImpl(AlumnadoRepository alumnadoRepository) {
        this.alumnadoRepository = alumnadoRepository;
    }

    /**
     * Registra un nuevo expediente de alumno procesando de forma secuencial todos los pasos del protocolo.
     * <p>
     * Se establece la fecha de registro automática para el Paso 1 y se gestionan las relaciones
     * jerárquicas con los Anexos 4 y 5 dentro del Paso 5.
     * </p>
     *
     * @param formularioDTO Contenedor de datos con la información completa del formulario.
     * @return {@code true} si el proceso finaliza con éxito; {@code false} si ocurre un error en la persistencia.
     */
    @Override
    public boolean crearAlumnado(FormularioDTO formularioDTO) {
        try {
        Alumnado alumnado = new Alumnado(formularioDTO);
        alumnado.setObservaciones(formularioDTO.getObservaciones());
        alumnado.setCodigoAlumno(formularioDTO.getCodigoAlumno());

        if (alumnado.getPaso1() != null) {
            alumnado.getPaso1().setAlumnado(alumnado);
            alumnado.getPaso1().setFechaRegistro(LocalDate.now());
        }
        if (alumnado.getPaso2() != null) {
            alumnado.getPaso2().setAlumnado(alumnado);
        }
        guardarCronograma(formularioDTO, alumnado.getPaso2());

        guardarPaso3(formularioDTO, alumnado);
        guardarPaso4(formularioDTO, alumnado);

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

        Long idNuevo = alumnadoRepository.save(alumnado).getId();
        return idNuevo != null;
        } catch (OptimisticLockingFailureException e) {
            // Otro usuario guardó este registro al mismo tiempo
            System.err.println("Conflicto al crear alumnado: " + e.getMessage());
            return false;
        }
    }

    /**
     * Edita un expediente existente. Recupera la entidad actual y actualiza cada paso
     * de forma individual para mantener la consistencia de los datos ya persistidos.
     * * @param formularioDTO Datos actualizados del expediente.
     * @return {@code true} tras guardar los cambios correctamente.
     * @throws java.util.NoSuchElementException si el ID del formulario no corresponde a ningún alumno.
     */
    @Override
    public boolean editarAlumnado(FormularioDTO formularioDTO) {
        try{
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(formularioDTO.getId()))
                .orElseThrow();
        alumnado.setObservaciones(formularioDTO.getObservaciones());
        alumnado.setCodigoAlumno(formularioDTO.getCodigoAlumno());

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
        } catch (OptimisticLockingFailureException e) {
            // Otro usuario editó este registro al mismo tiempo
            System.err.println("Conflicto al crear alumnado: " + e.getMessage());
            return false;
        }
    }

    /**
     * Actualiza los datos de cierre y seguimiento de inspección (Paso 11).
     * @param formularioDTO DTO con la información de cierre.
     * @param alumnado Entidad del alumno.
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
     * Mapea la información relativa al informe de dirección (Paso 9).
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
     * Mapea el seguimiento realizado por inspección (Paso 10).
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
     * Gestiona las medidas adicionales y responsables de dirección (Paso 8).
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
     * Mapea el Plan de Acompañamiento y todas sus medidas específicas (Paso 7).
     * <p>
     * Incluye medidas de prevención, protección, acompañamiento emocional y
     * actuaciones de los distintos perfiles (tutor, orientador, familia).
     * </p>
     */
    private static void guardarPaso7(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso7 paso7 = alumnado.getPaso7();
        if (paso7 == null) {
            paso7 = new Paso7();
            paso7.setAlumnado(alumnado);
            alumnado.setPaso7(paso7);
        }

        Paso7DTO dto7 = formularioDTO.getPaso7DTO();
        paso7.setCodigoAlumno(dto7.getCodigoAlumno());
        paso7.setObjetivoGeneral(dto7.getObjetivoGeneral());
        paso7.setObjetivosEspecificos(dto7.getObjetivosEspecificos());
        paso7.setEquipoAcompanamiento(dto7.getEquipoAcompanamiento());
        paso7.setCalendarioSeguimiento(dto7.getCalendarioSeguimiento());
        paso7.setTieneRepositorioAntecedentes(dto7.getTieneRepositorioAntecedentes());
        paso7.setTieneCronogramaFormalizado(dto7.getTieneCronogramaFormalizado());
        paso7.setEsFormatoDigital(dto7.getEsFormatoDigital());
        paso7.setMedidasPrevencionGeneral(dto7.getMedidasPrevencionGeneral());
        paso7.setMedidasProteccionSeguridad(dto7.getMedidasProteccionSeguridad());
        paso7.setMedidasAcompanamientoEmocional(dto7.getMedidasAcompanamientoEmocional());
        paso7.setOtrasMedidasAdoptadas(dto7.getOtrasMedidasAdoptadas());
        paso7.setInformacionEquipoDocente(dto7.getInformacionEquipoDocente());
        paso7.setPlanificacionObservacionAtencion(dto7.getPlanificacionObservacionAtencion());
        paso7.setAccionesTutor(dto7.getAccionesTutor());
        paso7.setIntervencionEquipoDocente(dto7.getIntervencionEquipoDocente());
        paso7.setIntervencionOrientacion(dto7.getIntervencionOrientacion());
        paso7.setIntervencionOtrosTrabajadores(dto7.getIntervencionOtrosTrabajadores());
        paso7.setAcompanamientoCompaneros(dto7.getAcompanamientoCompaneros());
        paso7.setActividadesSensibilizacionAula(dto7.getActividadesSensibilizacionAula());
        paso7.setFormacionProfesorado(dto7.getFormacionProfesorado());
        paso7.setActuacionesFamilia(dto7.getActuacionesFamilia());
        paso7.setActuacionesServiciosExternos(dto7.getActuacionesServiciosExternos());
        paso7.setElaboradoPor(dto7.getElaboradoPor());
        paso7.setFechaElaboracion(dto7.getFechaElaboracion());
    }

    /**
     * Procesa la comunicación a los distintos agentes implicados (Paso 6).
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
     * Gestiona el Paso 5 y la actualización incremental de sus anexos asociados.
     * <p>
     * Se utiliza el método {@code actualizarDesdeDTO} para mantener la misma instancia
     * de Hibernate si los anexos ya existían previamente.
     * </p>
     */
    private static void guardarPaso5(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso5 paso5 = alumnado.getPaso5();
        if (paso5 == null) {
            paso5 = new Paso5();
            paso5.setAlumnado(alumnado);
            alumnado.setPaso5(paso5);
        }

        Paso5DTO dto5 = formularioDTO.getPaso5DTO();

        if (dto5.getAnexo4() != null) {
            if (paso5.getAnexo4() == null) {
                Anexo4 nuevoAnexo4 = new Anexo4(dto5.getAnexo4());
                nuevoAnexo4.setPaso5(paso5);
                paso5.setAnexo4(nuevoAnexo4);
            } else {
                paso5.getAnexo4().actualizarDesdeDTO(dto5.getAnexo4());
            }
        }

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
     * Mapea el contenido de la reunión inicial y sus acuerdos (Paso 4).
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
     * Mapea las medidas provisionales adoptadas (Paso 3).
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
     * Gestiona la recogida de información inicial y el cronograma de hechos (Paso 2).
     */
    private void guardarPaso2(FormularioDTO formularioDTO, Alumnado alumnado){
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
     * Gestiona la comunicación inicial de los hechos y el detalle de la conducta detectada (Paso 1).
     */
    private void guardarPaso1(FormularioDTO formularioDTO, Alumnado alumnado){
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
     * Sincroniza la lista de hitos del cronograma asociados al Paso 2.
     * <p>
     * Este método limpia la colección actual y recrea los objetos Cronograma para
     * evitar inconsistencias en la ordenación y duplicidad de registros.
     * </p>
     */
    private void guardarCronograma(FormularioDTO formularioDTO, Paso2 paso2) {
        if (formularioDTO.getPaso2DTO() == null ||
                formularioDTO.getPaso2DTO().getCronogramaDTO() == null) {
            return;
        }

        if (paso2.getCronograma() == null) {
            paso2.setCronograma(new ArrayList<>());
        }

        paso2.getCronograma().clear();

        formularioDTO.getPaso2DTO().getCronogramaDTO().forEach(cronogramaDTO -> {
            Cronograma nuevoCronograma = getCronograma(paso2, cronogramaDTO);
            paso2.getCronograma().add(nuevoCronograma);
        });
    }

    /**
     * Genera una instancia de la entidad Cronograma a partir de su DTO.
     * @param paso2 Entidad del Paso 2 a la que pertenece el hito.
     * @param cronogramaDTO Datos del hito cronológico.
     * @return Entidad Cronograma configurada.
     */
    private static Cronograma getCronograma(Paso2 paso2, CronogramaDTO cronogramaDTO) {
        Cronograma nuevoCronograma = new Cronograma();
        nuevoCronograma.setFecha(cronogramaDTO.getFecha());
        nuevoCronograma.setSituacion(cronogramaDTO.getSituacion());
        nuevoCronograma.setActuacion(cronogramaDTO.getActuacion());
        nuevoCronograma.setDocumento(cronogramaDTO.getDocumento());
        nuevoCronograma.setObservaciones(cronogramaDTO.getObservaciones());
        nuevoCronograma.setPaso2(paso2);
        return nuevoCronograma;
    }
}