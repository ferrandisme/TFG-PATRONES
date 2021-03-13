package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Slf4j
@Controller
public class PatronController {

    private final PatronesServicio patronesServicio;

    @Autowired
    public PatronController(PatronesServicio servicio){this.patronesServicio = servicio;}


    @GetMapping("/patron")
    public String getPatron(@RequestParam("n") String n, Model model) {

        DTOPatron patron;

        try {
            patron = patronesServicio.findById(n);
        }
        catch(Exception e){
            patron = new DTOPatron();
            patron.setNombre("Error");
            patron.setResumen(e.getMessage());
            patron.setTextoExplicacion(new ArrayList<>());
            patron.setURLImagenes(new ArrayList<>());
        }

        System.err.println("Hay que cambiar esto a un DTO");
        model.addAttribute("patron", patron);
        model.addAttribute("descripciones", patron.getTextoExplicacion());
        model.addAttribute("imagenes", patron.getURLImagenes());
        return "patron";
    }
}
