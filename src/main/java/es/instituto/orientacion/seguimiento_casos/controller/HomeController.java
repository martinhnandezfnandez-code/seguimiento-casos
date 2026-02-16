package es.instituto.orientacion.seguimiento_casos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * Procesa el entrado al menú principal
     *
     * @return direccion al menú
     */
    @GetMapping("/")
    public String home() {
        return "menu";
    }

}