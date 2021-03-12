package me.ferrandis.TFGPatrones.dao;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Repository;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


@Deprecated
@Repository("MONGOTest")
public class MTest extends MONGODB implements BDTest{

    public Test crearTest(String tipo, int id) {
        Test test = new Test();


        test.preguntas = cargarPreguntas(tipo);

        connect("test-usuarios");
        try {
            Document testJSON = new Document("_id", id)
                    .append("tipo", tipo)
                    .append("preguntaActual",0)
                    .append("item",0)
                    .append("puntuaciones", new ArrayList<Float>());

            test.item = 0;
            test.puntuaciones = new ArrayList<Float>();
            test.preguntaActual = 0;
            //test.ID = id;
            test.tipo = tipo;
            test.ordenRespuestas = new ArrayList<Integer>();
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
                    .append("puntuaciones",test.puntuaciones)
                    .append("ordenRespuestas",test.ordenRespuestas);

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
            if(JSONTest == null)
                return null;


            test.preguntaActual = (int) JSONTest.get("preguntaActual");
            test.puntuaciones = (ArrayList<Float>) JSONTest.get("puntuaciones");
            test.item = (int) JSONTest.get("item");
            test.tipo = (String) JSONTest.get("tipo");
            test.ordenRespuestas = (ArrayList<Integer>) JSONTest.get("ordenRespuestas");
            test.preguntas = cargarPreguntas(test.tipo);
            //test.ID = (int) JSONTest.get("_id");
            //test.ID = id;
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


    private List<ItemTest> cargarPreguntas(String tipo){
        switch(tipo){
            case "estructural":
                return ItemTest.getTestEstructurales();
            case "creacional":
                return ItemTest.getTestCreacionales();
            default:
                return ItemTest.getTestEstructurales();
        }
    }
}
