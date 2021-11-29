package me.ferrandis.TFGPatrones.controllers.admin;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOInformacionAdmin;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import me.ferrandis.TFGPatrones.service.PatronesServicio;
import me.ferrandis.TFGPatrones.service.PreguntasServicio;
import me.ferrandis.TFGPatrones.utils.ParserAdminUtil;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
public class AdminModificadorController {


    private final PreguntasServicio preguntasServicio;
    private final PatronesServicio patronesServicio;


    public AdminModificadorController (PreguntasServicio preguntasServicio, PatronesServicio patronesServicio){
        this.preguntasServicio = preguntasServicio;
        this.patronesServicio = patronesServicio;
    }



    @GetMapping("/admin/cuestionario")
    public String obtenerCuestionario(Model model) {
        List<DTOPregunta> preguntas = preguntasServicio.getTodasPreguntas();
        String preguntasConvertidas = ParserAdminUtil.obtenerPreguntas(preguntas);
        DTOInformacionAdmin info = new DTOInformacionAdmin();
        info.setTexto(preguntasConvertidas);
        model.addAttribute("dtoinformacionadmin" ,info );
        return "admin/preguntas";
    }

    @PostMapping("/admin/cuestionario")
    public String actualizarPreguntas(@ModelAttribute("dtoinformacionadmin") DTOInformacionAdmin dtoinformacionadmin){
            if (dtoinformacionadmin == null) {
                throw new RuntimeException();
            } else {
                //Actualizar Preguntas
                List<DTOPregunta> preguntas = ParserAdminUtil.procesarPreguntas(dtoinformacionadmin.getTexto());
                preguntasServicio.updateAndRemove(preguntas);
                //Cargar preguntas
                preguntas = preguntasServicio.getTodasPreguntas();
                String preguntasConvertidas = ParserAdminUtil.obtenerPreguntas(preguntas);
                DTOInformacionAdmin info = new DTOInformacionAdmin();
                info.setTexto(preguntasConvertidas);
              return  "admin/preguntas";
            }
    }

    @GetMapping("/admin/patrones")
    public String obtenerPatrones(Model model) {
        List<DTOPatron> patrones = patronesServicio.getPatrones();
        String patronesConvertidos = ParserAdminUtil.obtenerPatrones(patrones);
        DTOInformacionAdmin info = new DTOInformacionAdmin();
        info.setTexto(patronesConvertidos);
        model.addAttribute("dtoinformacionadmin" ,info );
        return "admin/patrones";
    }

    @GetMapping("/admin/configuracion")
    public String obtenerConfiguracion(Model model) {
        return "admin/configuracion";
    }

}
