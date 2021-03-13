package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ferrandis.TFGPatrones.modelo.ItemCuestionario;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOCuestionario {

    public List<Float> puntuaciones;
    public int item;
    public int preguntaActual;

    public String ID;
    public String tipo;
    public List<Integer> ordenRespuestas;

    //Informacion no cambiante
    public List<ItemCuestionario> preguntas;

    public int VersionPreguntas;

    public class InformacionTest {
        public float puntuacion;
        public String nombre;
    }



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

    public List<DTOInfoCuestionario> ObtenerResultados(){
        List<DTOInfoCuestionario> resultados = new ArrayList<>();

        for(int i = 0; i < puntuaciones.size(); i++)
        {
            resultados.add(new DTOInfoCuestionario(preguntas.get(i).nombre, puntuaciones.get(i) ));
        }

        resultados.sort(DTOInfoCuestionario::compareTo);
        return resultados;
    }

}
