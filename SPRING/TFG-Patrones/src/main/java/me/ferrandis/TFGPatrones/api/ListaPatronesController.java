package me.ferrandis.TFGPatrones.api;

import lombok.Data;
import me.ferrandis.TFGPatrones.modelo.DatosVentanaPrincipal;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.servicio.ListaPatronesServicio;
import me.ferrandis.TFGPatrones.servicio.VentanaPrincipalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListaPatronesController {


    private final ListaPatronesServicio listaPatronesServicio;

    @Autowired
    public ListaPatronesController(ListaPatronesServicio servicio){this.listaPatronesServicio = servicio;}

    @GetMapping("/patrones")
    public String informacionPrincipal(Model model) {
        List<Patron> patrones = listaPatronesServicio.getListaPatrones();
        model.addAttribute("patrones", patrones);
        return "patrones";
    }
}

