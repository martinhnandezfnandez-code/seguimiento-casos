package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.Paso2;
import es.instituto.orientacion.seguimiento_casos.entities.Paso4;
import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.CasosDTO;
import es.instituto.orientacion.seguimiento_casos.repositories.AlumnadoRepository;
import es.instituto.orientacion.seguimiento_casos.repositories.Paso1Repository;
import es.instituto.orientacion.seguimiento_casos.repositories.Paso2Repository;
import es.instituto.orientacion.seguimiento_casos.repositories.Paso4Repository;
import es.instituto.orientacion.seguimiento_casos.services.GuardarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alumnado")
public class AlumnadoController {
    private final GuardarService guardarService;
    private final AlumnadoRepository alumnadoRepository;
    private final Paso1Repository paso1Repository;
    private final Paso2Repository paso2Repository;
    private final Paso4Repository paso4Repository;


    public AlumnadoController(GuardarService guardarService, AlumnadoRepository alumnadoRepository, Paso1Repository paso1Repository, Paso2Repository paso2Repository, Paso4Repository paso4Repository) {
        this.guardarService = guardarService;
        this.alumnadoRepository = alumnadoRepository;
        this.paso1Repository = paso1Repository;
        this.paso2Repository = paso2Repository;
        this.paso4Repository = paso4Repository;
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

        // CUANDO EDITAMOS
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
    //guardar
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
            Optional<Paso2> paso2Optional = paso2Repository.findByAlumnadoId(alumno.getId());
            Optional<Paso4> paso4Optional = paso4Repository.findByAlumnadoId(alumno.getId());
            Paso1 paso1 = paso1Optional.orElse(null);
            Paso2 paso2 = paso2Optional.orElse(null);
            Paso4 paso4 = paso4Optional.orElse(null);
            listado.add(new CasosDTO(alumno, paso1, paso2, paso4));
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
