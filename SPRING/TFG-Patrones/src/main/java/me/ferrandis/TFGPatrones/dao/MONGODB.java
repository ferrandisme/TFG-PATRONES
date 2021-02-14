package me.ferrandis.TFGPatrones.dao;

import com.mongodb.client.*;
import com.mongodb.client.internal.MongoClientImpl;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.stereotype.Repository;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                patron.explicacion = (String) json.get("explicacion");
                patron._id = UUID.fromString( (String) json.get("_id"));
                patrones.add(patron);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println("Busqueda Finalizada por ");
        }

        return patrones;
    }

    public Patron getPatron(String nombre){
        Patron patron = null;
        connect();
        try {
            Document nombrePatron = new Document("nombre",nombre);
            Document JSONPatron = (Document) collection.find(nombrePatron).first();
            patron = new Patron();
            patron.nombre = (String) JSONPatron.get("nombre");
            patron.resumen = (String) JSONPatron.get("resumen");
            patron.explicacion = (String) JSONPatron.get("explicacion");
            patron._id = UUID.fromString(  (String) JSONPatron.get("_id"));
        }
        /*catch(ClassCastException e){
            patron._id = UUID.randomUUID();
            System.out.println("La UUID es incorrecta. Solucionando el problema en MongoDB con UUID " + patron._id);
            Document nombrePatron = new Document("nombre",nombre);
            Document JSONPatron = (Document) collection.find(nombrePatron).first();
            collection.findOneAndDelete(nombrePatron);
            JSONPatron.remove("_id");
            JSONPatron.append("_id",patron._id);
        }*/
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return patron;
    }
}
