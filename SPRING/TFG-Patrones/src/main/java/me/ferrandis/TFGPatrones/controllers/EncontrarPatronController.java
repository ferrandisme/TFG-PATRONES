package me.ferrandis.TFGPatrones.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Controller
public class EncontrarPatronController {

    @GetMapping("/encontrarPatron")
    public String informacionPrincipal(Model model) {
        Random rand = new Random();
        long randomNum = rand.nextInt((Integer.MAX_VALUE));
        //model.addAttribute("iduser", UUID.randomUUID());
        return "redirect:/test/" + randomNum;
    }
}