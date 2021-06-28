package me.ferrandis.TFGPatrones.service;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.converters.DTOPatronToPatron;
import me.ferrandis.TFGPatrones.converters.PatronToDTOPatron;
import me.ferrandis.TFGPatrones.model.Patron;
import me.ferrandis.TFGPatrones.repository.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatronesServicioImp implements PatronesServicio{

    private final PatronRepository patronRepository;
    private final PatronToDTOPatron patronToDTOPatron;
    private final DTOPatronToPatron dtoPatronToPatron;

    public PatronesServicioImp(PatronRepository patronRepository , PatronToDTOPatron patronToDTOPatron, DTOPatronToPatron dtoPatronToPatron) {
        this.patronRepository = patronRepository;
        this.patronToDTOPatron = patronToDTOPatron;
        this.dtoPatronToPatron = dtoPatronToPatron;
    }

    @Override
    public List<DTOPatron> getPatrones() {
        List<DTOPatron> patrones = new ArrayList<>();
        Iterator<Patron> resultados =  patronRepository.findAll().iterator();
        while(resultados.hasNext()){
            patrones.add( patronToDTOPatron.convert(resultados.next()));
        }
        return patrones;
    }

    @Override
    public DTOPatron findById(String id) throws Exception {
        Optional<Patron> patron = patronRepository.findById(id);

        if(!patron.isPresent())
            throw new Exception("No se ha encontrado el patron");

        DTOPatron dtoPatron = patronToDTOPatron.convert(patron.get());
        return dtoPatron;
    }

    @Override
    public DTOPatron savePatron(DTOPatron patron) {
        Patron patronConvertido = dtoPatronToPatron.convert(patron);
        return patronToDTOPatron.convert( patronRepository.save(patronConvertido) );
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
