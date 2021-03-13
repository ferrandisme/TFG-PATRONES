package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.DTO.DTOTest;
import me.ferrandis.TFGPatrones.modelo.Test;

import java.util.List;

public interface TestServicio {

    List<DTOTest> getTest();

    DTOTest findById(String id) throws Exception;

    boolean existTest(String id);

    DTOTest crearTest(String tipo, String ID);

    //Faltan los metodos para obtener DTO

    void deleteById(String id);

    DTOTest saveTest(DTOTest test);

    void deleteAll();
}
