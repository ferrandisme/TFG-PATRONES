package me.ferrandis.TFGPatrones.utils;

import io.micrometer.core.instrument.util.StringUtils;
import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import me.ferrandis.TFGPatrones.model.Pregunta;

import java.util.*;
import java.util.stream.Collectors;

public class ParserAdminUtil {


    private static final String PREGUNTA = "<PREGUNTA>";
    private static final String FIN_LINEA = ";";
    private static final String SEPARADOR = "=";
    private static final String LISTA = "-";
    private static final String ID = "ID";
    private static final String ORDEN = "ORDEN";
    private static final String TEXTO = "TEXTO";
    private static final String TIPO = "TIPO";
    private static final String RESULTADO = "RESULTADO";
    private static final String SALTO = "\n";

    // De preguntas a usuario

    public static String obtenerPreguntas(List<DTOPregunta> preguntas){
        String result = "";
        for(DTOPregunta pregunta : preguntas){
            result += SALTO + PREGUNTA + SALTO;
            //result += construirLinea(ID, pregunta.getID());
            result += construirLinea(ORDEN, pregunta.getOrden().toString());
            result += construirLinea(TEXTO, pregunta.getTexto());
            result += construirLinea(RESULTADO, String.join(LISTA,pregunta.getResultado()));
            result += construirLinea(TIPO, pregunta.getTipo());
        }
        return result;
    }

    private static String construirLinea(String campo, String valor) {
        return campo.toUpperCase(Locale.ROOT) + SEPARADOR + valor +  FIN_LINEA + SALTO;
    }

    // De usuario a preguntas

    public static List<DTOPregunta> procesarPreguntas(String preguntasUsuario){
        List<DTOPregunta> result = new ArrayList<>();
        List<String> preguntas = Arrays.asList(preguntasUsuario.split(SALTO + PREGUNTA  + SALTO));
        Integer id = 1;
        for(String datos : preguntas){
            List<String> lineas = Arrays.asList(datos.split(FIN_LINEA + SALTO));
            if(lineas.size() >= 4){
                DTOPregunta pregunta = new DTOPregunta();
                /* String id = encontrarCampo(ID, lineas);
                if(StringUtils.isBlank(id) || id == null){
                }*/
                pregunta.setID((id++).toString());
                pregunta.setOrden(Integer.valueOf(encontrarCampo(ORDEN, lineas)));
                pregunta.setTexto(encontrarCampo(TEXTO, lineas));
                pregunta.setResultado(encontrarLista(RESULTADO, lineas));
                pregunta.setTipo(encontrarCampo(TIPO, lineas));
                result.add(pregunta);
            }
        }
        return result;
    }

    private static List<String> encontrarLista(String campo, List<String> lineas){
        String valor = encontrarCampo(campo,lineas);
        if(!StringUtils.isBlank(valor)){
            List<String> result = Arrays.asList(valor.split(LISTA));
            result.stream().map(String::trim).collect(Collectors.toList());
            return result;
        }
        return null;
    }

    private static String encontrarCampo(String campo, List<String> lineas){
        for(String linea : lineas){
            if(linea.split(SEPARADOR)[0].equalsIgnoreCase(campo)){
                return linea.split(SEPARADOR)[1].trim();
            }
        }
        return null;
    }
}
