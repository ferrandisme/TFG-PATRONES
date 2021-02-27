package me.ferrandis.TFGPatrones.servicio;
import me.ferrandis.TFGPatrones.dao.BDPatrones;
import me.ferrandis.TFGPatrones.dao.BDTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestServicio {

    private final BDTest BDTest;

    @Autowired
    public TestServicio(@Qualifier("MONGOTest") BDTest dao) {
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
