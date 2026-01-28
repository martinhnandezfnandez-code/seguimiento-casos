package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.interfaces.AlumnadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

        // Enlazar cronograma (Paso 2_6) con el alumnado
        if (alumnado.getCronograma() != null) {
            alumnado.getCronograma()
                    .forEach(c -> c.setAlumnado(alumnado));
        }

        // Guardado general (alumnado + cronograma en cascada)
        alumnadoRepository.save(alumnado);
        if (alumnado.getId() == null) {
            alumnado.setFechaRegistro(LocalDate.now());
        }

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
