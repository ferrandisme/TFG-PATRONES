package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.DTO.DTOPatron;

import java.util.List;

public interface PatronesServicio {

    List<DTOPatron> getPatrones();

    DTOPatron findById(String id) throws Exception;

    //Faltan los metodos para obtener DTO

    DTOPatron savePatron(DTOPatron patron);

    void deleteById(String id);

    void deleteAll();
}
