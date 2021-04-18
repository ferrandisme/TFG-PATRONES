package me.ferrandis.TFGPatrones.repository;

import me.ferrandis.TFGPatrones.modelo.Pregunta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PreguntaRepository extends CrudRepository<Pregunta, String> {

    List<Pregunta> findAllByTipo(String tipo);
}