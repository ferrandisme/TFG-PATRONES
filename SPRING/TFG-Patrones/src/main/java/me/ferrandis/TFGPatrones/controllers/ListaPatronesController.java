package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ListaPatronesController {


    private final PatronesServicio patronesServicio;

    @Autowired
    public ListaPatronesController(PatronesServicio servicio ){this.patronesServicio = servicio;}

    @GetMapping("/patrones")
    public String informacionPrincipal(Model model) {
        List<Patron> patrones = patronesServicio.getPatrones();
        model.addAttribute("patrones", patrones);
        return "patrones";
    }
}
