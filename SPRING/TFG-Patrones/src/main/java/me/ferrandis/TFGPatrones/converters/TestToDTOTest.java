package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestToDTOTest implements Converter<Test, DTOCuestionario> {

    @Override
    public DTOCuestionario convert(Test test) {
        if(test == null)
            return null;
        DTOCuestionario dtoCuestionario = new DTOCuestionario();
        dtoCuestionario.setID(test.getID());
        dtoCuestionario.setPreguntaActual(test.getPreguntaActual());
        dtoCuestionario.setTipo(test.getTipo());
        dtoCuestionario.setOrdenRespuestas(test.getOrdenRespuestas());
        dtoCuestionario.setPreguntas(inicializarPreguntas(test.getTipo()));
        dtoCuestionario.setVersionPreguntas(test.getVersionPreguntas());
        dtoCuestionario.setPuntuaciones(test.getPuntuaciones());
        dtoCuestionario.setItem(test.getItem());
        return dtoCuestionario;
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
