package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.model.Cuestionario;
import org.springframework.stereotype.Component;

@Deprecated
@Component
public class DTOCuestionarioToCuestionario {

    public static Cuestionario convert(DTOCuestionario dtoCuestionario) {
        if(dtoCuestionario == null)
            return null;
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(dtoCuestionario.getID());
        //cuestionario.setPreguntas(dtoCuestionario.getPreguntas());
        cuestionario.setVersionPreguntas(dtoCuestionario.getVersionPreguntas());
        cuestionario.setFinalizado(dtoCuestionario.isFinalizado());
        return cuestionario;
    }

}





