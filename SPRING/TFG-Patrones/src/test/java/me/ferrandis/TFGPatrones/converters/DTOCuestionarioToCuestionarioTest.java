package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.ItemCuestionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DTOCuestionarioToCuestionarioTest {

    public DTOCuestionario dtoCuestionario;
    public  DTOCuestionarioToCuestionario dtoCuestionarioToCuestionario;


    @BeforeEach
    public void setUp(){
        dtoCuestionarioToCuestionario = new DTOCuestionarioToCuestionario();
    }

    @Test
    public void testNullObject(){
        assertNull(dtoCuestionarioToCuestionario.convert(null));
    }

    @Test
    public void testEmptyObject(){
        dtoCuestionario = new DTOCuestionario();
        assertNotNull(dtoCuestionarioToCuestionario.convert(dtoCuestionario));
    }

    @Test
    public void testConvert(){

        assertTrue(false);
        /*dtoCuestionario = new DTOCuestionario();
        dtoCuestionario.setTipo("estructural");
        dtoCuestionario.setItem(2);
        List<Float> puntuaciones = new ArrayList<>();
        puntuaciones.add(3f);
        dtoCuestionario.setPuntuaciones(puntuaciones);
        dtoCuestionario.setID(UUID.randomUUID().toString());
        dtoCuestionario.setVersionPreguntas(0);
        List<Integer> ordenRespuestas = new ArrayList<>();
        ordenRespuestas.add(3);
        dtoCuestionario.setOrdenRespuestas(ordenRespuestas);
        dtoCuestionario.setPreguntaActual(3);
        List<ItemCuestionario> lista = new ArrayList<>();
        dtoCuestionario.setPreguntas(lista);

        Cuestionario cuestionario = dtoCuestionarioToCuestionario.convert(dtoCuestionario);

        assertEquals(dtoCuestionario.getID(), cuestionario.getID());
        assertEquals(dtoCuestionario.getItem(), cuestionario.getItem());
        assertEquals(dtoCuestionario.getTipo(), cuestionario.getTipo());
        assertEquals(dtoCuestionario.getPuntuaciones(), cuestionario.getPuntuaciones());
        assertEquals(dtoCuestionario.getVersionPreguntas(), cuestionario.getVersionPreguntas());
        assertEquals(dtoCuestionario.getID(), cuestionario.getID());
        assertEquals(dtoCuestionario.getOrdenRespuestas(), cuestionario.getOrdenRespuestas());
        assertEquals(dtoCuestionario.getPreguntaActual(), cuestionario.getPreguntaActual());*/
    }
}
