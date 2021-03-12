package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOTest;
import me.ferrandis.TFGPatrones.Encapsulaciones.InfoTest;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.List;


@Deprecated
public class TestDTOToTest implements Converter<Test, DTOTest> {

    @Override
    public DTOTest convert(Test test) {
        DTOTest dtoTest = new DTOTest();
        dtoTest.setID(test.getID());
        dtoTest.setPreguntaActual(test.getPreguntaActual());
        dtoTest.setID(test.getID());
        dtoTest.setTipo(test.getTipo());
        dtoTest.setOrdenRespuestas(test.getOrdenRespuestas());
        //TODO migrar esto a la base de datos
        dtoTest.setPreguntas(ItemTest.getTestEstructurales());
        return dtoTest;
    }

}





