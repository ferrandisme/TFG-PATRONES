package me.ferrandis.TFGPatrones.dao;

import com.mongodb.client.*;
import com.mongodb.client.internal.MongoClientImpl;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.stereotype.Repository;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

@Repository("MONGODB")
public class MONGODB implements BaseDatos{

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection collection;


    public void connect(){
        try {
            mongoClient = MongoClients.create();
            database = mongoClient.getDatabase("TFG");
            collection = database.getCollection("patrones");
        }
        catch (Exception e){
            System.err.println("Algo ha ido mal al crear el socket");
            e.printStackTrace();
        }
    }


    public List<Patron> getListaPatrones(){
        List<Patron> patrones = new ArrayList<Patron>();
        connect();

        try {
            FindIterable iterable  = collection.find();

            for(Object rawJSON : collection.find()){
                Document json = (Document) rawJSON;
                Patron patron = new Patron();
                patron.nombre = (String) json.get("nombre");
                patron.resumen = (String) json.get("resumen");
                patron.id = (int) json.get("id");
                patrones.add(patron);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println("Busqueda Finalizada por ");
        }

        return patrones;
    }
}
