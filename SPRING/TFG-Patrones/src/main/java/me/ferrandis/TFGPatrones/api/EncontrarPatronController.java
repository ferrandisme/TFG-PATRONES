package me.ferrandis.TFGPatrones.api;
import me.ferrandis.TFGPatrones.modelo.Encapsulaciones.DatosVentanaPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class EncontrarPatronController {

    @GetMapping("/encontrarPatron")
    public String informacionPrincipal(Model model) {
        Random rand = new Random();
        long randomNum = rand.nextInt((Integer.MAX_VALUE));
        model.addAttribute("iduser",randomNum);
        return "encontrar-patron";
    }
}