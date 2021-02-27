package me.ferrandis.TFGPatrones.dao;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.stereotype.Repository;
import com.mongodb.client.FindIterable;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository("MONGOTest")
public class MTest extends MONGODB implements BDTest{

    public Test crearTest(String tipo, int id) {
        Test test = new Test();
        int resultados[];

        switch(tipo){
            case "estructural":
                test.preguntas  = ItemTest.getTestEstructurales();
                break;
            case "creacional":
                //TODO
                break;
            case "comportamiento":
                //TODO
                break;
        }

        connect("test-usuarios");
        try {
            Document testJSON = new Document("_id", id)
                    .append("tipo", tipo)
                    .append("preguntaActual",0)
                    .append("item",0)
                    .append("resultados", new ArrayList<Integer>());

            test.item = 0;
            test.resultados = new ArrayList<Integer>();
            test.preguntaActual = 0;
            test.ID = id;
            test.tipo = tipo;
            collection.insertOne(testJSON);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return test;
    }

    public void actualizarTest(Test test){
        connect("test-usuarios");
        try {
            Document testJSON = new Document("_id", test.ID)
                    .append("tipo", test.tipo)
                    .append("preguntaActual",test.preguntaActual)
                    .append("item",test.item)
                    .append("resultados",test.resultados);

            Document idTest = new Document("_id",test.ID);
            collection.replaceOne(idTest,testJSON);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public Test getTest(int id){
        Test test = null;
        connect("test-usuarios");
        try {
            Document idTest = new Document("_id",id);
            Document JSONTest = (Document) collection.find(idTest).first();
            test = new Test();
            test.preguntaActual = (int) JSONTest.get("preguntaActual");
            test.resultados = (ArrayList<Integer>) JSONTest.get("resultados");
            test.item = (int) JSONTest.get("item");
            test.tipo = (String) JSONTest.get("tipo");
            test.ID = (int) JSONTest.get("id");
            test.ID = id;
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return test;
    }

    public boolean existeTest(int id) {
        Test test = getTest(id);
        return  test != null && test.tipo != null;
    }
}
