package me.ferrandis.TFGPatrones.dao;

import me.ferrandis.TFGPatrones.modelo.Test;

public interface BDTest {

    void CrearTest(String tipo, int id);

    boolean ExisteTest(int id);

    Test getTest(int id);

}
