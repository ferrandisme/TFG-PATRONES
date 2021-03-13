package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOTest;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class TestToDTOTest implements Converter<Test, DTOTest> {

    @Override
    public DTOTest convert(Test test) {
        DTOTest dtoTest = new DTOTest();
        dtoTest.setID(test.getID());
        dtoTest.setPreguntaActual(test.getPreguntaActual());
        dtoTest.setID(test.getID());
        dtoTest.setTipo(test.getTipo());
        dtoTest.setOrdenRespuestas(test.getOrdenRespuestas());
        dtoTest.setPreguntas(inicializarPreguntas(test.getTipo()));
        dtoTest.setVersionPreguntas(test.getVersionPreguntas());
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
