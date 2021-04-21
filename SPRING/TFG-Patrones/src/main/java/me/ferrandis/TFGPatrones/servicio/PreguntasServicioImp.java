package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.modelo.Pregunta;
import me.ferrandis.TFGPatrones.repository.PreguntaRepository;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PreguntasServicioImp implements PreguntasServicio{

    private final PreguntaRepository preguntaRepository;

    public PreguntasServicioImp(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<Pregunta> getPreguntasTipo(String tipo) {
        List<Pregunta> preguntas = preguntaRepository.findAllByTipo(tipo);
        preguntas.sort(Pregunta::compareTo);
        return preguntas;
    }
}
