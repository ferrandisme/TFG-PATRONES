package me.ferrandis.TFGPatrones.servicio;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.converters.DTOTestToTest;
import me.ferrandis.TFGPatrones.converters.TestToDTOTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import me.ferrandis.TFGPatrones.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class TestServicioImp implements TestServicio{

    private final TestRepository testRepository;
    private final TestToDTOTest testToTestDTO;
    private final DTOTestToTest dtoTestToTest;

    public TestServicioImp(TestRepository testRepository , TestToDTOTest testToTestDTO , DTOTestToTest dtoTestToTest) {

        this.testRepository = testRepository;
        this.testToTestDTO = testToTestDTO;
        this.dtoTestToTest = dtoTestToTest;
    }


    @Override
    public List<DTOCuestionario> getTest() {
        List<DTOCuestionario> tests = new ArrayList<>();
        Iterator<Test> resultados =  testRepository.findAll().iterator();
        while(resultados.hasNext()){
            tests.add( testToTestDTO.convert(resultados.next()));
        }
        return tests;
    }

    @Override
    public DTOCuestionario findById(String id) throws Exception {
        Optional<Test> testBusqueda = testRepository.findById(id);

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
        Test test = new Test();
        test.setID(ID);
        test.setItem(0);
        test.setOrdenRespuestas(new ArrayList<>());
        test.setPuntuaciones(new ArrayList<>());
        test.setPreguntaActual(0);
        test.setTipo(tipo);
        test.setVersionPreguntas(0);
        DTOCuestionario dtoCuestionario = testToTestDTO.convert(testRepository.save(test));
        return dtoCuestionario;
    }



    @Override
    public void deleteById(String id) {
        testRepository.deleteById(id);
    }

    @Override
    public DTOCuestionario saveTest(DTOCuestionario test) {
        Test testConvertido = dtoTestToTest.convert(test);
        return testToTestDTO.convert(testRepository.save(testConvertido));
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }

}
