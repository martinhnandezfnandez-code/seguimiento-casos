package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.*;
import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.CasosDTO;
import es.instituto.orientacion.seguimiento_casos.entities.pasos.*;
import es.instituto.orientacion.seguimiento_casos.repositories.*;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import es.instituto.orientacion.seguimiento_casos.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador principal para la gestión de casos de alumnado.
 * <p>
 * Este controlador maneja todas las operaciones CRUD relacionadas con el seguimiento
 * de casos de alumnos, incluyendo la creación, edición, listado, eliminación y
 * exportación de documentos PDF para cada uno de los pasos del protocolo de seguimiento.
 * </p>
 *
 * @author Instituto de Orientación
 * @version 1.0
 */
@Controller
@RequestMapping("/alumnado")
public class AlumnadoController {

    private final GuardarService guardarService;
    private final AlumnadoRepository alumnadoRepository;
    private final Paso1Repository paso1Repository;
    private final Paso2Repository paso2Repository;
    private final Paso3Repository paso3Repository;
    private final Paso4Repository paso4Repository;
    private final Paso5Repository paso5Repository;
    private final Paso6Repository paso6Repository;
    private final Paso7Repository paso7Repository;
    private final Paso8Repository paso8Repository;
    private final Paso9Repository paso9Repository;
    private final Paso10Repository paso10Repository;
    private final Paso11Repository paso11Repository;
    private final PdfService pdfService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param guardarService servicio para gestionar operaciones de guardado y edición
     * @param alumnadoRepository repositorio de datos de alumnado
     * @param paso1Repository repositorio para el paso 1 del protocolo
     * @param paso2Repository repositorio para el paso 2 del protocolo
     * @param paso3Repository repositorio para el paso 3 del protocolo
     * @param paso4Repository repositorio para el paso 4 del protocolo
     * @param paso5Repository repositorio para el paso 5 del protocolo
     * @param paso6Repository repositorio para el paso 6 del protocolo
     * @param paso7Repository repositorio para el paso 7 del protocolo
     * @param paso8Repository repositorio para el paso 8 del protocolo
     * @param paso9Repository repositorio para el paso 9 del protocolo
     * @param paso10Repository repositorio para el paso 10 del protocolo
     * @param paso11Repository repositorio para el paso 11 del protocolo
     * @param pdfService servicio para la generación de documentos PDF
     */
    public AlumnadoController(GuardarService guardarService, AlumnadoRepository alumnadoRepository,
                              Paso1Repository paso1Repository, Paso2Repository paso2Repository,
                              Paso3Repository paso3Repository, Paso4Repository paso4Repository,
                              Paso5Repository paso5Repository, Paso6Repository paso6Repository,
                              Paso7Repository paso7Repository, Paso8Repository paso8Repository,
                              Paso9Repository paso9Repository, Paso10Repository paso10Repository,
                              Paso11Repository paso11Repository, PdfService pdfService) {
        this.guardarService = guardarService;
        this.alumnadoRepository = alumnadoRepository;
        this.paso1Repository = paso1Repository;
        this.paso2Repository = paso2Repository;
        this.paso3Repository = paso3Repository;
        this.paso4Repository = paso4Repository;
        this.paso5Repository = paso5Repository;
        this.paso6Repository = paso6Repository;
        this.paso7Repository = paso7Repository;
        this.paso8Repository = paso8Repository;
        this.paso9Repository = paso9Repository;
        this.paso10Repository = paso10Repository;
        this.paso11Repository = paso11Repository;
        this.pdfService = pdfService;
    }

    /**
     * Muestra el formulario para crear un nuevo caso de alumno.
     *
     * @param model modelo de Spring MVC para pasar datos a la vista
     * @return nombre de la vista del formulario de nuevo caso
     */
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("formulario", new FormularioDTO());
        return "nuevocaso/nuevo";
    }

    /**
     * Procesa el guardado de un caso de alumno (nuevo o existente).
     * <p>
     * Si el formulario incluye un ID, se actualiza el registro existente.
     * Si no tiene ID, se crea un nuevo registro.
     * </p>
     *
     * @param formularioDTO objeto de transferencia de datos con la información del formulario
     * @return redirección a la lista de casos o página de error según el resultado
     */
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("formulario") FormularioDTO formularioDTO) {
        boolean result;

        // Actualizar caso existente
        if (formularioDTO.getId() != null) {
            result = guardarService.editarAlumnado(formularioDTO);
        }
        // Crear nuevo caso
        else {
            result = guardarService.crearAlumnado(formularioDTO);
        }

        if (!result){
            return "redirect:/alumnado/fallo-guardar";
        }
        return "redirect:/alumnado/listar";
    }

    /**
     * Muestra la página de error cuando falla el guardado de un caso.
     *
     * @param model modelo de Spring MVC
     * @return nombre de la vista de error
     */
    @GetMapping("/fallo-guardar")
    public String fallar(Model model) {
        return "fallo-guardar";
    }

    /**
     * Lista todos los casos de alumnado con sus respectivos pasos completados.
     * <p>
     * Recupera todos los alumnos y para cada uno obtiene la información de los
     * 11 pasos del protocolo, creando un DTO consolidado para la visualización.
     * </p>
     *
     * @param model modelo de Spring MVC para pasar la lista a la vista
     * @return nombre de la vista del listado
     */
    @GetMapping("/listar")
    public String listar(Model model) {
        List<CasosDTO> listado = new ArrayList<>();
        List<Alumnado> lista = alumnadoRepository.findAll();

        // Construir DTO con información completa de cada alumno y sus pasos
        for (Alumnado alumno : lista) {
            Optional<Paso1> paso1Optional = paso1Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso2> paso2Optional = paso2Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso3> paso3Optional = paso3Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso4> paso4Optional = paso4Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso5> paso5Optional = paso5Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso6> paso6Optional = paso6Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso7> paso7Optional = paso7Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso8> paso8Optional = paso8Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso9> paso9Optional = paso9Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso10> paso10Optional = paso10Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso11> paso11Optional = paso11Repository.findByAlumnadoId(alumno.getId());

            Paso1 paso1 = paso1Optional.orElse(null);
            Paso2 paso2 = paso2Optional.orElse(null);
            Paso3 paso3 = paso3Optional.orElse(null);
            Paso4 paso4 = paso4Optional.orElse(null);
            Paso5 paso5 = paso5Optional.orElse(null);
            Paso6 paso6 = paso6Optional.orElse(null);
            Paso7 paso7 = paso7Optional.orElse(null);
            Paso8 paso8 = paso8Optional.orElse(null);
            Paso9 paso9 = paso9Optional.orElse(null);
            Paso10 paso10 = paso10Optional.orElse(null);
            Paso11 paso11 = paso11Optional.orElse(null);

            listado.add(new CasosDTO(alumno, paso1, paso2, paso3, paso4, paso5, paso6, paso7, paso8, paso9, paso10, paso11));
        }

        System.out.println("Total de registros encontrados: " + listado.size());
        model.addAttribute("alumnos", listado);

        return "listados/listado";
    }

    /**
     * Muestra el formulario de edición para un caso existente.
     *
     * @param id identificador único del alumno
     * @param model modelo de Spring MVC
     * @return nombre de la vista de edición
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Alumnado alumnado = alumnadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        model.addAttribute("formulario", new FormularioDTO(alumnado));
        return "editarcaso/editar";
    }

    /**
     * Elimina un caso de alumno del sistema.
     *
     * @param id identificador único del alumno a eliminar
     * @return redirección a la lista de casos
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        alumnadoRepository.deleteById(id);
        return "redirect:/alumnado/listar";
    }

    /**
     * Muestra el menú de opciones de exportación de documentos.
     *
     * @param model modelo de Spring MVC con la lista de alumnos
     * @return nombre de la vista del menú de exportación
     */
    @GetMapping("/exportar")
    public String mostrarMenuExportar(Model model) {
        // Pasamos la lista de todos los alumnos para el desplegable
        model.addAttribute("alumnos", alumnadoRepository.findAll());
        return "exportar/menu_exportar";
    }

    /**
     * Genera y descarga el PDF del Anexo 1 para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso1/{id}")
    public ResponseEntity<byte[]> descargarPaso1(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo1(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo1_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 2 (Cronograma) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso2/{id}")
    public ResponseEntity<byte[]> descargarPaso2(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo2(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo2_Cronograma_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 3 (Acta Familia) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso4/{id}")
    public ResponseEntity<byte[]> descargarPaso4(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo3(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo3_ActaFamilia_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 4 (Síntesis) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso5_anexo4/{id}")
    public ResponseEntity<byte[]> descargarAnexo4(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo4(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo4_Sintesis_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 5 (Análisis de Caso) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso5_anexo5/{id}")
    public ResponseEntity<byte[]> descargarAnexo5(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo5(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo5_AnalisisCaso_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 6 (Resolución) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso6/{id}")
    public ResponseEntity<byte[]> descargarPaso6(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo6(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo6_Resolucion_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 7 (Plan Individualizado) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso7/{id}")
    public ResponseEntity<byte[]> descargarPaso7(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo7(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo7_Plan_individualizado_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    /**
     * Genera y descarga el PDF del Anexo 8 (Seguimiento) para un alumno específico.
     *
     * @param id identificador del alumno
     * @return ResponseEntity con el PDF generado
     * @throws RuntimeException si el alumno no existe
     */
    @GetMapping("/pdf/paso8/{id}")
    public ResponseEntity<byte[]> descargarPaso8(@PathVariable Long id) {
        Alumnado alumnado = alumnadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        byte[] pdfBytes = pdfService.generarPdfAnexo8(alumnado);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Anexo8_Seguimiento_" + alumnado.getCodigoAlumno() + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}