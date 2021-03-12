package me.ferrandis.TFGPatrones.dao;
import com.mongodb.client.*;

@Deprecated
public class MONGODB  {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection collection;


    public void connect(String coleccion){
        try {
            mongoClient = MongoClients.create();
            database = mongoClient.getDatabase("TFG");
            collection = database.getCollection(coleccion);
        }
        catch (Exception e){
            System.err.println("Algo ha ido mal al crear el socket");
            e.printStackTrace();
        }
    }

}
