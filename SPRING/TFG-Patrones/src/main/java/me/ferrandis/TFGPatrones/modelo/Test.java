package me.ferrandis.TFGPatrones.modelo;

import java.util.List;

public class Test {

    //Datos almacenables en memoria
    public int resultados [];
    public int item;
    public int preguntaActual;
    //Datos para la busqueda y carga de test
    public int ID;
    public String tipo;
    //Informacion no cambiante
    public List<ItemTest> preguntas;

    public String SiguientePregunta(){
        return preguntas.get(item).getPregunta(preguntaActual);
    }

    public void ActualizarPregunta(int valor){
        resultados[item] = valor;

        AumentarIndices();
        //GuardarEstado();
    }

    private void AumentarIndices(){
        if(item >= preguntas.get(item).preguntas.size()){
            item = 0;
            preguntaActual++;
        }
        else
        {
            item++;
        }
    }

    /*public void GuardarEstado(){
        //GuardarEstado
    }*/
}
