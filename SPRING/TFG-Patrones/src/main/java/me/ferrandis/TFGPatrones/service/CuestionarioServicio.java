package me.ferrandis.TFGPatrones.service;

import me.ferrandis.TFGPatrones.DTO.DTOCuestionario;
import me.ferrandis.TFGPatrones.DTO.DTOEstadoCuestionario;

import java.util.List;

public interface CuestionarioServicio {

    public static final String TIPO = "TIPO:";
    public static final String SOLUCION = "SOLUCION:";
    public static final String ELIMINAR = "ELIMINAR:";
    public static final String ENCONTRAR_TIPO = "ENCONTRARTIPO";

    List<DTOCuestionario> getTest();

    DTOCuestionario findById(String id) throws Exception;

    boolean existTest(String id);

    DTOCuestionario crearTest(String id);

    void deleteById(String id);

    DTOCuestionario saveTest(DTOCuestionario test);

    void deleteAll();

    DTOEstadoCuestionario getSiguientePregunta(String id, Integer opcion);
}
