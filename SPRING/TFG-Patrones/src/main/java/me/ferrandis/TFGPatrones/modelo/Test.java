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
    public List<Integer> ordenRespuestas;
    //Informacion no cambiante
    public List<ItemTest> preguntas;

    public String SiguientePregunta(){
        if(item < preguntas.size())
            return preguntas.get(item).getPregunta(preguntaActual);
        else
            return null;
    }

    public void ActualizarPregunta(int valor){
        ordenRespuestas.add(valor);
        //float res = valor / (1f/ preguntas.get(item).preguntas.size());
        float res = valor;
        if(puntuaciones.size() <= item) {
            puntuaciones.add(res / preguntas.get(item).preguntas.size());
        }
        else {
            //puntuaciones.set(item, puntuaciones.get(item) + res);
            System.out.println( puntuaciones.get(item));
            float actual = puntuaciones.get(item).floatValue() ;
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
        List<InfoTest> resultados = new ArrayList<>();

        for(int i = 0; i < puntuaciones.size(); i++)
        {
            resultados.add(new InfoTest(preguntas.get(i).nombre, puntuaciones.get(i) ));
        }

        resultados.sort(InfoTest::compareTo);
        return resultados;
    }
}
