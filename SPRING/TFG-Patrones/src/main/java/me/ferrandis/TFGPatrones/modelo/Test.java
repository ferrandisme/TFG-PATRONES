package me.ferrandis.TFGPatrones.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.ferrandis.TFGPatrones.Encapsulaciones.InfoTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Test {

    //Datos almacenables en memoria
    public List<Float> puntuaciones;
    public int item;
    public int preguntaActual;
    //Datos para la busqueda y carga de test
    @Id
    public String ID;
    public String tipo;
    public List<Integer> ordenRespuestas;

    //Informacion no cambiante
    @Transient
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
