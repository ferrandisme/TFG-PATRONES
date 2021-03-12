package me.ferrandis.TFGPatrones.servicio;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.dao.BDPatrones;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatronesServicioImp implements PatronesServicio{

    private final PatronRepository patronRepository;

    public PatronesServicioImp(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Override
    public List<Patron> getPatrones() {
        List<Patron> patrones = new ArrayList<>();
        patronRepository.findAll().iterator().forEachRemaining(patrones::add);
        return patrones;
    }

    @Override
    public Patron findById(String id) throws Exception {
        Optional<Patron> patron = patronRepository.findById(id);

        if(!patron.isPresent())
            throw new Exception("No se ha encontrado el patron");

        return patron.get();
    }

    @Override
    public Patron savePatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public void deleteById(String id) {
        patronRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        patronRepository.deleteAll();
    }
}
