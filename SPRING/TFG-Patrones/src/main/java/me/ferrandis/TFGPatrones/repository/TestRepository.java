package me.ferrandis.TFGPatrones.repository;

import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Cuestionario, String> {
}
