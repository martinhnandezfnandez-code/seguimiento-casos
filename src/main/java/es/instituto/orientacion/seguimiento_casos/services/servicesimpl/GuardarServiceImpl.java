package es.instituto.orientacion.seguimiento_casos.services.servicesimpl;

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

@Service
public class GuardarServiceImpl implements GuardarService {
    private final AlumnadoRepository alumnadoRepository;

    public GuardarServiceImpl(AlumnadoRepository alumnadoRepository) {
        this.alumnadoRepository = alumnadoRepository;
    }


    @Override
    public boolean crearAlumnado(FormularioDTO formularioDTO) {

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

        guardarPaso10(formularioDTO,alumnado);

        guardarPaso11(formularioDTO, alumnado);

        Long idNuevo = alumnadoRepository.save(alumnado).getId();
        return idNuevo != null;
    }

    @Override
    public boolean editarAlumnado(FormularioDTO formularioDTO) {
        Alumnado alumnado;
        alumnado = alumnadoRepository.findById(String.valueOf(formularioDTO.getId()))
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

        guardarPaso10(formularioDTO,alumnado);

        guardarPaso11(formularioDTO, alumnado);

        alumnadoRepository.save(alumnado);
        return true;
    }

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

    private static void guardarPaso5(FormularioDTO formularioDTO, Alumnado alumnado) {
        Paso5 paso5 = alumnado.getPaso5();
        if (paso5 == null) {
            paso5 = new Paso5();
            paso5.setAlumnado(alumnado);
            alumnado.setPaso5(paso5);
        }

        Paso5DTO dto5 = formularioDTO.getPaso5DTO();

        // Lógica para Anexo 4
        if (dto5.getAnexo4() != null) {
            if (paso5.getAnexo4() == null) {
                // Si no existe, creamos uno nuevo como hacías antes
                Anexo4 nuevoAnexo4 = new Anexo4(dto5.getAnexo4());
                nuevoAnexo4.setPaso5(paso5);
                paso5.setAnexo4(nuevoAnexo4);
            } else {
                // SI YA EXISTE, actualizamos la instancia que Hibernate ya conoce
                paso5.getAnexo4().actualizarDesdeDTO(dto5.getAnexo4());
            }
        }

        // Lógica para Anexo 5 (deberías crear un método similar en Anexo5)
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


    private  void guardarPaso2(FormularioDTO formularioDTO, Alumnado alumnado){
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

    private void guardarCronograma(FormularioDTO formularioDTO, Paso2 paso2) {
        System.out.println("=== Guardando cronograma ===");
        System.out.println("Paso2DTO completo: " + formularioDTO.getPaso2DTO());
        System.out.println("Cronograma DTO: " + formularioDTO.getPaso2DTO().getCronogramaDTO());


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

        // Limpiar elementos existentes
        paso2.getCronograma().clear();

        // Crear nuevos objetos Cronograma
        formularioDTO.getPaso2DTO().getCronogramaDTO().forEach(cronogramaDTO -> {
            System.out.println("Procesando item:");
            System.out.println("  - Fecha: " + cronogramaDTO.getFecha());
            System.out.println("  - Situacion: " + cronogramaDTO.getSituacion());
            System.out.println("  - Actuacion: " + cronogramaDTO.getActuacion());

            // Crear una NUEVA instancia de Cronograma
            Cronograma nuevoCronograma = new Cronograma();
            nuevoCronograma.setFecha(cronogramaDTO.getFecha());
            nuevoCronograma.setSituacion(cronogramaDTO.getSituacion());
            nuevoCronograma.setActuacion(cronogramaDTO.getActuacion());
            nuevoCronograma.setDocumento(cronogramaDTO.getDocumento());
            nuevoCronograma.setObservaciones(cronogramaDTO.getObservaciones());

            // Establecer la relación bidireccional
            nuevoCronograma.setPaso2(paso2);

            // Añadir a la colección
            paso2.getCronograma().add(nuevoCronograma);
        });

        System.out.println("Total items añadidos a paso2: " + paso2.getCronograma().size());
    }
    }


