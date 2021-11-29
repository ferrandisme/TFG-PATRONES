package me.ferrandis.TFGPatrones.model;

import lombok.Data;
import me.ferrandis.TFGPatrones.DTO.DTOPregunta;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
public class Cuestionario {

    /*
    //Datos almacenables en memoria
    public List<Float> puntuaciones;
    public int item;
    public int preguntaActual;
    //Datos para la busqueda y carga de test
    @Id
    public String ID;
    public String tipo;
    public List<Integer> ordenRespuestas;
    public int VersionPreguntas;*/


    @Id
    public String ID;
    List<DTOPregunta> preguntas;
    List<String> respuestas;
    Integer versionPreguntas;
    boolean finalizado;
    LocalDate fechaCreacion;
    String resultado;
    boolean encontrado;
}
