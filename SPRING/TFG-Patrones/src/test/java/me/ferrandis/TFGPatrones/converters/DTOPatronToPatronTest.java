package me.ferrandis.TFGPatrones.converters;
import static org.junit.jupiter.api.Assertions.*;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DTOPatronToPatronTest {

    public DTOPatron dtoPatron;
    public DTOPatronToPatron dtoPatronToPatron;


    @BeforeEach
    public void setUp(){
        dtoPatronToPatron = new DTOPatronToPatron();
    }

    @Test
    public void testNullObject(){
        dtoPatron = null;
        assertNull(dtoPatronToPatron.convert(dtoPatron));
    }

    @Test
    public void testEmptyObject(){
        dtoPatron = new DTOPatron();
        assertNotNull(dtoPatronToPatron.convert(dtoPatron));
    }

    @Test
    public void testConvert(){
        dtoPatron = new DTOPatron();
        dtoPatron.setResumen("Nombre");
        dtoPatron.setResumen("Resumen");
        List<String> urlImagenes = new ArrayList<>();
        urlImagenes.add("TextoDeURL1");
        urlImagenes.add("TextoDeURL2");
        dtoPatron.setURLImagenes(urlImagenes);
        List<String> textoExplicacion = new ArrayList<>();
        textoExplicacion.add("Explicacion1");
        textoExplicacion.add("Explicacion2");
        Patron patron = dtoPatronToPatron.convert(dtoPatron);

        assertEquals(patron.getNombre(), dtoPatron.getNombre());
        assertEquals(patron.getResumen(), dtoPatron.getResumen());
        assertEquals(patron.getTextoExplicacion(), dtoPatron.getTextoExplicacion());
        assertEquals(patron.getURLImagenes(), dtoPatron.getURLImagenes());
    }
}
