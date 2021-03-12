package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.modelo.Patron;

import java.util.List;

public interface PatronesServicio {

    List<Patron> getRecipes();

    Patron findById(String id) throws Exception;

    //Faltan los metodos para obtener DTO

    void deleteById(String id);
}
