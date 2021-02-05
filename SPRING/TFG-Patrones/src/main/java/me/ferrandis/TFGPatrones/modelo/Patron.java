package me.ferrandis.TFGPatrones.modelo;
import lombok.Data;

@Data
public class Patron {

    public Patron(int id, String nombre, String resumen){
        this.resumen = resumen;
        this.nombre = nombre;
        this.id = id;
    }

    public Patron(){}


    public String resumen;
    public String nombre;
    public int id;
}
