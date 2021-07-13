package me.ferrandis.TFGPatrones.controllers.admin;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import me.ferrandis.TFGPatrones.service.PreguntasServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;


@Slf4j
@Controller
public class AdminModificadorController {


    private final PreguntasServicio preguntasServicio;

    public AdminModificadorController (PreguntasServicio preguntasServicio){
        this.preguntasServicio = preguntasServicio;
    }

    @GetMapping("/admin/preguntas")
    public String obtenerPreguntas(Model model) {

        return "admin/preguntas";
    }

    @GetMapping("/admin/pregunta/{id}")
    public String editarOCrearPregunta(@PathVariable("id") String id, Model model) {
        List<DTOPregunta> preguntas = preguntasServicio.getTodasPreguntas();
        return "admin/preguntas";
    }
}
