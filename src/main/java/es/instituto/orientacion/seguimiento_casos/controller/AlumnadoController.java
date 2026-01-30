package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.CasosDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso1DTO;
import es.instituto.orientacion.seguimiento_casos.repositories.AlumnadoRepository;
import es.instituto.orientacion.seguimiento_casos.repositories.Paso1Repository;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alumnado")
public class AlumnadoController {
    private final GuardarService guardarService;
    private final AlumnadoRepository alumnadoRepository;
    private final Paso1Repository paso1Repository;

    public AlumnadoController(GuardarService guardarService, AlumnadoRepository alumnadoRepository, Paso1Repository paso1Repository) {
        this.guardarService = guardarService;
        this.alumnadoRepository = alumnadoRepository;
        this.paso1Repository = paso1Repository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("formulario", new FormularioDTO());
        return "nuevo-caso";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("formulario") FormularioDTO formularioDTO) {

        Alumnado alumnado;
        boolean result = false;

        // CUANDO EDITO
        if (formularioDTO.getId() != null) {
            result = guardarService.editarAlumnado(formularioDTO);

        }
        // CUANDO REGISTRAMOS NUEVOS
        else {
           result = guardarService.crearAlumnado(formularioDTO);
        }
        if (!result){
            return "redirect:/alumnado/fallo-guardar";
        }
        return "redirect:/alumnado/listar";
    }
    @GetMapping("/fallo-guardar")
    public String fallar(Model model) {

        return "fallo-guardar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<CasosDTO> listado = new ArrayList<>();
        List<Alumnado> lista = alumnadoRepository.findAll();
        for (Alumnado alumno : lista) {
            Optional<Paso1> paso1Optional = paso1Repository.findByAlumnadoId(alumno.getId());
            Paso1 paso1 = paso1Optional.orElse(null);
            listado.add(new CasosDTO(alumno, paso1));
        }
        System.out.println("Total de registros encontrados: " + listado.size());
        model.addAttribute("alumnos", listado);

        return "listado-casos";
    }

    // OPCIONAL: Método para editar un caso existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Alumnado alumnado = alumnadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        model.addAttribute("formulario",
                new FormularioDTO(alumnado));
        return "nuevo-caso";
    }

    // OPCIONAL: Método para eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        alumnadoRepository.deleteById(id);
        return "redirect:/alumnado/listar";
    }
}
