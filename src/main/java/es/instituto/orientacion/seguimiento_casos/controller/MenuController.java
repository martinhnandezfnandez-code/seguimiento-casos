package es.instituto.orientacion.seguimiento_casos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MenuController {
    /**
     * Procesa el entrado al menú principal
     *
     * @return direccion al menú
     */
    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

}
