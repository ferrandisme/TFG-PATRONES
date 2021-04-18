package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;

import java.util.List;

public interface CuestionarioServicio {

    public static final String TIPO = "TIPO:";
    public static final String SOLUCION = "SOLUCION:";

    List<DTOCuestionario> getTest();

    DTOCuestionario findById(String id) throws Exception;

    boolean existTest(String id);

    DTOCuestionario crearTest(String id);

    void deleteById(String id);

    DTOCuestionario saveTest(DTOCuestionario test);

    void deleteAll();

    String getSiguientePregunta(String id, Integer opcion);
}
