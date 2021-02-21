package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class TestEncontrarPatronController {

    @GetMapping("/Encontrarpatron")
    public String getPreguntaPatron(@RequestParam("id") String n, Model model) {
        return "principal";
    }
}
