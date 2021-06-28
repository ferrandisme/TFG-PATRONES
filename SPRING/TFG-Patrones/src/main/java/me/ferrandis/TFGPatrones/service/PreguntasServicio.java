package me.ferrandis.TFGPatrones.service;

import me.ferrandis.TFGPatrones.model.Pregunta;

import java.util.List;

public interface PreguntasServicio {

    public static final String ESTRUCTURAL = "ESTRUCTURAL";
    public static final String CREACIONAL = "CREACIONAL";
    public static final String COMPORTAMIENTO = "COMPORTAMIENTO";

    List<Pregunta> getPreguntasTipo(String tipo);
}
