package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.ItemCuestionario;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CuestionarioToDTOCuestionario{

    public static DTOCuestionario convert(Cuestionario cuestionario) {
        if(cuestionario == null)
            return null;
        DTOCuestionario dtoCuestionario = new DTOCuestionario();
        dtoCuestionario.setID(cuestionario.getID());
        dtoCuestionario.setPreguntas(cuestionario.getPreguntas());
        dtoCuestionario.setVersionPreguntas(cuestionario.getVersionPreguntas());
        dtoCuestionario.setFinalizado(cuestionario.isFinalizado());
        return dtoCuestionario;
    }

}
