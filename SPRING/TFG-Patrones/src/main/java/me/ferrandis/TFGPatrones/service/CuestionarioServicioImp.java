package me.ferrandis.TFGPatrones.service;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;
import me.ferrandis.TFGPatrones.converters.DTOCuestionarioToCuestionario;
import me.ferrandis.TFGPatrones.converters.CuestionarioToDTOCuestionario;
import me.ferrandis.TFGPatrones.model.Cuestionario;
import me.ferrandis.TFGPatrones.model.Pregunta;
import me.ferrandis.TFGPatrones.repository.CuestionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class CuestionarioServicioImp implements CuestionarioServicio {

    private final CuestionarioRepository cuestionarioRepository;
    private final PreguntasServicio preguntasServicio;

    public CuestionarioServicioImp(CuestionarioRepository cuestionarioRepository, PreguntasServicio preguntasServicio) {
        this.cuestionarioRepository = cuestionarioRepository;
        this.preguntasServicio = preguntasServicio;
    }


    @Override
    public List<DTOCuestionario> getTest() {
        List<DTOCuestionario> tests = new ArrayList<>();
        Iterator<Cuestionario> resultados =  cuestionarioRepository.findAll().iterator();
        while(resultados.hasNext()){
            tests.add( CuestionarioToDTOCuestionario.convert(resultados.next()));
        }
        return tests;
    }

    @Override
    public DTOCuestionario findById(String id) throws Exception {
        Optional<Cuestionario> testBusqueda = cuestionarioRepository.findById(id);

        if(!testBusqueda.isPresent())
            throw new Exception("No se ha encontrado el Test");

        DTOCuestionario test =  CuestionarioToDTOCuestionario.convert(testBusqueda.get());
        return test;
    }

    @Override
    public boolean existTest(String id){
        return cuestionarioRepository.findById(id).isPresent();
    }

    @Override
    public DTOCuestionario crearTest(String ID) {
        Cuestionario cuestionario = crearTestModelo(ID);
        DTOCuestionario dtoCuestionario = CuestionarioToDTOCuestionario.convert(cuestionarioRepository.save(cuestionario));
        return dtoCuestionario;
    }

    private Cuestionario crearTestModelo(String ID){
        if(cuestionarioRepository.findById(ID).isPresent()){
            return cuestionarioRepository.findById(ID).get();
        }
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(ID);
        cuestionario.setPreguntas(preguntasServicio.getPreguntasTipo(ENCONTRAR_TIPO));
        cuestionario.setRespuestas(new ArrayList<>());
        cuestionario.setVersionPreguntas(0);
        cuestionario.setFinalizado(false);
        cuestionario.setFechaCreacion(LocalDate.now());
        cuestionario.setResultado("");
        cuestionario.setEncontrado(false);
        return cuestionario;
    }

    @Override
    public void deleteById(String id) {
        cuestionarioRepository.deleteById(id);
    }

    @Override
    public DTOCuestionario saveTest(DTOCuestionario test) {
        Cuestionario cuestionarioConvertido = DTOCuestionarioToCuestionario.convert(test);
        return CuestionarioToDTOCuestionario.convert(cuestionarioRepository.save(cuestionarioConvertido));
    }

    @Override
    public void deleteAll() {
        cuestionarioRepository.deleteAll();
    }

    @Override
    public DTOEstadoCuestionario getSiguientePregunta(String id, Integer opcion) {
        Cuestionario cuestionario = crearTestModelo(id);
        List<Pregunta> preguntas = cuestionario.getPreguntas();
        DTOEstadoCuestionario result = new DTOEstadoCuestionario();
        result.setAcabado(false);
        result.setSolucionado(false);

        if(preguntas == null || preguntas.size() == 0  || cuestionario.isFinalizado()){
            result.setAcabado(true);
            result.setSolucionado(cuestionario.isEncontrado());
            result.setTexto(cuestionario.getResultado());
            return result;
        }
        else if(opcion == null && preguntas.size() > 0){
            result.setTexto(preguntas.get(0).getTexto());
            return result;
        }

        opcion--; // 1-5 to 0-4
        String accion = preguntas.get(0).getResultado().get(opcion);
        preguntas.remove(0);
        cuestionario.setPreguntas(preguntas);
        if(accion.contains(TIPO)){
            cuestionario.setPreguntas(preguntasServicio.getPreguntasTipo(accion.replace(TIPO, "")));
            cuestionarioRepository.save(cuestionario);
            return getSiguientePregunta(id,null);
        }
        else if(accion.contains(ELIMINAR)){
            List<String> patronesAElimiar = Arrays.asList(accion.split(","));
            for(String patron : patronesAElimiar) {
                eliminar(patron, preguntas, cuestionario);
            }
            cuestionarioRepository.save(cuestionario);
            return getSiguientePregunta(id, null);
        }
        else if(accion.contains(SOLUCION)){
            cuestionario.setFinalizado(true);
            cuestionario.setPreguntas(new ArrayList<>());
            cuestionario.setEncontrado(true);
            result.setTexto(accion.replace(SOLUCION, ""));
            result.setAcabado(true);
            result.setSolucionado(true);
        }
        else{
            //No actions for this solution
            cuestionarioRepository.save(cuestionario);
            return getSiguientePregunta(id,null);
        }
        cuestionarioRepository.save(cuestionario);
        return result;
    }

    public void eliminar(String accion, List<Pregunta> preguntas, Cuestionario cuestionario){
        String patronAEliminar = accion.replace(ELIMINAR, "");
        List<Pregunta> nuevasPreguntas = new ArrayList<>();
        for(Pregunta pregunta : preguntas){
            boolean otrosResultados = false;
            List<String> resultados = pregunta.getResultado();
            for(int i = 0; i < 5; i++){
                String accionPregunta = resultados.get(i);
                if(accionPregunta.contains(SOLUCION)){
                    if(accionPregunta.replace(SOLUCION,"").equals(patronAEliminar)){
                        pregunta.getResultado().set(i,"");
                    }
                    else{
                        otrosResultados = true;
                    }
                }else if(accionPregunta.contains(ELIMINAR)){
                    if( !accion.equals(accionPregunta))
                        otrosResultados = true;
                    else
                        pregunta.getResultado().set(i,"");
                }
            }
            if(otrosResultados){
                nuevasPreguntas.add(pregunta);
            }
        }
        cuestionario.setPreguntas(nuevasPreguntas);
    }

}
