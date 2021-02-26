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

    public void CrearTest(String tipo, int id){
        System.out.println("Creando el test " + id + " de tipo " + tipo);
        //Nota: Habria que refactorizar la DB en algun momento y separar MongoPatrones de MongoTest y crear
        //una clase mongo main con metodos estaticos que ayuden a trabajar con las bases de datos.
    }

    public boolean ExisteTest(int id){
        return false;
    }

    //El tipo se envia con objetivo de evitar incosistencias en caso de una ID erroneo
    public Test CargarTest(int id, String tipo){
        return null;
    }

    /*public void borrarTest(int id){

    }*/
}
