package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.core.convert.converter.Converter;


@Deprecated
public class  PatronToDTOPatron implements Converter<Patron, DTOPatron> {

    @Override
    public DTOPatron convert(Patron patron) {
        DTOPatron dtoPatron = new DTOPatron();
        dtoPatron.setNombre(patron.getNombre());
        dtoPatron.setTextoExplicacion(patron.getTextoExplicacion());
        dtoPatron.setURLImagenes(patron.getURLImagenes());
        dtoPatron.setResumen(patron.getResumen());
        return dtoPatron;
    }
}
