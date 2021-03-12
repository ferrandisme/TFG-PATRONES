package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.DTO.DatosVentanaPrincipal;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import me.ferrandis.TFGPatrones.servicio.VentanaPrincipalServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentanaPrincipalController {


    private final PatronesServicio patronesServicio;

    @Autowired
    public VentanaPrincipalController(PatronesServicio servicio){this.patronesServicio = servicio;}

    @GetMapping({"","/home","/","/index.html","/index"})
    public String informacionPrincipal(Model model) {
        DatosVentanaPrincipal patrones = new DatosVentanaPrincipal(patronesServicio.getPatrones().size());
        model.addAttribute("patrones", patrones);
        return "principal";
    }

    @GetMapping("/creditos")
    public String informacionCreditos(Model model) {
        return "creditos";
    }
}
