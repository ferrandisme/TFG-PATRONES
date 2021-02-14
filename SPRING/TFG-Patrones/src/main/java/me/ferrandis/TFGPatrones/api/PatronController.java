package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class PatronController {

    private final PatronesServicio patronesServicio;

    @Autowired
    public PatronController(PatronesServicio servicio){this.patronesServicio = servicio;}


    @GetMapping("/patron")
    public String getPatron(@RequestParam("n") String n, Model model) {
        Patron patron = patronesServicio.getPatron(n);
        if(patron == null || patron.nombre == null || patron.nombre.equals("")) {
            patron = new Patron();
            patron.nombre = "El patron buscado no existe";
            patron.resumen = "Este patron todavia tiene que ser añadido a nuestra web";
            patron.explicacion = "";
            patron._id = UUID.randomUUID();
            System.out.println("He entrado");
        }
        model.addAttribute("patron", patron);
        model.addAttribute("descripciones", patron.procesarResumen());
        return "patron";
    }
}
