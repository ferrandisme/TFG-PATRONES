package me.ferrandis.TFGPatrones.utils;

import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import me.ferrandis.TFGPatrones.model.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserAdminUtilTest {

    private static final String TIPO = "TIPO";
    private static final String TEXTO = "TEXTO";
    private static final String ID = "ID";
    private static final List<String> RESULTADO = Arrays.asList("valor1", " ", "valor2");
    private static final Integer ORDEN = 3;

    private static final String TIPO_2 = "TIPO2";
    private static final String TEXTO_2 = "TEXTO2";
    private static final String ID_2 = "ID2";
    private static final List<String> RESULTADO_2 = Arrays.asList("", "", "valor5");
    private static final Integer ORDEN_2 = 9;

    @Test
    void obtenerPreguntas() {
        List<DTOPregunta> preguntas = new ArrayList<>();
        DTOPregunta pregunta = new DTOPregunta();
        DTOPregunta pregunta2 = new DTOPregunta();

        //pregunta.setID(ID);
        pregunta.setResultado(RESULTADO);
        pregunta.setTexto(TEXTO);
        pregunta.setOrden(ORDEN);
        pregunta.setTipo(TIPO);
        preguntas.add(pregunta);

        //pregunta2.setID(ID_2);
        pregunta2.setResultado(RESULTADO_2);
        pregunta2.setTexto(TEXTO_2);
        pregunta2.setOrden(ORDEN_2);
        pregunta2.setTipo(TIPO_2);
        preguntas.add(pregunta2);

           String parse =  ParserAdminUtil.obtenerPreguntas(preguntas);
           preguntas = ParserAdminUtil.procesarPreguntas(parse);

        assertEquals("1", preguntas.get(0).getID());
        assertEquals(pregunta.getResultado(), preguntas.get(0).getResultado());
        assertEquals(pregunta.getTexto(), preguntas.get(0).getTexto());
        assertEquals(pregunta.getOrden(), preguntas.get(0).getOrden());


        assertEquals("2", preguntas.get(1).getID());
        assertEquals(pregunta2.getResultado(), preguntas.get(1).getResultado());
        assertEquals(pregunta2.getTexto(), preguntas.get(1).getTexto());
        assertEquals(pregunta2.getOrden(), preguntas.get(1).getOrden());

    }
}