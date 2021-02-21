package me.ferrandis.TFGPatrones.api;

import me.ferrandis.TFGPatrones.modelo.Patron;
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



    @GetMapping("/testEstructural/{id}")
    public String iniciarEstructural(@PathVariable("id") String id , Model model) {
        return "test-encontrar-patron";
    }

    @GetMapping("/testCreacional/{id}")
    public String iniciarCreacional(@PathVariable("id") String id , Model model) {
        return "test-encontrar-patron";
    }

    @GetMapping("/testComportamiento/{id}")
    public String iniciarComportamiento(@PathVariable("id") String id , Model model) {
        return "test-encontrar-patron";
    }
}
