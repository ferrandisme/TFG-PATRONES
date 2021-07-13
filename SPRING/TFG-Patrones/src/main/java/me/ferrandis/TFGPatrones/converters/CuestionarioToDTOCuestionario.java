package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.model.Cuestionario;
import org.springframework.stereotype.Component;

@Deprecated
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
