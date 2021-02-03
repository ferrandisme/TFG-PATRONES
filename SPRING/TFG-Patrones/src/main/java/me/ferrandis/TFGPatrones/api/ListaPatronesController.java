package me.ferrandis.TFGPatrones.api;

import lombok.Data;
import me.ferrandis.TFGPatrones.modelo.DatosVentanaPrincipal;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListaPatronesController {


    @GetMapping("/patrones")
    public String informacionPrincipal(Model model) {
        List<Patron> patrones = new ArrayList<>();
        patrones.add(new Patron(1,"Estrategia","Hola soy estrategia"));
        patrones.add(new Patron(2,"OtroPatron","Hola soy otro patron"));
        model.addAttribute("patrones", patrones);
        return "patrones";
    }
}

