package me.ferrandis.TFGPatrones.dao;

import com.mongodb.client.FindIterable;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("MONGOPatrones")
public class MPatrones extends MONGODB implements BDPatrones{

    public List<Patron> getListaPatrones(){
        List<Patron> patrones = new ArrayList<Patron>();
        connect("patrones");

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

        return patron;
    }
}
