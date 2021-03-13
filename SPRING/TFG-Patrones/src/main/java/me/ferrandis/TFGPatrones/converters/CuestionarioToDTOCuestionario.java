package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CuestionarioToDTOCuestionario implements Converter<Cuestionario, DTOCuestionario> {

    @Override
    public DTOCuestionario convert(Cuestionario cuestionario) {
        if(cuestionario == null)
            return null;
        DTOCuestionario dtoCuestionario = new DTOCuestionario();
        dtoCuestionario.setID(cuestionario.getID());
        dtoCuestionario.setPreguntaActual(cuestionario.getPreguntaActual());
        dtoCuestionario.setTipo(cuestionario.getTipo());
        dtoCuestionario.setOrdenRespuestas(cuestionario.getOrdenRespuestas());
        dtoCuestionario.setPreguntas(inicializarPreguntas(cuestionario.getTipo()));
        dtoCuestionario.setVersionPreguntas(cuestionario.getVersionPreguntas());
        dtoCuestionario.setPuntuaciones(cuestionario.getPuntuaciones());
        dtoCuestionario.setItem(cuestionario.getItem());
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
