package me.ferrandis.TFGPatrones.repository;

import me.ferrandis.TFGPatrones.model.Pregunta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreguntaRepository extends CrudRepository<Pregunta, String> {

    List<Pregunta> findAllByTipo(String tipo);
}