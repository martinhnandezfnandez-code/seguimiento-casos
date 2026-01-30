package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Alumnado;
import es.instituto.orientacion.seguimiento_casos.entities.Paso1;
import es.instituto.orientacion.seguimiento_casos.entities.dto.FormularioDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.CasosDTO;
import es.instituto.orientacion.seguimiento_casos.entities.dto.Paso1DTO;
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

        Alumnado alumnado;

        // CUANDO EDITO
        if (formularioDTO.getId() != null) {
            alumnado = alumnadoRepository.findById(String.valueOf(formularioDTO.getId()))
                    .orElseThrow();

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

        }
        // CUANDO REGISTRAMOS NUEVOS
        else {
            alumnado = new Alumnado(formularioDTO);

            if (alumnado.getPaso1() != null) {
                alumnado.getPaso1().setAlumnado(alumnado);
                alumnado.getPaso1().setFechaRegistro(LocalDate.now());
            }
        }

        if (formularioDTO.getCronograma() != null) {
            formularioDTO.getCronograma().forEach(c -> {
                c.setAlumnado(alumnado);
                alumnado.getCronograma().add(c);
            });
        }

        alumnadoRepository.save(alumnado);
        return "redirect:/alumnado/listar";
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
