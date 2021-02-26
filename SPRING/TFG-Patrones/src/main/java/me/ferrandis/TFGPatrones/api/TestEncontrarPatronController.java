package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import me.ferrandis.TFGPatrones.servicio.TestServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class TestEncontrarPatronController {


    private final TestServicio servicio;

    @Autowired
    public TestEncontrarPatronController(TestServicio servicio){ this.servicio = servicio; }

    //Nota -> Cambiado id String a int, modificar si da algun problema
    @GetMapping("/testEstructural/{id}")
    public String iniciarEstructural(@PathVariable("id") int id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = CargarPregunta("estructural",id, opcion);
        model.addAttribute("pregunta",pregunta);
        return "test-encontrar-patron";
    }

    @GetMapping("/testCreacional/{id}")
    public String iniciarCreacional(@PathVariable("id") int id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = CargarPregunta("creacional",id, opcion);
        model.addAttribute("pregunta",pregunta);
        return "test-encontrar-patron";
    }

    @GetMapping("/testComportamiento/{id}")
    public String iniciarComportamiento(@PathVariable("id") int id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = CargarPregunta("comportamiento",id, opcion);
        model.addAttribute("pregunta",pregunta);
        return "test-encontrar-patron";
    }

    //Intentara cargar un test de ese tipo con dicha ID. Devolvera null en caso de no existir
    public String CargarPregunta(String tipo, int id, String opcion){
        return "Pregunta de prueba";
    }

    public void CrearCuestionario(){

    }
}