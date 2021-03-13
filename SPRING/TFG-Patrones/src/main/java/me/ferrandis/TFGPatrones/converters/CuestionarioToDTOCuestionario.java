package me.ferrandis.TFGPatrones.converters;


import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.ItemCuestionario;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    private List<ItemCuestionario> inicializarPreguntas(String tipo){
        if(tipo == null)
            return new ArrayList<>();

        switch(tipo){
            case "estructural":
                return ItemCuestionario.getTestEstructurales();
            case "creacional":
                return ItemCuestionario.getTestCreacionales();
            default:
                return ItemCuestionario.getTestEstructurales();
        }
    }
}
