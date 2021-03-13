package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;

import java.util.List;

public interface TestServicio {

    List<DTOCuestionario> getTest();

    DTOCuestionario findById(String id) throws Exception;

    boolean existTest(String id);

    DTOCuestionario crearTest(String tipo, String ID);

    //Faltan los metodos para obtener DTO

    void deleteById(String id);

    DTOCuestionario saveTest(DTOCuestionario test);

    void deleteAll();
}
