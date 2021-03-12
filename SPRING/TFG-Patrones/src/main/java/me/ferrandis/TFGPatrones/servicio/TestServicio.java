package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.modelo.Test;

import java.util.List;

public interface TestServicio {

    List<Test> getTest();

    Test findById(String id) throws Exception;

    boolean existTest(String id);

    //Faltan los metodos para obtener DTO

    void deleteById(String id);
}
