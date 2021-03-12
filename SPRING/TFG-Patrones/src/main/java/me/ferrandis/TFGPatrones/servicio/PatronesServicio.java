package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.modelo.Test;

import java.util.List;

public interface PatronesServicio {

    List<Patron> getPatrones();

    Patron findById(String id) throws Exception;

    //Faltan los metodos para obtener DTO

    Patron savePatron(Patron patron);

    void deleteById(String id);

    void deleteAll();
}
