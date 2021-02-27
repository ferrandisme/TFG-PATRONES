package me.ferrandis.TFGPatrones.modelo;

import java.util.List;

public class Test {

    //Datos almacenables en memoria
    public List<Integer> resultados;
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

    public void ActualizarPregunta(int valor){
        if(resultados.size() <= valor)
            resultados.add(valor);
        else
            resultados.set(item, resultados.get(item) + valor);
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

}
