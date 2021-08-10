package me.ferrandis.TFGPatrones.service;

import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import me.ferrandis.TFGPatrones.model.Pregunta;
import me.ferrandis.TFGPatrones.repository.PreguntaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntasServicioImp implements PreguntasServicio{

    private final ModelMapper modelMapper;
    private final PreguntaRepository preguntaRepository;

    public PreguntasServicioImp(PreguntaRepository preguntaRepository, ModelMapper modelMapper) {
        this.preguntaRepository = preguntaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DTOPregunta> getPreguntasTipo(String tipo) {
        List<Pregunta> preguntas = preguntaRepository.findAllByTipo(tipo.toUpperCase());
        preguntas.sort(Pregunta::compareTo);
        return toDTO(preguntas);
    }

    @Override
    public List<DTOPregunta> getTodasPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        preguntaRepository.findAll().forEach(preguntas :: add);
        preguntas.sort(Pregunta::compareTo);
        return toDTO(preguntas);
    }

    @Override
    @Transactional
    public void updateAndRemove(List<DTOPregunta> preguntas) {
        preguntaRepository.deleteAll();
        preguntaRepository.saveAll(toJPA(preguntas));
    }

    private List<DTOPregunta>  toDTO(List<Pregunta> preguntas) {
        return modelMapper.map(preguntas, new TypeToken<List<DTOPregunta>>() {}.getType());
    }

    private List<Pregunta>  toJPA(List<DTOPregunta> preguntas) {
        return modelMapper.map(preguntas, new TypeToken<List<Pregunta>>() {}.getType());
    }


}
