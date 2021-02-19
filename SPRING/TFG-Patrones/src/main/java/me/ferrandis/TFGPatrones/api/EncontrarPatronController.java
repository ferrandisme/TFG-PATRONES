package me.ferrandis.TFGPatrones.api;
import me.ferrandis.TFGPatrones.modelo.Encapsulaciones.DatosVentanaPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EncontrarPatronController {
    
    @GetMapping("/encontrarPatron")
    public String informacionPrincipal(Model model) {
        return "encontrar-patron";
    }
}
