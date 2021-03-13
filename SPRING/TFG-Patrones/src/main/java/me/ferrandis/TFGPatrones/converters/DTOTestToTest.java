package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DTOTestToTest implements Converter<DTOCuestionario, Test> {

    @Override
    public Test convert(DTOCuestionario dtoCuestionario) {
        if(dtoCuestionario == null)
            return null;
        Test test = new Test();
        test.setID(dtoCuestionario.getID());
        test.setPreguntaActual(dtoCuestionario.getPreguntaActual());
        test.setTipo(dtoCuestionario.getTipo());
        test.setOrdenRespuestas(dtoCuestionario.getOrdenRespuestas());
        //test.setPreguntas(dtoTest.getPreguntas());
        test.setVersionPreguntas(dtoCuestionario.getVersionPreguntas());
        test.setPuntuaciones(dtoCuestionario.getPuntuaciones());
        test.setItem(dtoCuestionario.getItem());
        return test;
    }

}





