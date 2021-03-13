package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuestionarioToDTOCuestionarioTest {

    public Cuestionario cuestionario;
    public CuestionarioToDTOCuestionario cuestionarioToDTOCuestionario;


    @BeforeEach
    public void setUp(){
        cuestionarioToDTOCuestionario = new CuestionarioToDTOCuestionario();
    }

    @Test
    public void testNullObject(){
        assertNull(cuestionarioToDTOCuestionario.convert(null));
    }

    @Test
    public void testEmptyObject(){
        cuestionario = new Cuestionario();
        assertNotNull(cuestionarioToDTOCuestionario.convert(cuestionario));
    }

    @Test
    public void testConvert(){

        cuestionario = new Cuestionario();
        cuestionario.setTipo("estructural");
        cuestionario.setItem(2);
        List<Float> puntuaciones = new ArrayList<>();
        puntuaciones.add(3f);
        cuestionario.setPuntuaciones(puntuaciones);
        cuestionario.setID(UUID.randomUUID().toString());
        cuestionario.setVersionPreguntas(0);
        List<Integer> ordenRespuestas = new ArrayList<>();
        ordenRespuestas.add(3);
        cuestionario.setOrdenRespuestas(ordenRespuestas);
        cuestionario.setPreguntaActual(3);

        DTOCuestionario dtoCuestionario = cuestionarioToDTOCuestionario.convert(cuestionario);

        assertEquals(dtoCuestionario.getID(), dtoCuestionario.getID());
        assertEquals(dtoCuestionario.getItem(), dtoCuestionario.getItem());
        assertEquals(dtoCuestionario.getTipo(), dtoCuestionario.getTipo());
        assertEquals(dtoCuestionario.getPuntuaciones(), dtoCuestionario.getPuntuaciones());
        assertEquals(dtoCuestionario.getVersionPreguntas(), dtoCuestionario.getVersionPreguntas());
        assertEquals(dtoCuestionario.getID(), dtoCuestionario.getID());
        assertEquals(dtoCuestionario.getOrdenRespuestas(), dtoCuestionario.getOrdenRespuestas());
        assertEquals(dtoCuestionario.getPreguntaActual(), dtoCuestionario.getPreguntaActual());
        assertTrue(dtoCuestionario.getPreguntas().size() > 0);

    }
}
