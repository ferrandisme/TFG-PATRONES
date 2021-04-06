package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class VentanaPrincipalController {


    private final PatronesServicio patronesServicio;

    @Autowired
    public VentanaPrincipalController(PatronesServicio servicio){this.patronesServicio = servicio;}

    @GetMapping({"","/home","/","/index.html","/index"})
    public String informacionPrincipal(Model model) {
        //DatosVentanaPrincipal patrones = new DatosVentanaPrincipal(patronesServicio.getPatrones().size());

        model.addAttribute("numeroPatrones", patronesServicio.getPatrones().size());
        return "principal";
    }

    @GetMapping("/creditos")
    public String informacionCreditos(Model model) {
        return "creditos";
    }
}
