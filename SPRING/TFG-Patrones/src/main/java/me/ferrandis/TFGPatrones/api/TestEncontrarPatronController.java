package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.Encapsulaciones.InfoTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import me.ferrandis.TFGPatrones.servicio.TestServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class TestEncontrarPatronController {

    private final TestServicioImp servicio;

    @Autowired
    public TestEncontrarPatronController(TestServicioImp servicio){
        this.servicio = servicio;
    }

    @GetMapping("/testEstructural/{id}")
    public String iniciarEstructural(@PathVariable("id") int id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = cargarPregunta("estructural",id, opcion);
        return ProcesarResultados(pregunta, model, id, "estructural");
    }

    @GetMapping("/testCreacional/{id}")
    public String iniciarCreacional(@PathVariable("id") int id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = cargarPregunta("creacional",id, opcion);
        return ProcesarResultados(pregunta, model, id, "creacional");
    }

    @GetMapping("/testComportamiento/{id}")
    public String iniciarComportamiento(@PathVariable("id") int id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = cargarPregunta("comportamiento",id, opcion);
        return ProcesarResultados(pregunta, model, id, "comportamiento");
    }

    //Intentara cargar una pregunta del test con dicha ID. Devolvera null en caso de no existir
    private String cargarPregunta(String tipo, String id, String opcion)
    {
        Test test = obtenerTest(id, tipo);
        if(opcion != null)
        {
            test.ActualizarPregunta(Integer.parseInt(opcion));
            //servicio.actualizarTest(test);
        }
        return test.SiguientePregunta();
    }

    private String ProcesarResultados(String pregunta, Model model, int id, String tipo){
        Test test = obtenerTest(id, tipo);
        if(pregunta == null){
            List<InfoTest> info = test.getPuntuaciones();
            model.addAttribute("patrones",info);
            return "resultados";
        }else{
            model.addAttribute("pregunta",pregunta);
            return "test-encontrar-patron";
        }
    }

    /*private Test crearCuestionario(int id, String tipo){
        Test test = servicio.CrearTest(tipo, id);
        cuestionarios.put(id,test);
        return test;
    }*/

    private Test obtenerTest(String id, String tipo){
        Test test = null;
        try {
            test = servicio.findById(id);
        } catch (Exception e) {
            test = servicio.crearTest();
        }
        return test;
    }

}