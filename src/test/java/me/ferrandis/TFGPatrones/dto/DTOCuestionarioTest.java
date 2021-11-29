package me.ferrandis.TFGPatrones.dto;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.model.ItemCuestionario;

import java.util.List;

public class DTOCuestionarioTest {

    DTOCuestionario dtoCuestionario;
    List<ItemCuestionario> preguntas = ItemCuestionario.getTestEstructurales();
/*
    @BeforeEach
    public void setUp(){
        dtoCuestionario = new DTOCuestionario();

        dtoCuestionario.setID("dtoCuestionarioPrueba");
        dtoCuestionario.setPreguntaActual(0);
        dtoCuestionario.setTipo("estructural");
        dtoCuestionario.setOrdenRespuestas(new ArrayList<>());
        dtoCuestionario.setPreguntas(preguntas);
        dtoCuestionario.setVersionPreguntas(-1);
        dtoCuestionario.setPuntuaciones(new ArrayList<>());
        dtoCuestionario.setItem(0);
    }

    @Test
    public void incrementoValores(){
        String pregunta = dtoCuestionario.SiguientePregunta();
        String pregunta2 = dtoCuestionario.SiguientePregunta();
        assertEquals(pregunta,pregunta2); //Si no se actualiza la pregunta, la pregunta sigue siendo la misma
        assertEquals(pregunta,preguntas.get(0).getPregunta(0));
    }


    @Test
    public void siguientePregunta(){
        String pregunta = dtoCuestionario.SiguientePregunta();
        dtoCuestionario.ActualizarPregunta(1);
        String pregunta2 = dtoCuestionario.SiguientePregunta();
        assertNotEquals(pregunta,pregunta2);
        assertEquals(pregunta,preguntas.get(0).getPregunta(0));
        assertEquals(pregunta2,preguntas.get(0).getPregunta(1));
    }*/
}
