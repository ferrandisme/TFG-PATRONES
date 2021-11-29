package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;
import me.ferrandis.TFGPatrones.service.CuestionarioServicioImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class CuestionarioEncontrarPatronController {

    private final CuestionarioServicioImp servicio;

    public CuestionarioEncontrarPatronController(CuestionarioServicioImp servicio){
        this.servicio = servicio;
    }

    @GetMapping("/test/{id}")
    public String iniciarTest(@PathVariable("id") String id , @RequestParam(required = false, name = "opcion") Integer opcion , Model model) {

        DTOEstadoCuestionario estado = servicio.getSiguientePregunta(id,opcion);
        return procesarResultado(estado,model);
    }

    private String procesarResultado(DTOEstadoCuestionario estado, Model model){
        if(!estado.isAcabado()){
            model.addAttribute("pregunta", estado.getTexto());
            return "test-encontrar-patron";
        }
        else if(estado.isSolucionado()){
            return "redirect:/patron?n=" + estado.getTexto();
        }
        else{
            model.addAttribute("solucion",estado.getTexto());
            return "resultados";
        }
    }
}