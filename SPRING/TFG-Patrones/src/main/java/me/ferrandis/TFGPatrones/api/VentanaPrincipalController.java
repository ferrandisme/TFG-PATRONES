package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.Encapsulaciones.DatosVentanaPrincipal;
import me.ferrandis.TFGPatrones.servicio.VentanaPrincipalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentanaPrincipalController {


    private final VentanaPrincipalServicio ventanaPrincipalServicio;

    @Autowired
    public VentanaPrincipalController(VentanaPrincipalServicio servicio){this.ventanaPrincipalServicio = servicio;}

    @GetMapping({"","/home","/","/index.html","/index"})
    public String informacionPrincipal(Model model) {
        DatosVentanaPrincipal patrones = new DatosVentanaPrincipal(ventanaPrincipalServicio.getNumeroPatrones());
        model.addAttribute("patrones", patrones);
        return "principal";
    }

    @GetMapping("/creditos")
    public String informacionCreditos(Model model) {
        return "creditos";
    }
}
