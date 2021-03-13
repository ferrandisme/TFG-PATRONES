package me.ferrandis.TFGPatrones.DTO;

public class DTOInfoCuestionario {
    public float puntuacion;
    public String nombre;

    public DTOInfoCuestionario(String nombre, float puntuacion){
        this.puntuacion = puntuacion;
        this.nombre = nombre;
    }

    //Diseñado de forma contraria a lo que se consideraria natural en java, ya que intenta premiar un numero mas alto en el algoritmo de ordenacion como mejor
    public int compareTo(DTOInfoCuestionario o) {
        return Math.round(o.puntuacion - this.puntuacion);
    }
}
