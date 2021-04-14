package me.ferrandis.TFGPatrones.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patron {

    public String resumen;
    @Id
    public String nombre;

    List<String> textoExplicacion;
    List<String> URLImagenes;

    List<String> documentacion;

    List<String> sinergias;

   /* public List<InfoPatron> procesarResumen(){
        List<InfoPatron> informacion = new ArrayList<InfoPatron>();
        if(explicacion == null || !explicacion.contains("¡ñ"))
            return informacion;
        String descripcion[] = explicacion.split("¡ñ");

        for(int i = 0; i < descripcion.length; i ++){
            String tupla[] = descripcion[i].split("¡ç");
            informacion.add(new InfoPatron(tupla[0].trim(),tupla[1].trim()));
        }
        return informacion;
    }*/

}


