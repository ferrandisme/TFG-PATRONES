package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOTest;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestToDTOTest implements Converter<Test, DTOTest> {

    @Override
    public DTOTest convert(Test test) {
        if(test == null)
            return null;
        DTOTest dtoTest = new DTOTest();
        dtoTest.setID(test.getID());
        dtoTest.setPreguntaActual(test.getPreguntaActual());
        dtoTest.setTipo(test.getTipo());
        dtoTest.setOrdenRespuestas(test.getOrdenRespuestas());
        dtoTest.setPreguntas(inicializarPreguntas(test.getTipo()));
        dtoTest.setVersionPreguntas(test.getVersionPreguntas());
        dtoTest.setPuntuaciones(test.getPuntuaciones());
        dtoTest.setItem(test.getItem());
        return dtoTest;
    }

    private List<ItemTest> inicializarPreguntas(String tipo){
        switch(tipo){
            case "estructural":
                return ItemTest.getTestEstructurales();
            case "creacional":
                return ItemTest.getTestCreacionales();
            default:
                return ItemTest.getTestEstructurales();
        }
    }
}
