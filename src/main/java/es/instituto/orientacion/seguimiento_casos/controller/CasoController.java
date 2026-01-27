package es.instituto.orientacion.seguimiento_casos.controller;

import es.instituto.orientacion.seguimiento_casos.entities.Caso;
import es.instituto.orientacion.seguimiento_casos.interfaces.CasoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/casos")
public class CasoController {

    private final CasoRepository casoRepository;

    public CasoController(CasoRepository casoRepository) {
        this.casoRepository = casoRepository;
    }

    @GetMapping
    public String listarCasos(Model model) {
        model.addAttribute("casos", casoRepository.findAll());
        return "listar-casos";
    }

    @GetMapping("/nuevo")
    public String nuevoCaso(Model model) {
        model.addAttribute("caso", new Caso());
        return "nuevo-caso";
    }

    @PostMapping("/guardar")
    public String guardarCaso(@ModelAttribute Caso caso) {

        String idCaso = "A-" + UUID.randomUUID().toString().substring(0, 8);
        caso.setIdCaso(idCaso);
        caso.setFechaCreacion(java.time.LocalDateTime.now());
        caso.setFechaUltimaActualizacion(java.time.LocalDateTime.now());
        casoRepository.save(caso);
        return "redirect:/casos";
    }
}

