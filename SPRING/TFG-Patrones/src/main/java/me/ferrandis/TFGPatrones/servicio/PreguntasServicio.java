package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.modelo.Pregunta;

import java.util.List;

public interface PreguntasServicio {

    public static final String ESTRUCTURAL = "ESTRUCTURAL";
    public static final String CREACIONAL = "CREACIONAL";
    public static final String COMPORTAMIENTO = "COMPORTAMIENTO";

    List<Pregunta> getPreguntasTipo(String tipo);
}
