package me.ferrandis.TFGPatrones.servicio;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.converters.DTOCuestionarioToCuestionario;
import me.ferrandis.TFGPatrones.converters.CuestionarioToDTOCuestionario;
import me.ferrandis.TFGPatrones.modelo.Cuestionario;
import me.ferrandis.TFGPatrones.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CuestionarioServicioImp implements CuestionarioServicio {

    private final TestRepository testRepository;
    private final CuestionarioToDTOCuestionario testToTestDTO;
    private final DTOCuestionarioToCuestionario dtoCuestionarioToCuestionario;

    public CuestionarioServicioImp(TestRepository testRepository , CuestionarioToDTOCuestionario testToTestDTO , DTOCuestionarioToCuestionario dtoCuestionarioToCuestionario) {

        this.testRepository = testRepository;
        this.testToTestDTO = testToTestDTO;
        this.dtoCuestionarioToCuestionario = dtoCuestionarioToCuestionario;
    }


    @Override
    public List<DTOCuestionario> getTest() {
        List<DTOCuestionario> tests = new ArrayList<>();
        Iterator<Cuestionario> resultados =  testRepository.findAll().iterator();
        while(resultados.hasNext()){
            tests.add( testToTestDTO.convert(resultados.next()));
        }
        return tests;
    }

    @Override
    public DTOCuestionario findById(String id) throws Exception {
        Optional<Cuestionario> testBusqueda = testRepository.findById(id);

        if(!testBusqueda.isPresent())
            throw new Exception("No se ha encontrado el Test");

        DTOCuestionario test =  testToTestDTO.convert(testBusqueda.get());
        return test;
    }

    @Override
    public boolean existTest(String id){
        return testRepository.findById(id).isPresent();
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
        DTOCuestionario dtoCuestionario = testToTestDTO.convert(testRepository.save(cuestionario));
        return dtoCuestionario;
    }



    @Override
    public void deleteById(String id) {
        testRepository.deleteById(id);
    }

    @Override
    public DTOCuestionario saveTest(DTOCuestionario test) {
        Cuestionario cuestionarioConvertido = dtoCuestionarioToCuestionario.convert(test);
        return testToTestDTO.convert(testRepository.save(cuestionarioConvertido));
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }

}
