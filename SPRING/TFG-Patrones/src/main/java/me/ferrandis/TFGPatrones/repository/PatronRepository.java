package me.ferrandis.TFGPatrones.repository;

import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatronRepository extends CrudRepository<Patron, String> {

    Optional<Patron> findByNombre(String nombre);
}
