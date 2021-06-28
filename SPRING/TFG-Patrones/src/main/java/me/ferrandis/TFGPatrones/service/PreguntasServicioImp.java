package me.ferrandis.TFGPatrones.service;

import me.ferrandis.TFGPatrones.model.Pregunta;
import me.ferrandis.TFGPatrones.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntasServicioImp implements PreguntasServicio{

    private final PreguntaRepository preguntaRepository;

    public PreguntasServicioImp(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<Pregunta> getPreguntasTipo(String tipo) {
        List<Pregunta> preguntas = preguntaRepository.findAllByTipo(tipo.toUpperCase());
        preguntas.sort(Pregunta::compareTo);
        return preguntas;
    }
}
