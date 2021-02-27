package me.ferrandis.TFGPatrones.dao;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.stereotype.Repository;

@Repository("MONGOTest")
public class MTest extends MONGODB implements BDTest{

    public void CrearTest(String tipo, int id) {

    }

    public Test getTest(){
        /*
        Patron patron = null;
        connect("patrones");
        try {
            Document nombrePatron = new Document("nombre",nombre);
            Document JSONPatron = (Document) collection.find(nombrePatron).first();
            patron = new Patron();
            patron.nombre = (String) JSONPatron.get("nombre");
            patron.resumen = (String) JSONPatron.get("resumen");
            patron.explicacion = (String) JSONPatron.get("explicacion");
            patron._id = UUID.fromString(  (String) JSONPatron.get("_id"));
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return patron;*/
        Test test = new Test();
        
        return test;
    }

    public boolean ExisteTest(int id) {
        return false;
    }
}
