package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.modelo.Encapsulaciones.InfoTest;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.modelo.Test;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import me.ferrandis.TFGPatrones.servicio.TestServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class TestEncontrarPatronController {

    private final TestServicio servicio;
    Map<Integer,Test> cuestionarios;

    @Autowired
    public TestEncontrarPatronController(TestServicio servicio){
        this.servicio = servicio;
        cuestionarios = new HashMap<Integer,Test>();
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
    private String cargarPregunta(String tipo, int id, String opcion)
    {
        Test test = obtenerTest(id, tipo);
        if(opcion != null)
        {
            test.ActualizarPregunta(Integer.parseInt(opcion));
            servicio.actualizarTest(test);
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

    private Test crearCuestionario(int id, String tipo){
        Test test = servicio.CrearTest(tipo, id);
        cuestionarios.put(id,test);
        return test;
    }

    private Test obtenerTest(int id, String tipo){
        Test test = cuestionarios.get(id);
        //Cargamos el test en memoria para tenerlo disponible
        if(test == null){
            test = servicio.CargarTest(id, tipo);
        }
        if(test == null){
            test = crearCuestionario( id,  tipo);
        }
        return test;
    }

}