package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.interfaces.AlumnadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumnado")
public class AlumnadoController {

    private final AlumnadoRepository alumnadoRepository;

    public AlumnadoController(AlumnadoRepository alumnadoRepository) {
        this.alumnadoRepository = alumnadoRepository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("alumnado", new Alumnado());
        return "nuevo-caso";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("alumnado") Alumnado alumnado) {

        System.out.println("=== GUARDANDO ALUMNADO ===");
        System.out.println("ID: " + alumnado.getId());
        System.out.println("ID Caso: " + alumnado.getIdCaso());
        System.out.println("ID Documento: " + alumnado.getIdDocumento());

        // ===== PASO 1 - ANEXO I =====
        System.out.println("Código Alumno: " + alumnado.getCodigoAlumno());
        System.out.println("Familia comunica: " + alumnado.getFamiliaComunica());
        System.out.println("Compañeros comunican: " + alumnado.getCompanerosComunican());
        System.out.println("Alumno comunica: " + alumnado.getAlumnoComunica());
        System.out.println("Intento previo: " + alumnado.getIntentoPrevio());
        System.out.println("Conducta autolesiva: " + alumnado.getConductaAutolesiva());
        System.out.println("Otros motivo: " + alumnado.getOtrosMotivo());
        System.out.println("Otros detalle: " + alumnado.getOtrosDetalle());
        System.out.println("Detalle hechos: " + alumnado.getDetalleHechos());
        System.out.println("Fecha registro: " + alumnado.getFechaRegistro());
        System.out.println("Firmas: " + alumnado.getFirmas());

        // ===== OBSERVACIONES GENERALES =====
        System.out.println("Observaciones: " + alumnado.getObservaciones());

        // ===== GUARDADO =====
        Alumnado guardado = alumnadoRepository.save(alumnado);

        System.out.println("✓ Guardado exitosamente con ID: " + guardado.getId());
        System.out.println("Fecha creación: " + guardado.getFechaCreacion());
        System.out.println("==========================");

        return "redirect:/alumnado/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Alumnado> lista = alumnadoRepository.findAll();
        System.out.println("Total de registros encontrados: " + lista.size());

        // ESTO FALTABA - Añadir la lista al modelo para que Thymeleaf la pueda mostrar
        model.addAttribute("alumnos", lista);

        return "listado-casos";
    }

    // OPCIONAL: Método para editar un caso existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Alumnado alumnado = alumnadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        model.addAttribute("alumnado", alumnado);
        return "nuevo-caso"; // Reutilizamos el mismo formulario
    }

    // OPCIONAL: Método para eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        alumnadoRepository.deleteById(id);
        return "redirect:/alumnado/listar";
    }
}
