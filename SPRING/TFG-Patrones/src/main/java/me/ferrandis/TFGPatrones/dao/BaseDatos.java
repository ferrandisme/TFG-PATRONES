package me.ferrandis.TFGPatrones.dao;
import me.ferrandis.TFGPatrones.modelo.Patron;
import java.util.List;

public interface BaseDatos {
    List<Patron> getListaPatrones();

    Patron getPatron(String nombre);
}
