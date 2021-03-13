package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOInfoCuestionario;
import me.ferrandis.TFGPatrones.servicio.CuestionarioServicioImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Slf4j
@Controller
public class CuestionarioEncontrarPatronController {

    private final CuestionarioServicioImp servicio;

    public CuestionarioEncontrarPatronController(CuestionarioServicioImp servicio){
        this.servicio = servicio;
    }

    @GetMapping("/testEstructural/{id}")
    public String iniciarEstructural(@PathVariable("id") String id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = cargarPregunta("estructural",id, opcion);
        return ProcesarResultados(pregunta, model, id, "estructural");
    }

    @GetMapping("/testCreacional/{id}")
    public String iniciarCreacional(@PathVariable("id") String id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = cargarPregunta("creacional",id, opcion);
        return ProcesarResultados(pregunta, model, id, "creacional");
    }

    @GetMapping("/testComportamiento/{id}")
    public String iniciarComportamiento(@PathVariable("id") String id , @RequestParam(required = false, name = "opcion") String opcion , Model model) {
        String pregunta = cargarPregunta("comportamiento",id, opcion);
        return ProcesarResultados(pregunta, model, id, "comportamiento");
    }

    //Intentara cargar una pregunta del test con dicha ID. Devolvera null en caso de no existir
    private String cargarPregunta(String tipo, String id, String opcion)
    {
        DTOCuestionario test = obtenerTest(id, tipo);
        if(opcion != null)
        {
            //System.out.println("Entro por aqui");
            test.ActualizarPregunta(Integer.parseInt(opcion));
            //servicio.actualizarTest(test);
            test = servicio.saveTest(test);
        }
        return test.SiguientePregunta();
    }

    private String ProcesarResultados(String pregunta, Model model, String id, String tipo){
        DTOCuestionario test = obtenerTest(id, tipo);
        if(pregunta == null){
            List<DTOInfoCuestionario> info = test.ObtenerResultados();
            model.addAttribute("patrones",info);
            return "resultados";
        }else{
            model.addAttribute("pregunta",pregunta);
            return "test-encontrar-patron";
        }
    }

    private DTOCuestionario obtenerTest(String id, String tipo){
        DTOCuestionario test = null;
        try {
            test = servicio.findById(id);
        } catch (Exception e) {
            System.out.println("Creando test");
            test = servicio.crearTest(tipo, id);
        }
        return test;
    }

}