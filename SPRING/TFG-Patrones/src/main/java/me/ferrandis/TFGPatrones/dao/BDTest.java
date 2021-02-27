package me.ferrandis.TFGPatrones.dao;

import me.ferrandis.TFGPatrones.modelo.Test;

public interface BDTest {

    Test crearTest(String tipo, int id);

    boolean existeTest(int id);

    Test getTest(int id);

    void actualizarTest(Test test);

}
