package me.ferrandis.TFGPatrones.servicio;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.converters.DTOCuestionarioToCuestionario;
import me.ferrandis.TFGPatrones.converters.CuestionarioToDTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.repository.CuestionarioRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CuestionarioServicioImp implements CuestionarioServicio {

    private final CuestionarioRepository cuestionarioRepository;
    private final CuestionarioToDTOCuestionario testToTestDTO;
    private final DTOCuestionarioToCuestionario dtoCuestionarioToCuestionario;

    public CuestionarioServicioImp(CuestionarioRepository cuestionarioRepository, CuestionarioToDTOCuestionario testToTestDTO , DTOCuestionarioToCuestionario dtoCuestionarioToCuestionario) {

        this.cuestionarioRepository = cuestionarioRepository;
        this.testToTestDTO = testToTestDTO;
        this.dtoCuestionarioToCuestionario = dtoCuestionarioToCuestionario;
    }


    @Override
    public List<DTOCuestionario> getTest() {
        List<DTOCuestionario> tests = new ArrayList<>();
        Iterator<Cuestionario> resultados =  cuestionarioRepository.findAll().iterator();
        while(resultados.hasNext()){
            tests.add( testToTestDTO.convert(resultados.next()));
        }
        return tests;
    }

    @Override
    public DTOCuestionario findById(String id) throws Exception {
        Optional<Cuestionario> testBusqueda = cuestionarioRepository.findById(id);

        if(!testBusqueda.isPresent())
            throw new Exception("No se ha encontrado el Test");

        DTOCuestionario test =  testToTestDTO.convert(testBusqueda.get());
        return test;
    }

    @Override
    public boolean existTest(String id){
        return cuestionarioRepository.findById(id).isPresent();
    }

    @Override
    public DTOCuestionario crearTest(String tipo, String ID) {
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setID(ID);
        cuestionario.setItem(0);
        cuestionario.setOrdenRespuestas(new ArrayList<>());
        cuestionario.setPuntuaciones(new ArrayList<>());
        cuestionario.setPreguntaActual(0);
        cuestionario.setTipo(tipo);
        cuestionario.setVersionPreguntas(0);
        DTOCuestionario dtoCuestionario = testToTestDTO.convert(cuestionarioRepository.save(cuestionario));
        return dtoCuestionario;
    }



    @Override
    public void deleteById(String id) {
        cuestionarioRepository.deleteById(id);
    }

    @Override
    public DTOCuestionario saveTest(DTOCuestionario test) {
        Cuestionario cuestionarioConvertido = dtoCuestionarioToCuestionario.convert(test);
        return testToTestDTO.convert(cuestionarioRepository.save(cuestionarioConvertido));
    }

    @Override
    public void deleteAll() {
        cuestionarioRepository.deleteAll();
    }

}
