package me.ferrandis.TFGPatrones.servicio;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import me.ferrandis.TFGPatrones.converters.DTOCuestionarioToCuestionario;
import me.ferrandis.TFGPatrones.converters.CuestionarioToDTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.modelo.Pregunta;
import me.ferrandis.TFGPatrones.repository.CuestionarioRepository;
import me.ferrandis.TFGPatrones.repository.PreguntaRepository;
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
        cuestionario.setVersionPreguntas(0);
        cuestionario.setFinalizado(false);
        cuestionario.setFechaCreacion(LocalDate.now());
        //TODO crear preguntas
        //cuestionario.setPreguntas();
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
    public String getSiguientePregunta(String id, Integer opcion) {
        Cuestionario cuestionario = crearTestModelo(id);
        List<Pregunta> preguntas = cuestionario.getPreguntas();

        if(opcion == null && preguntas.size() > 0){
            return preguntas.get(0).getTexto();
        }
        String accion = preguntas.get(0).getResultado().get(opcion);
        if(accion.contains(TIPO)){
            cuestionario.setPreguntas(preguntasServicio.getPreguntasTipo(accion.replace(TIPO, "").toLowerCase()));
        }

        preguntas.remove(0);
        if(accion.contains(SOLUCION)){
            cuestionario.setFinalizado(true);
            cuestionario.setPreguntas(new ArrayList<>());
        }

        return null;
    }

}
