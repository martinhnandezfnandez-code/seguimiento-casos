package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.CasosDTO;
import es.instituto.orientacion.seguimiento_casos.repositories.AlumnadoRepository;
import es.instituto.orientacion.seguimiento_casos.repositories.Paso1Repository;
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

    private final AlumnadoRepository alumnadoRepository;
    private final Paso1Repository paso1Repository;

    public AlumnadoController(AlumnadoRepository alumnadoRepository, Paso1Repository paso1Repository) {
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

        if (formularioDTO.getCronograma() != null) {
            formularioDTO.getCronograma()
                    .forEach(c -> c.setAlumnado(new Alumnado(formularioDTO)));
        }

        alumnadoRepository.save(new Alumnado(formularioDTO));
        if (formularioDTO.getId() == null) {
            formularioDTO.setFechaRegistro(LocalDate.now());
        }

        return "redirect:/alumnado/listar";
    }


    @GetMapping("/listar")
    public String listar(Model model) {
        List<CasosDTO> listado = new ArrayList<>();
        List<Alumnado> lista = alumnadoRepository.findAll();
        for (Alumnado alumno : lista) {
            Optional<Paso1> paso1Optional = paso1Repository.findByAlumnadoId(alumno.getId());
            if (paso1Optional.isPresent()) {
                listado.add(new CasosDTO(alumno, paso1Optional.get()));
            }
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
        model.addAttribute("formulario", new FormularioDTO(alumnado, alumnado.getPaso1()));
        return "nuevo-caso";
    }

    // OPCIONAL: Método para eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        alumnadoRepository.deleteById(id);
        return "redirect:/alumnado/listar";
    }
}
