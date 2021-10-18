package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.service.PatronesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class PatronController {

    private final PatronesServicio patronesServicio;

    @Autowired
    public PatronController(PatronesServicio servicio){this.patronesServicio = servicio;}


    @GetMapping("/patron")
    public String getPatron(@RequestParam("n") String n, Model model) {

        DTOPatron patron;

        try {
            patron = patronesServicio.findById(n);
        }
        catch(Exception e){
            patron = new DTOPatron();
            patron.setNombre("Error");
            patron.setResumen(e.getMessage());
            patron.setTextoExplicacion(new ArrayList<>());
            patron.setURLImagenes(new ArrayList<>());
        }
        model.addAttribute("patron", patron);
        model.addAttribute("descripciones", patron.getTextoExplicacion());
        model.addAttribute("imagenes", patron.getURLImagenes());
        model.addAttribute("documentacion", patron.getDocumentacion());
        model.addAttribute("sinergias", patron.getSinergias());

        List<String> nombreDocumentacion = new ArrayList<>();

        if(patron.getDocumentacion() != null) {
            for (String url : patron.getDocumentacion()) {
                String formated = StringUtils.split(url, ".")[StringUtils.split(url, ".").length - 2];
                if (formated.contains("/")) {
                    formated = StringUtils.split(formated, "//")[1];
                }
                formated = StringUtils.capitalize(formated);

                if(formated.trim().equalsIgnoreCase("refactoring")){
                    formated = "Refactoring Guru";
                }
                nombreDocumentacion.add(formated);

            }
        }
        model.addAttribute("nombreDocumentacion",nombreDocumentacion);


        return "patron";
    }
}
