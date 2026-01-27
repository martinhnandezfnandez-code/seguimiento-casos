package es.instituto.orientacion.seguimiento_casos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/casos"; // Redirige directamente a la lista de casos
    }
}