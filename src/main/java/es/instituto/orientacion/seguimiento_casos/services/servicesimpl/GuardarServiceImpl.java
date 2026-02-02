package es.instituto.orientacion.seguimiento_casos.services.servicesimpl;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.dto.*;
import es.instituto.orientacion.seguimiento_casos.repositories.*;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class GuardarServiceImpl implements GuardarService {
    private final AlumnadoRepository alumnadoRepository;
    private final Paso1Repository paso1Repository;
    private final Paso2Repository paso2Repository;
    private final Paso4Repository paso4Repository;
    private final Paso5Repository paso5Repository;

    public GuardarServiceImpl(AlumnadoRepository alumnadoRepository, Paso1Repository paso1Repository, Paso2Repository paso2Repository, Paso4Repository paso4Repository, Paso5Repository paso5Repository) {
        this.alumnadoRepository = alumnadoRepository;
        this.paso1Repository = paso1Repository;
        this.paso2Repository = paso2Repository;
        this.paso4Repository = paso4Repository;
        this.paso5Repository = paso5Repository;
    }

    @Override
    public boolean crearAlumnado(FormularioDTO formularioDTO) {

        Alumnado alumnado = new Alumnado(formularioDTO);
        alumnado.setPaso3_1(formularioDTO.getPaso3_1());
        alumnado.setPaso7_1(formularioDTO.getPaso7_1());
        alumnado.setPaso8_1(formularioDTO.getPaso8_1());
        alumnado.setPaso9_1(formularioDTO.getPaso9_1());
        alumnado.setPaso10_1(formularioDTO.getPaso10_1());
        alumnado.setObservaciones(formularioDTO.getObservaciones());

        if (alumnado.getPaso1() != null) {
            alumnado.getPaso1().setAlumnado(alumnado);
            alumnado.getPaso1().setFechaRegistro(LocalDate.now());
        }
        if (alumnado.getPaso2() != null) {
            alumnado.getPaso2().setAlumnado(alumnado);
        }
        guardarCronograma(formularioDTO, alumnado.getPaso2());


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


        Long idNuevo = alumnadoRepository.save(alumnado).getId();
        return idNuevo != null;
    }

    @Override
    public boolean editarAlumnado(FormularioDTO formularioDTO) {
        Alumnado alumnado;
        alumnado = alumnadoRepository.findById(String.valueOf(formularioDTO.getId()))
                .orElseThrow();
        alumnado.setPaso3_1(formularioDTO.getPaso3_1());
        alumnado.setPaso3_1(formularioDTO.getPaso7_1());
        alumnado.setPaso3_1(formularioDTO.getPaso8_1());
        alumnado.setPaso3_1(formularioDTO.getPaso9_1());
        alumnado.setPaso3_1(formularioDTO.getPaso10_1());
        alumnado.setObservaciones(formularioDTO.getObservaciones());

        Paso1 paso1 = alumnado.getPaso1();
        if (paso1 == null) {
            paso1 = new Paso1();
            paso1.setAlumnado(alumnado);
            alumnado.setPaso1(paso1);
        }
        Paso1DTO dto = formularioDTO.getPaso1DTO();
        paso1.setCodigoAlumno(dto.getCodigoAlumno());
        paso1.setAlumnoComunica(dto.getAlumnoComunica());
        paso1.setCompanerosComunican(dto.getCompanerosComunican());
        paso1.setFamiliaComunica(dto.getFamiliaComunica());
        paso1.setIntentoPrevio(dto.getIntentoPrevio());
        paso1.setConductaAutolesiva(dto.getConductaAutolesiva());
        paso1.setOtrosDetalle(dto.getOtrosDetalle());
        paso1.setDetalleHechos(dto.getDetalleHechos());
        paso1.setFechaRegistro(dto.getFechaRegistro());
        paso1.setFirmas(dto.getFirmas());
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



        alumnadoRepository.save(alumnado);
        return true;
    }


    private static void guardarCronograma(FormularioDTO formularioDTO, Paso2 paso2) {
        System.out.println("=== Guardando cronograma ===");
        System.out.println("Paso2DTO completo: " + formularioDTO.getPaso2DTO());
        System.out.println("Cronograma DTO: " + formularioDTO.getPaso2DTO().getCronograma());


        if (formularioDTO.getPaso2DTO() == null ||
                formularioDTO.getPaso2DTO().getCronograma() == null) {
            System.out.println("No hay cronograma para guardar");
            return;
        }

        // Inicializar la colección si es null
        if (paso2.getCronograma() == null) {
            paso2.setCronograma(new ArrayList<>());
        }

        System.out.println("Cantidad de items recibidos: " + formularioDTO.getPaso2DTO().getCronograma().size());

        // Limpiar elementos existentes
        paso2.getCronograma().clear();

        // Crear nuevos objetos Cronograma
        formularioDTO.getPaso2DTO().getCronograma().forEach(cronogramaDTO -> {
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


