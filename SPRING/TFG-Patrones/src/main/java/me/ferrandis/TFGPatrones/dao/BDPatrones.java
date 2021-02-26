package me.ferrandis.TFGPatrones.dao;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.modelo.Test;

import java.util.List;

public interface BDPatrones {

    List<Patron> getListaPatrones();

    Patron getPatron(String nombre);
}
