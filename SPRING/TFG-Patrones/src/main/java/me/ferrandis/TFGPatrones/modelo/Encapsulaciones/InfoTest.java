package me.ferrandis.TFGPatrones.modelo.Encapsulaciones;

public class InfoTest {
    public float puntuacion;
    public String nombre;

    public InfoTest(String nombre,float puntuacion){
        this.puntuacion = puntuacion;
        this.nombre = nombre;
    }

    //Diseñado de forma contraria a lo que se consideraria natural en java, ya que intenta premiar un numero mas alto en el algoritmo de ordenacion como mejor
    public int compareTo(InfoTest o) {
        return Math.round(o.puntuacion - this.puntuacion);
    }
}
