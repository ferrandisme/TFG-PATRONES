package me.ferrandis.TFGPatrones.modelo;
import lombok.Data;

import java.util.UUID;

@Data
public class Patron {

    public Patron(String nombre, String resumen){
        this.resumen = resumen;
        this.nombre = nombre;
        this._id = UUID.randomUUID();
    }

    public Patron(UUID id,String nombre, String resumen){
        this.resumen = resumen;
        this.nombre = nombre;
        this._id = id;
    }

    public Patron(){}


    public String resumen;
    public String nombre;
    public UUID _id;
}
