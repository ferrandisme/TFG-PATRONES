package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.modelo.Pregunta;

import java.util.List;

public interface PreguntasServicio {
    List<Pregunta> getPreguntasTipo(String tipo);
}
