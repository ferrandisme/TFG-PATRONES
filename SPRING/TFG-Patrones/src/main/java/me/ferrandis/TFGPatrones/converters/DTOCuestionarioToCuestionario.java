package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DTOCuestionarioToCuestionario implements Converter<DTOCuestionario, Cuestionario> {

    @Override
    public Cuestionario convert(DTOCuestionario dtoCuestionario) {
        if(dtoCuestionario == null)
            return null;
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(dtoCuestionario.getID());
        cuestionario.setPreguntaActual(dtoCuestionario.getPreguntaActual());
        cuestionario.setTipo(dtoCuestionario.getTipo());
        cuestionario.setOrdenRespuestas(dtoCuestionario.getOrdenRespuestas());
        //test.setPreguntas(dtoTest.getPreguntas());
        cuestionario.setVersionPreguntas(dtoCuestionario.getVersionPreguntas());
        cuestionario.setPuntuaciones(dtoCuestionario.getPuntuaciones());
        cuestionario.setItem(dtoCuestionario.getItem());
        return cuestionario;
    }

}





