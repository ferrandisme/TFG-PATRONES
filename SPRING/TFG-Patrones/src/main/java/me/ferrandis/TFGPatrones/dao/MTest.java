package me.ferrandis.TFGPatrones.dao;
import org.springframework.stereotype.Repository;

@Repository("MONGOTest")
public class MTest extends MONGODB implements BDTest{

    public void CrearTest(String tipo, int id) {

    }

    public boolean ExisteTest(int id) {
        return false;
    }
}
