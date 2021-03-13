package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOTest;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;



public class DTOTestToTest implements Converter<DTOTest, Test> {

    @Override
    public Test convert(DTOTest dtoTest) {
        Test test = new Test();
        test.setID(dtoTest.getID());
        test.setPreguntaActual(dtoTest.getPreguntaActual());
        test.setID(dtoTest.getID());
        test.setTipo(dtoTest.getTipo());
        test.setOrdenRespuestas(dtoTest.getOrdenRespuestas());
        //test.setPreguntas(dtoTest.getPreguntas());
        test.setVersionPreguntas(dtoTest.getVersionPreguntas());
        return test;
    }

}





