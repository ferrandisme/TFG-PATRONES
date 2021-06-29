package me.ferrandis.TFGPatrones.controllers;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggerGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class SecurityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);


    @GetMapping("/login")
    public String login( Model model) {
        return "admin/login";
    }

    @GetMapping("/admin")
    public String adminPannel( Model model) {
        return "admin/admin";
    }
}
