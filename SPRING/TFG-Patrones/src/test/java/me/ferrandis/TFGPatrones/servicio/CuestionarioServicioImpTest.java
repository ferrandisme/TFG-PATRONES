package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.Pregunta;
import me.ferrandis.TFGPatrones.repository.CuestionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CuestionarioServicioImpTest {

    private final String PATRON_1 = "Patron1";
    private final String PATRON_2 = "Patron2";

    private CuestionarioServicioImp servicio;

    @Mock
    private  CuestionarioRepository cuestionarioRepository;
    @Mock
    private  PreguntasServicio preguntasServicio;

    @BeforeEach
    void setUp() {
         servicio = new CuestionarioServicioImp(cuestionarioRepository,preguntasServicio);
    }

    @Test
    void getSiguientePreguntaAcabado() {
        //GIVEN
        String id1 = "1";

        //datos cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(id1);
        cuestionario.setEncontrado(false);
        List<Pregunta > preguntas = new ArrayList<Pregunta>();
        cuestionario.setPreguntas(preguntas);
        Mockito.when(cuestionarioRepository.findById(id1)).thenReturn(Optional.of(cuestionario));

        //WHEN
        DTOEstadoCuestionario result1 = servicio.getSiguientePregunta(id1  , 1);

        //THEN
        assertEquals(true, result1.isAcabado());
        assertEquals(false, result1.isSolucionado());
    }

    @Test
    void getSiguientePreguntaNoAcabado() {
        //GIVEN
        String id1 = "1";
        String resultado = "Resultado";

        //datos cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(id1);
        List<Pregunta > preguntas = new ArrayList<Pregunta>();
        Pregunta p = new Pregunta();
        p.setTexto(resultado);
        preguntas.add(p);
        cuestionario.setPreguntas(preguntas);
        Mockito.when(cuestionarioRepository.findById(id1)).thenReturn(Optional.of(cuestionario));

        //WHEN
        DTOEstadoCuestionario result1 = servicio.getSiguientePregunta(id1  , null);

        //THEN
        assertEquals(false, result1.isAcabado());
        assertEquals(false, result1.isSolucionado());
        assertEquals(resultado , result1.getTexto());
    }

    @Test
    void getSiguientePreguntaTipo() {
        //GIVEN
        String id1 = "1";
        String resultado = "Resultado";
        String tipo = "tipo";

        //datos cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(id1);
        List<Pregunta > preguntas = new ArrayList<Pregunta>();
        Pregunta p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{CuestionarioServicio.TIPO + tipo, "" , "" , "" , ""}));
        p.setTexto(resultado);
        preguntas.add(p);
        cuestionario.setPreguntas(preguntas);

        List<Pregunta > preguntas2 = new ArrayList<Pregunta>();
        Pregunta p2 = new Pregunta();
        p2.setTexto(resultado);
        preguntas2.add(p2);
        Mockito.when(cuestionarioRepository.findById(id1)).thenReturn(Optional.of(cuestionario));
        Mockito.when(preguntasServicio.getPreguntasTipo(Mockito.any())).thenReturn(preguntas2);
        Mockito.when(cuestionarioRepository.save(Mockito.any())).thenReturn(cuestionario);

        //WHEN
        DTOEstadoCuestionario result1 = servicio.getSiguientePregunta(id1  , 1);

        //THEN
        Mockito.verify(cuestionarioRepository,Mockito.times(1)).save(Mockito.any());
        Mockito.verify(preguntasServicio,Mockito.times(1)).getPreguntasTipo(tipo);

        assertEquals(false, result1.isAcabado());
        assertEquals(false, result1.isSolucionado());
        assertEquals(resultado, result1.getTexto());
    }

    @Test
    void getSiguientePreguntaEliminar() {
        //GIVEN
        String id1 = "1";
        String resultado = "Resultado";
        String tipo = "tipo";
        String tipo2 = "tipo2";
        //datos cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(id1);
        List<Pregunta > preguntas = new ArrayList<Pregunta>();
        Pregunta p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{CuestionarioServicio.ELIMINAR + tipo, "" , "" , "" , ""}));
        preguntas.add(p);

        p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{CuestionarioServicio.SOLUCION + tipo2, "" , "" , "" , ""}));
        p.setTexto(resultado);
        preguntas.add(p);

        cuestionario.setPreguntas(preguntas);
        Mockito.when(cuestionarioRepository.findById(id1)).thenReturn(Optional.of(cuestionario));
        //WHEN
        DTOEstadoCuestionario result1 = servicio.getSiguientePregunta(id1  , 1);

        //THEN
        assertEquals(1,cuestionario.getPreguntas().size());
        assertEquals(false, result1.isAcabado());
        assertEquals(false, result1.isSolucionado());
        assertEquals(resultado,result1.getTexto());
    }


    @Test
    void getSiguientePreguntaSolucion() {
        //GIVEN
        String id1 = "1";
        String resultado = "Resultado";
        String tipo = "tipo";
        //datos cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(id1);
        List<Pregunta > preguntas = new ArrayList<Pregunta>();
        Pregunta p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{CuestionarioServicio.SOLUCION + tipo, "" , "" , "" , ""}));
        preguntas.add(p);

        cuestionario.setPreguntas(preguntas);
        Mockito.when(cuestionarioRepository.findById(id1)).thenReturn(Optional.of(cuestionario));
        //WHEN
        DTOEstadoCuestionario result1 = servicio.getSiguientePregunta(id1  , 1);

        //THEN
        assertEquals(0,cuestionario.getPreguntas().size());
        assertEquals(true, result1.isAcabado());
        assertEquals(true, result1.isSolucionado());
        assertEquals(tipo,result1.getTexto());
    }

    @Test
    void eliminar(){
        //GIVEN
        //opciones
        String accion  = CuestionarioServicio.ELIMINAR + PATRON_1;
        String eliminar = CuestionarioServicio.ELIMINAR + PATRON_2;
        String solucion  = CuestionarioServicio.SOLUCION + PATRON_1;
        String solucion2  = CuestionarioServicio.SOLUCION + PATRON_2;

        //preguntas
        List<Pregunta > preguntas = new ArrayList<Pregunta>();
        Pregunta p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{accion, "" , "" , "" , solucion}));
        preguntas.add(p);
        p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{accion, eliminar , "" , "" , solucion}));
        preguntas.add(p);
        p = new Pregunta();
        p.setResultado(Arrays.asList(new String[]{accion, "" , solucion2 , "" , solucion}));
        preguntas.add(p);

        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setPreguntas(preguntas);

        //WHEN
        servicio.eliminar(accion, preguntas, cuestionario);

        //THEN
        preguntas = cuestionario.getPreguntas();
        assertEquals(2 ,preguntas.size());

        assertEquals("" ,preguntas.get(0).getResultado().get(0));
        assertEquals(eliminar ,preguntas.get(0).getResultado().get(1));
        assertEquals("" ,preguntas.get(0).getResultado().get(2));
        assertEquals("" ,preguntas.get(0).getResultado().get(4));
        assertEquals("" ,preguntas.get(0).getResultado().get(3));

        assertEquals("" ,preguntas.get(1).getResultado().get(0));
        assertEquals("" ,preguntas.get(1).getResultado().get(1));
        assertEquals(solucion2 ,preguntas.get(1).getResultado().get(2));
        assertEquals("" ,preguntas.get(1).getResultado().get(4));
        assertEquals("" ,preguntas.get(1).getResultado().get(3));
    }
}