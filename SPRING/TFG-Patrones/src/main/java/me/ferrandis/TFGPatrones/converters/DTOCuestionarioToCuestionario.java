package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DTOCuestionarioToCuestionario {

    public static Cuestionario convert(DTOCuestionario dtoCuestionario) {
        if(dtoCuestionario == null)
            return null;
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(dtoCuestionario.getID());
        cuestionario.setPreguntas(dtoCuestionario.getPreguntas());
        cuestionario.setVersionPreguntas(dtoCuestionario.getVersionPreguntas());
        cuestionario.setFinalizado(dtoCuestionario.isFinalizado());
        return cuestionario;
    }

}





