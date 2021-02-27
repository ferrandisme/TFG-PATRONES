package me.ferrandis.TFGPatrones.dao;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.stereotype.Repository;
import com.mongodb.client.FindIterable;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository("MONGOTest")
public class MTest extends MONGODB implements BDTest{

    public void CrearTest(String tipo, int id) {

    }

    public Test getTest(int id){
        Test test = null;
        connect("test-usuarios");
        try {
            Document idTest = new Document("id",id);
            Document JSONTest = (Document) collection.find(idTest).first();
            test = new Test();
            test.preguntaActual = (int) JSONTest.get("preguntaActual");
            test.resultados = (int[]) JSONTest.get("resultados");
            test.item = (int) JSONTest.get("item");
            test.tipo = (String) JSONTest.get("tipo");
            test.ID = (int) JSONTest.get("id");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return test;
    }

    public boolean ExisteTest(int id) {
        return false;
    }
}
