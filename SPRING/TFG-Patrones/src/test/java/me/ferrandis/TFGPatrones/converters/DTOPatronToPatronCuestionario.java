package me.ferrandis.TFGPatrones.converters;
import static org.junit.jupiter.api.Assertions.*;
import me.ferrandis.TFGPatrones.DTO.DTOPatron;
import me.ferrandis.TFGPatrones.model.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DTOPatronToPatronCuestionario {

    public DTOPatron dtoPatron;
    public DTOPatronToPatron dtoPatronToPatron;


    @BeforeEach
    public void setUp(){
        dtoPatronToPatron = new DTOPatronToPatron();
    }

    @Test
    public void testNullObject(){
        assertNull(dtoPatronToPatron.convert(null));
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
        dtoPatron.setTextoExplicacion(textoExplicacion);
        List<String> documentacion = new ArrayList<>();
        documentacion.add("Explicacion1");
        documentacion.add("Explicacion2");
        dtoPatron.setDocumentacion(documentacion);
        List<String> sinergias = new ArrayList<>();
        sinergias.add("Explicacion1");
        sinergias.add("Explicacion2");
        dtoPatron.setSinergias(sinergias);

        Patron patron = dtoPatronToPatron.convert(dtoPatron);

        assertEquals(patron.getNombre(), dtoPatron.getNombre());
        assertEquals(patron.getResumen(), dtoPatron.getResumen());
        assertEquals(patron.getTextoExplicacion(), dtoPatron.getTextoExplicacion());
        assertEquals(patron.getURLImagenes(), dtoPatron.getURLImagenes());
        assertEquals(patron.getDocumentacion(), dtoPatron.getDocumentacion());
        assertEquals(patron.getSinergias(), dtoPatron.getSinergias());
    }
}
