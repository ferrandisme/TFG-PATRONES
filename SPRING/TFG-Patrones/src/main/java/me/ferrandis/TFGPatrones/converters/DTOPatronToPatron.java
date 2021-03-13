package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DTOPatronToPatron implements Converter<DTOPatron, Patron> {
    @Override
    public Patron convert(DTOPatron dtopatron) {
        if(dtopatron == null)
            return null;
        Patron patron = new Patron();
        patron.setNombre(dtopatron.getNombre());
        patron.setTextoExplicacion(dtopatron.getTextoExplicacion());
        patron.setURLImagenes(dtopatron.getURLImagenes());
        patron.setResumen(dtopatron.getResumen());
        return patron;
    }
}
