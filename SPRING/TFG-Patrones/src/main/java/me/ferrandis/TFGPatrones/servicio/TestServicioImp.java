package me.ferrandis.TFGPatrones.servicio;
import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.dao.BDPatrones;
import me.ferrandis.TFGPatrones.dao.BDTest;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.modelo.Test;
import me.ferrandis.TFGPatrones.repository.PatronRepository;
import me.ferrandis.TFGPatrones.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class TestServicioImp implements TestServicio{

    private final TestRepository testRepository;

    public TestServicioImp(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public List<Test> getTest() {
        List<Test> tests = new ArrayList<>();
        testRepository.findAll().iterator().forEachRemaining(tests::add);
        return tests;
    }

    @Override
    public Test findById(String id) throws Exception {
        Optional<Test> testBusqueda = testRepository.findById(id);

        if(!testBusqueda.isPresent())
            throw new Exception("No se ha encontrado el Test");

        Test test = testBusqueda.get();
        test.setPreguntas(inicializarPreguntas(test.getTipo()));
        return test;
    }

    @Override
    public boolean existTest(String id){
        return testRepository.findById(id).isPresent();
    }

    @Override
    public Test crearTest(String tipo, String ID) {
        Test test = new Test();
        test.setID(ID);
        test.setItem(0);
        test.setOrdenRespuestas(new ArrayList<>());
        test.setPuntuaciones(new ArrayList<>());
        test.setPreguntas(inicializarPreguntas(tipo));
        test.setPreguntaActual(0);
        test.setTipo(tipo);
        return test;
    }

    private List<ItemTest> inicializarPreguntas(String tipo){
        switch(tipo){
            case "estructural":
                return ItemTest.getTestEstructurales();
            case "creacional":
                return ItemTest.getTestCreacionales();
            default:
                return ItemTest.getTestEstructurales();
        }
    }

    @Override
    public void deleteById(String id) {
        testRepository.deleteById(id);
    }

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }

    /*
    private final BDTest BDTest;

    @Autowired
    public TestServicioImp(@Qualifier("MONGOTest") BDTest dao) {
        this.BDTest = dao;
    }

    public Test CrearTest(String tipo, int id){
        return BDTest.crearTest(tipo,id);
    }

    public boolean ExisteTest(int id){
        return BDTest.existeTest(id);
    }

    public Test CargarTest(int id, String tipo){
        return BDTest.getTest(id);
    }

    public void actualizarTest(Test test){
         BDTest.actualizarTest(test);
    }
    //NOTA: Deberia de hacerse un servicio que elimine los test cada X tiempo en el futuro
    /*public void borrarTest(int id){

    }*/
}
