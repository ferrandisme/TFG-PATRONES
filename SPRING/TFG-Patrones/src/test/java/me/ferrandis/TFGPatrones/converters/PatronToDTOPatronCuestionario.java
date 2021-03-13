package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatronToDTOPatronCuestionario {
    public Patron patron;
    public PatronToDTOPatron patronToDTOPatron;


    @BeforeEach
    public void setUp(){
        patronToDTOPatron = new PatronToDTOPatron();
    }

    @Test
    public void testNullObject(){
        patron = null;
        assertNull(patronToDTOPatron.convert(patron));
    }

    @Test
    public void testEmptyObject(){
        patron = new Patron();
        assertNotNull(patronToDTOPatron.convert(patron));
    }

    @Test
    public void testConvert(){
        patron = new Patron();
        patron.setResumen("Nombre");
        patron.setResumen("Resumen");
        List<String> urlImagenes = new ArrayList<>();
        urlImagenes.add("TextoDeURL1");
        urlImagenes.add("TextoDeURL2");
        patron.setURLImagenes(urlImagenes);
        List<String> textoExplicacion = new ArrayList<>();
        textoExplicacion.add("Explicacion1");
        textoExplicacion.add("Explicacion2");
        DTOPatron dtoPatron = patronToDTOPatron.convert(patron);

        assertEquals(patron.getNombre(), dtoPatron.getNombre());
        assertEquals(patron.getResumen(), dtoPatron.getResumen());
        assertEquals(patron.getTextoExplicacion(), dtoPatron.getTextoExplicacion());
        assertEquals(patron.getURLImagenes(), dtoPatron.getURLImagenes());
    }
}
