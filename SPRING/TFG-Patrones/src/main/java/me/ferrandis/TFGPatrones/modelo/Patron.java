package me.ferrandis.TFGPatrones.modelo;
import lombok.Data;
import me.ferrandis.TFGPatrones.modelo.Encapsulaciones.InfoPatron;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Patron {

    public String resumen;
    public String nombre;
    public UUID _id;
    public String explicacion;

    public Patron(String nombre, String resumen, String explicacion){
        this.resumen = resumen;
        this.nombre = nombre;
        this._id = UUID.randomUUID();
        this.explicacion = explicacion;
    }

    public Patron(UUID id,String nombre, String resumen, String explicacion){
        this.resumen = resumen;
        this.nombre = nombre;
        this._id = id;
        this.explicacion = explicacion;
    }

    public Patron(){}

    public List<InfoPatron> procesarResumen(){
        String descripcion[] = explicacion.split("¡ñ");
        List<InfoPatron> informacion = new ArrayList<InfoPatron>();

        for(int i = 0; i < descripcion.length; i ++){
            String tupla[] = descripcion[i].split("¡ç");
            informacion.add(new InfoPatron(tupla[0].trim(),tupla[1].trim()));
        }
        return informacion;
    }

}


