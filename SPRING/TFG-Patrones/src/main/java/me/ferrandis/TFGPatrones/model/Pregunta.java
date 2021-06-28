package me.ferrandis.TFGPatrones.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta implements Comparable<Pregunta>{

    @Id
    public String ID;
    Integer orden;
    String texto;
    List<String> resultado;
    String tipo;

    @Override
    public int compareTo(Pregunta p) {
        return this.orden.compareTo(p.getOrden());
    }
}
