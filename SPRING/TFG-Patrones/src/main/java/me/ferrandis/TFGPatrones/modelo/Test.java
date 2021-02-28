package me.ferrandis.TFGPatrones.modelo;

import me.ferrandis.TFGPatrones.modelo.Encapsulaciones.InfoTest;

import java.util.ArrayList;
import java.util.List;

public class Test {

    //Datos almacenables en memoria
    public List<Float> puntuaciones;
    public int item;
    public int preguntaActual;
    //Datos para la busqueda y carga de test
    public int ID;
    public String tipo;
    //Informacion no cambiante
    public List<ItemTest> preguntas;

    public String SiguientePregunta(){
        if(item < preguntas.size())
            return preguntas.get(item).getPregunta(preguntaActual);
        else
            return null;
    }

    public void ActualizarPregunta(float valor){
        //float res = valor / (1f/ preguntas.get(item).preguntas.size());
        float res = valor;
        if(puntuaciones.size() <= item) {
            puntuaciones.add(res / preguntas.get(item).preguntas.size());
        }
        else {
            //puntuaciones.set(item, puntuaciones.get(item) + res);
            float actual = puntuaciones.get(item);
            //res = Math.max(actual,res);
            puntuaciones.set(item, actual + res / preguntas.get(item).preguntas.size());
        }
        AumentarIndices();
    }

    private void AumentarIndices(){
        if(preguntaActual + 1 >= preguntas.get(item).preguntas.size()){
            item++;
            preguntaActual = 0;
        }
        else
        {
            preguntaActual++;
        }
    }

    public List<InfoTest> getPuntuaciones(){
        //long startTime = System.nanoTime();
        List<InfoTest> resultados = new ArrayList<>();

        for(int i = 0; i < puntuaciones.size(); i++)
        {
            resultados.add(new InfoTest(preguntas.get(i).nombre, puntuaciones.get(i) , ""));
        }

        resultados.sort(InfoTest::compareTo);

        //long endTime = System.nanoTime();
        //long time = endTime - startTime;
        //System.out.println("Se ha calculado el ganador del test en " + (time/1000000000) + " segundos (" + (time/1000000) +" ms)");

        return resultados;
    }
}
