package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class  PatronToDTOPatron{

    public static DTOPatron convert(Patron patron) {
        if(patron == null)
            return null;
        DTOPatron dtoPatron = new DTOPatron();
        dtoPatron.setNombre(patron.getNombre());
        dtoPatron.setTextoExplicacion(patron.getTextoExplicacion());
        dtoPatron.setURLImagenes(patron.getURLImagenes());
        dtoPatron.setResumen(patron.getResumen());
        dtoPatron.setDocumentacion(patron.getDocumentacion());
        dtoPatron.setSinergias(patron.getSinergias());
        return dtoPatron;
    }
}
